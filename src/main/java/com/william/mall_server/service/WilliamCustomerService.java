package com.william.mall_server.service;

import com.william.pojo.Result;
import com.william.pojo.WilliamCustomer;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.UpdateCustomerReq;
import com.william.pojo.req.UpdatePassword; /**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:21
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamCustomerService {

    WilliamCustomer getCustomerInfo(BaseRequest baseRequest, String uid);

    Result updateCustomerInfo(UpdateCustomerReq updateCustomerReq, String uid);

    void updatePassword(UpdatePassword updatePassword, String uid);
}
