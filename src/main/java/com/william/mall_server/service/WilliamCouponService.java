package com.william.mall_server.service;

import com.william.pojo.WilliamCoupon;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CustomerCouponResp;

import java.util.List;


/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 13:32
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamCouponService {

    List<CustomerCouponResp> getCouponByType(PageConditionReq pageConditionReq, String uid);

    List<WilliamCoupon> getCouponCenter(BaseRequest baseRequest, String uid);

    CustomerCouponResp getCouponDetail(PublicReq publicReq, String uid);

    Integer saveCoupon(PublicReq publicReq, String uid);

    void deleteExpireCoupon(BaseRequest baseRequest, String uid);
}
