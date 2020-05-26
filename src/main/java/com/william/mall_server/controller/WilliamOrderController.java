package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamOrderService;
import com.william.pojo.WilliamOrder;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.OrderDetailResp;
import com.william.pojo.resp.OrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单表
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/25 12:02
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/order")
public class WilliamOrderController {

    @Autowired
    private WilliamOrderService williamOrderService;

    /**
     * 删除订单
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : void
     */
    @DeleteMapping(value = "/deleteOrder")
    public void deleteOrder(@RequestBody PublicReq publicReq,@RequestParam("uid")String uid){
        williamOrderService.deleteOrder(publicReq,uid);
    }


    /**
     * 订单详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.resp.OrderDetailResp
     */
    @PostMapping(value = "/getOrderDetail")
    public OrderDetailResp getOrderDetail(@RequestBody PublicReq publicReq, @RequestParam("uid") String uid){
        return williamOrderService.getOrderDetail(publicReq,uid);
    }


    /**
     * 状态查询我的订单 1 待付款 2 待发货 3 待收货
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamOrder>
     */
    @PostMapping(value = "/getOrderListByStatus")
    public List<OrderResp> getOrderListByStatus(@RequestBody PageConditionReq pageConditionReq, @RequestParam("uid")String uid){
        return williamOrderService.getOrderListByStatus(pageConditionReq,uid);
    }
}
