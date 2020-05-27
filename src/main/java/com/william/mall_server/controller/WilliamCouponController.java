package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamCouponService;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CustomerCouponListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 10:46
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/coupon")
public class WilliamCouponController {

    @Autowired
    private WilliamCouponService williamCouponService;

    /**
     * 我的优惠券
     * @author     xinchuang
     * @param pageConditionReq:
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponListResp>
     */
    @PostMapping(value = "/getCouponByType")
    public List<CustomerCouponListResp> getCouponByType(@RequestBody PageConditionReq pageConditionReq, @RequestParam("uid")String uid){
        return williamCouponService.getCouponByType(pageConditionReq,uid);
    }
}
