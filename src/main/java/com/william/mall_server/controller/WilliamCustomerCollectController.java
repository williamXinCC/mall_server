package com.william.mall_server.controller;


import com.william.mall_server.service.WilliamCustomerCollectService;
import com.william.pojo.req.CollectReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author mybatisPlusGenerator
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/collect")
public class WilliamCustomerCollectController {

    @Autowired
    private WilliamCustomerCollectService service;

    @PostMapping(value = "/saveCollect")
    public void saveCollect(@RequestBody CollectReq collectReq, @RequestParam(value = "uid")String uid){
        service.saveCollect(collectReq,uid);
    }


    @PostMapping(value = "/deleteCollect")
    public void deleteCollect(@RequestBody CollectReq collectReq, @RequestParam(value = "uid")String uid){
        service.deleteCollect(collectReq,uid);
    }

    /**
     * 是否已收藏
     * @author     xinchuang
     * @param collectReq :
     * @param uid :
     * @return : java.lang.Integer
     */
    @PostMapping(value = "/getAlreadyCollect")
    public Integer getAlreadyCollect(@RequestBody CollectReq collectReq, @RequestParam(value = "uid")String uid){
        return service.getAlreadyCollect(collectReq,uid);
    }
}
