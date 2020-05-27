package com.william.mall_server.service;

import com.william.pojo.req.PageConditionReq;
import com.william.pojo.resp.CustomerCouponListResp;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/27 13:32
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamCouponService {

    List<CustomerCouponListResp> getCouponByType(PageConditionReq pageConditionReq, String uid);
}
