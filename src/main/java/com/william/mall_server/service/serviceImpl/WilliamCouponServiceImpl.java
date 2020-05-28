package com.william.mall_server.service.serviceImpl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.william.constant.Constant;
import com.william.mall_server.mapper.WilliamCouponCustomerMapper;
import com.william.mall_server.mapper.WilliamCouponMapper;
import com.william.mall_server.mapper.WilliamCustomerMapper;
import com.william.mall_server.service.WilliamCouponService;
import com.william.pojo.*;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CustomerCouponResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 13:32
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamCouponServiceImpl implements WilliamCouponService {

    @Autowired
    private WilliamCouponCustomerMapper williamCouponCustomerMapper;

    @Autowired
    private WilliamCouponMapper williamCouponMapper;

    @Autowired
    private WilliamCustomerMapper williamCustomerMapper;

    /**
     * 我的优惠券列表
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponResp>
     */
    @Override
    public List<CustomerCouponResp> getCouponByType(PageConditionReq pageConditionReq, String uid) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        PageHelper.startPage(startPage,pageSize,false);
        return williamCouponCustomerMapper.getCouponByType(pageConditionReq.getKeyName(),uid);
    }


    /**
     * 领券中信列表
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponResp>
     */
    @Override
    public List<WilliamCoupon> getCouponCenter(BaseRequest baseRequest, String uid) {
        WilliamCustomer williamCustomer = williamCustomerMapper.selectByPrimaryKey(uid);
        String tenantId = baseRequest.getTenantId();
        String client = baseRequest.getClient();
        WilliamCouponExample williamCouponExample = new WilliamCouponExample();
        WilliamCouponExample.Criteria criteria = williamCouponExample.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andClientEqualTo(client);
        criteria.andStatusNotEqualTo(3);
        List<Integer> memberLevel = new ArrayList<>();
        memberLevel.add(0);
        memberLevel.add(williamCustomer.getOfficialStatus());
        criteria.andMemberLevelIn(memberLevel);
        williamCouponExample.setOrderByClause("id desc");
        List<WilliamCoupon> williamCouponList = williamCouponMapper.selectByExample(williamCouponExample);
        // 过滤已领取优惠券
        List<WilliamCoupon> collect = williamCouponList.stream().filter(e -> {
                    Long id = e.getId();
                    WilliamCouponCustomer williamCouponCustomer = williamCouponCustomerMapper.selectByCustomerIdAndCouponId(uid, id);
                    if (Objects.nonNull(williamCouponCustomer)) {
                        return false;
                    }
                    return true;
                }
        ).collect(Collectors.toList());
        return collect;
    }


    /**
     * 优惠券详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.resp.CustomerCouponResp
     */
    @Override
    public CustomerCouponResp getCouponDetail(PublicReq publicReq, String uid) {
        return williamCouponCustomerMapper.getCouponDetail(publicReq.getKeyName());
    }

    /**
     * 领取保存我的优惠券
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @Override
    public Integer saveCoupon(PublicReq publicReq, String uid) {
        WilliamCouponCustomerExample williamCouponCustomerExample = new WilliamCouponCustomerExample();
        WilliamCouponCustomerExample.Criteria criteria = williamCouponCustomerExample.createCriteria();
        criteria.andMemberIdEqualTo(uid);
        criteria.andCouponIdEqualTo(Long.valueOf(publicReq.getKeyName()));
        List<WilliamCouponCustomer> williamCouponCustomers = williamCouponCustomerMapper.selectByExample(williamCouponCustomerExample);
        if(CollectionUtil.isNotEmpty(williamCouponCustomers)){
            return 2;
        }
        WilliamCoupon williamCoupon = williamCouponMapper.selectByPrimaryKey(Long.valueOf(publicReq.getKeyName()));
        WilliamCouponCustomer williamCouponCustomer = new WilliamCouponCustomer();
        williamCouponCustomer.setCouponId(williamCoupon.getId());
        williamCouponCustomer.setMemberId(uid);
        williamCouponCustomer.setGetTime(new Date());
        williamCouponCustomer.setGetType(2);
        williamCouponCustomer.setCouponValue(williamCoupon.getCouponTypeValue());
        williamCouponCustomerMapper.insertSelective(williamCouponCustomer);
        return 1;
    }

    /**
     * 删除已过期优惠券
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : void
     */
    @Override
    public void deleteExpireCoupon(BaseRequest baseRequest, String uid) {
        WilliamCouponCustomerExample williamCouponCustomerExample = new WilliamCouponCustomerExample();
        WilliamCouponCustomerExample.Criteria criteria = williamCouponCustomerExample.createCriteria();
        criteria.andMemberIdEqualTo(uid);
        WilliamCouponCustomer williamCouponCustomer = new WilliamCouponCustomer();
        williamCouponCustomer.setStatus(Constant.STATUS_TWO_UNUSE);
        williamCouponCustomerMapper.updateByExampleSelective(williamCouponCustomer,williamCouponCustomerExample);
    }
}
