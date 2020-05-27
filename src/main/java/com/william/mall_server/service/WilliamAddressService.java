package com.william.mall_server.service;

import com.william.pojo.WilliamCustomerLocation;
import com.william.pojo.req.AddressReq;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/26 11:49
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamAddressService {

    List<WilliamCustomerLocation> getCustomerAddressList(BaseRequest baseRequest, String uid);

    void deleteAddress(PublicReq publicReq, String uid);

    void updateAddress(AddressReq addressReq, String uid);

    void saveAddress(AddressReq addressReq, String uid);

    WilliamCustomerLocation getDefaultAddress(BaseRequest baseRequest, String uid);

    void updateDefaultAddress(PublicReq publicReq, String uid);
}
