package com.william.mall_server.service;

import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.OrderDetailResp;
import com.william.pojo.resp.OrderResp;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 13:52
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamOrderService {

    List<OrderResp> getOrderListByStatus(PageConditionReq pageConditionReq, String uid);

    OrderDetailResp getOrderDetail(PublicReq publicReq, String uid);

    void deleteOrder(PublicReq publicReq,String uid);
}
