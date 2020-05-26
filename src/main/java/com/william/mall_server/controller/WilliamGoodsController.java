package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamGoodsService;
import com.william.pojo.WilliamGoods;
import com.william.pojo.WilliamGoodsAttribute;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:48
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/goods")
public class WilliamGoodsController {

    @Autowired
    private WilliamGoodsService williamGoodsService;


    /**
     * 猜你喜欢
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @PostMapping(value = "/goods/getGuessYouLike")
    public List<WilliamGoods> getGuessYouLike(@RequestBody PageConditionReq pageConditionReq,@RequestParam(value = "uid",required = false) String uid){
        return williamGoodsService.getGuessYouLike(pageConditionReq,uid);
    }


    /**
     * 收藏商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @PostMapping(value = "/getCollectGooodsByUid")
    public List<WilliamGoods> getCollectGooodsByUid(@RequestBody PageReq pageReq,@RequestParam("uid")String uid){
        return williamGoodsService.getCollectGooodsByUid(pageReq,uid);
    }

    /**
     * 热门商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @PostMapping(value = "/getHotGoodsByPage")
    public List<WilliamGoods> getHotGoodsByPage(@RequestBody PageReq pageReq,@RequestParam(value = "uid",required = false) String uid){
        return williamGoodsService.getHotGoodsByPage(pageReq,uid);
    }

    /**
     * 推荐商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @PostMapping(value = "/getRecommendGoodsByPage")
    public List<WilliamGoods> getRecommendGoodsByPage(@RequestBody PageReq pageReq, @RequestParam("uid") String uid){
        return williamGoodsService.getRecommendGoodsByPage(pageReq,uid);
    }

    /**
     * 新品上市
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @PostMapping(value = "/getNewGoodsPageCondition")
    public List<WilliamGoods> getNewGoodsPageCondition(@RequestBody PageConditionReq pageConditionReq,@RequestParam(value = "uid",required = false) String uid){
        return williamGoodsService.getNewGoodsPageCondition(pageConditionReq,uid);
    }

    /**
     * 分类商品列表  分页
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @PostMapping(value = "/getGoodsListByCategory")
    public List<WilliamGoods> getGoodsListByCategory(@RequestBody PageConditionReq pageConditionReq,@RequestParam(value = "uid",required = false)String uid){
        return williamGoodsService.getGoodsListByCategory(pageConditionReq,uid);
    }

    /**
     * 商品详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.WilliamGoods
     */
    @PostMapping(value = "/getGoodsInfo")
    public WilliamGoods getGoodsInfo(@RequestBody PublicReq publicReq, @RequestParam(value = "uid",required = false) String uid){
        return williamGoodsService.getGoodsInfo(publicReq,uid);
    }

    /**
     * 商品参数
     * @author     xinchuang
     * @param goodsId :
     * @return : java.util.List<com.william.pojo.WilliamGoodsAttribute>
     */
    @GetMapping(value = "/getGoodsAttributes")
    public List<WilliamGoodsAttribute> getGoodsAttributes(@RequestParam("goodsId")String goodsId){
        return williamGoodsService.getGoodsAttributes(goodsId);
    }
}
