package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamCouponService;
import com.william.pojo.WilliamCoupon;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CustomerCouponResp;
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
     * 删除已过期优惠券
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : void
     */
    @PostMapping(value = "/deleteExpireCoupon")
    public void deleteExpireCoupon(@RequestBody BaseRequest baseRequest,@RequestParam("uid")String uid){
        williamCouponService.deleteExpireCoupon(baseRequest,uid);
    }

    /**
     * 领取 保存我的优惠券
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/saveCoupon")
    public Integer saveCoupon(@RequestBody PublicReq publicReq,@RequestParam("uid")String uid){
        return williamCouponService.saveCoupon(publicReq,uid);
    }

    /**
     * 领券中心列表
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponResp>
     */
    @PostMapping(value = "/getCouponCenter")
    public List<WilliamCoupon> getCouponCenter(@RequestBody BaseRequest baseRequest, @RequestParam("uid")String uid){
        return williamCouponService.getCouponCenter(baseRequest,uid);
    }

    /**
     * 优惠券详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.resp.CustomerCouponListResp
     */
    @PostMapping(value = "/getCouponDetail")
    public CustomerCouponResp getCouponDetail(@RequestBody PublicReq publicReq,@RequestParam("uid")String uid){
        return williamCouponService.getCouponDetail(publicReq,uid);
    }


    /**
     * 我的优惠券
     * @author     xinchuang
     * @param pageConditionReq:
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CustomerCouponListResp>
     */
    @PostMapping(value = "/getCouponByType")
    public List<CustomerCouponResp> getCouponByType(@RequestBody PageConditionReq pageConditionReq, @RequestParam("uid")String uid){
        return williamCouponService.getCouponByType(pageConditionReq,uid);
    }
}
