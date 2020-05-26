package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamGoodsCategoryService;
import com.william.pojo.Result;
import com.william.pojo.WilliamGoodsCategory;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CategoryTreeNodesResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.ccache.CCacheInputStream;

import java.util.List;

/**
 * 商品分类
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 11:24
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/goods-category")
public class WilliamGoodsCategoryController {

    @Autowired
    private WilliamGoodsCategoryService williamGoodsCategoryService;

    /**
     * 页面推荐分类
     * @author     xinchuang
     * @return : java.util.List<com.william.pojo.WilliamGoodsCategory>
     */
    @PostMapping(value = "/getRecommendCategoryByPage")
    public List<WilliamGoodsCategory> getRecommendCategoryByPage(@RequestBody PageConditionReq pageConditionReq){
        return williamGoodsCategoryService.getRecommendCategoryByPage(pageConditionReq);
    }

    /**
     * 分类树 无限极
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.CategoryTreeNodesResp>
     */
    @PostMapping(value = "/getGoodsCategoryTreeList")
    public List<CategoryTreeNodesResp> getGoodsCategoryTreeList(@RequestBody BaseRequest baseRequest, @RequestParam(value = "uid",required = false)String uid){
        return williamGoodsCategoryService.getGoodsCategoryTreeList(baseRequest,uid);
    }
}
