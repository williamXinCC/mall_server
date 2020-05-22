package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamHomeService;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.HomePageResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 16:29
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/home")
public class WilliamHomeController {

    @Autowired
    private WilliamHomeService williamHomeService;

    /**
     * 首页
     * @author     xinchuang
     * @param baseRequest :
     * @return : com.william.pojo.resp.HomePageResp
     */
    @PostMapping(value = "/getHomePage")
    public HomePageResp getHomePage(@RequestBody BaseRequest baseRequest){
        return williamHomeService.getHomePage(baseRequest);
    }
}
