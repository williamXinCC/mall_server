package com.william.mall_server.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.william.mall_server.mapper.WilliamCouponCustomerMapper;
import com.william.mall_server.service.WilliamCouponService;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CustomerCouponListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<CustomerCouponListResp> getCouponByType(PageConditionReq pageConditionReq, String uid) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        PageHelper.startPage(startPage,pageSize,false);
        return williamCouponCustomerMapper.getCouponByType(pageConditionReq.getKeyName(),uid);
    }
}
