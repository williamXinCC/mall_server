package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamAddressService;
import com.william.pojo.Result;
import com.william.pojo.WilliamCustomerLocation;
import com.william.pojo.req.AddressReq;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地址
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/26 11:33
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/address")
public class WilliamAddressController {

    @Autowired
    private WilliamAddressService williamAddressService;

    /**
     * 设置默认收货地址
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : void
     */
    @PostMapping(value = "/updateDefaultAddress")
    public void updateDefaultAddress(@RequestBody PublicReq publicReq,@RequestParam String uid){
        williamAddressService.updateDefaultAddress(publicReq,uid);
    }

    /**
     * 默认地址
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : com.william.pojo.WilliamCustomerLocation
     */
    @PostMapping(value = "/getDefaultAddress")
    public WilliamCustomerLocation getDefaultAddress(@RequestBody BaseRequest baseRequest,@RequestParam("uid") String uid){
        return williamAddressService.getDefaultAddress(baseRequest,uid);
    }

    /**
     * 删除地址
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/deleteAddress")
    public void deleteAddress(@RequestBody PublicReq publicReq, @RequestParam(value = "uid")String uid){
        williamAddressService.deleteAddress(publicReq,uid);
    }

    /**
     * 修改地址
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/updateAddress")
    public void updateAddress(@RequestBody AddressReq addressReq, @RequestParam(value = "uid")String uid){
        williamAddressService.updateAddress(addressReq,uid);
    }

    /**
     * 添加新地址
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/saveAddress")
    public void saveAddress(@RequestBody AddressReq addressReq, @RequestParam(value = "uid")String uid){
        williamAddressService.saveAddress(addressReq,uid);
    }

    /**
     * 地址管理
     * @author     xinchuang
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getCustomerAddressList")
    public List<WilliamCustomerLocation> getCustomerAddressList(@RequestBody BaseRequest baseRequest, @RequestParam(value = "uid")String uid){
        return williamAddressService.getCustomerAddressList(baseRequest,uid);
    }
}
