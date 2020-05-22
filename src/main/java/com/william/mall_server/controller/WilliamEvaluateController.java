package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamEvaluateService;
import com.william.pojo.WilliamEvaluate;
import com.william.pojo.req.EvaluateListReq;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.EvaluateCountResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 10:29
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/evaluate")
public class WilliamEvaluateController {

    @Autowired
    private WilliamEvaluateService williamEvaluateService;

    /**
     * 商品评价分类 统计
     * @author     xinchuang
     * @param publicReq :
     * @return : com.william.pojo.Result
     */
    @PostMapping(value = "/getCountByType")
    public EvaluateCountResp getCountByType(@RequestBody PublicReq publicReq){
        return williamEvaluateService.getCountByType(publicReq);
    }


    /**
     * 商品评价 分类 分页  out
     * @author     xinchuang
     * @param evaluateListReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamEvaluate>
     */
    @PostMapping(value = "/getEvaluateListByGoodsIdAndType")
    public List<WilliamEvaluate> getEvaluateListByGoodsIdAndType(@RequestBody EvaluateListReq evaluateListReq, @RequestParam("uid")String uid){
        return williamEvaluateService.getEvaluateListByGoodsIdAndType(evaluateListReq,uid);
    }


    /**
     * 评价统计 inner
     * @author     xinchuang
     * @param goodsId :
     * @return : java.lang.Integer
     */
    @GetMapping(value = "/getEvaluateCountByGoodsId")
    public Integer getEvaluateCountByGoodsId(@RequestParam("goodsId") String goodsId){
        return williamEvaluateService.getEvaluateCountByGoodsId(goodsId);
    }
}
