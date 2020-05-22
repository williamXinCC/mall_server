package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamAdvService;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.HomePageAdvResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 广告
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/22 14:28
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/adv")
public class WilliamAdvController {

    @Autowired
    private WilliamAdvService williamAdvService;

    /**
     * 首页广告
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : com.william.pojo.resp.HomePageAdvResp
     */
    @PostMapping(value = "/getHomePageAdv")
    public HomePageAdvResp getHomePageAdv(@RequestBody BaseRequest baseRequest, @RequestParam(value = "uid",required = false)String uid){
        return williamAdvService.getHomePageAdv(baseRequest.getTenantId(),baseRequest.getClient(),uid);
    }
}
