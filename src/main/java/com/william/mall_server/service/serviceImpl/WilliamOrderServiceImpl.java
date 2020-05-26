package com.william.mall_server.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.william.mall_server.mapper.WilliamOrderMapper;
import com.william.mall_server.service.WilliamOrderService;
import com.william.pojo.WilliamOrder;
import com.william.pojo.WilliamOrderExample;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.OrderDetailResp;
import com.william.pojo.resp.OrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 13:52
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamOrderServiceImpl implements WilliamOrderService {

    @Autowired
    private WilliamOrderMapper williamOrderMapper;


    /**
     * 根据订单状态,获取订单列表 分页
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamOrder>
     */
    @Override
    public List<OrderResp> getOrderListByStatus(PageConditionReq pageConditionReq, String uid) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        // 订单状态 空为全部 0 全部 1未付款,2已付款,3已发货
        String orderStatus = pageConditionReq.getKeyName();
        PageHelper.startPage(startPage,pageSize,false);
        return williamOrderMapper.getOrderListByStatus(orderStatus,uid,pageConditionReq.getTenantId(),pageConditionReq.getClient());
    }

    /**
     * 订单详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.resp.OrderDetailResp
     */
    @Override
    public OrderDetailResp getOrderDetail(PublicReq publicReq, String uid) {
        return null;
    }


    /**
     * 删除订单
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : void
     */
    @Override
    public void deleteOrder(PublicReq publicReq,String uid) {
        WilliamOrderExample williamOrderExample = new WilliamOrderExample();
        WilliamOrderExample.Criteria criteria = williamOrderExample.createCriteria();
        criteria.andOrderIdEqualTo(publicReq.getKeyName());
        WilliamOrder williamOrder = new WilliamOrder();
        williamOrder.setStatus(2);
        williamOrder.setDeleteId(uid);
        williamOrder.setDeleteTime(new Date());
        williamOrderMapper.updateByExampleSelective(williamOrder,williamOrderExample);
    }
}
