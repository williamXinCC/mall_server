package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamCustomerService;
import com.william.pojo.Result;
import com.william.pojo.WilliamCustomer;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;
import com.william.pojo.req.UpdateCustomerReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 客户
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 16:15
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/customer")
public class WilliamCustomerController {

    @Autowired
    private WilliamCustomerService williamCustomerService;

    /**
     * 客户详情
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : com.william.pojo.WilliamCustomer
     */
    @PostMapping(value = "/getCustomerInfo")
    public WilliamCustomer getCustomerInfo(@RequestBody BaseRequest baseRequest, @RequestParam("uid") String uid){
        return williamCustomerService.getCustomerInfo(baseRequest,uid);
    }


    /**
     * 修改客户信息
     * @author     xinchuang
     * @param updateCustomerReq :
     * @param uid :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/updateCustomerInfo")
    public Result updateCustomerInfo(@RequestBody UpdateCustomerReq updateCustomerReq, @RequestParam("uid") String uid){
        return williamCustomerService.updateCustomerInfo(updateCustomerReq,uid);
    }
}
