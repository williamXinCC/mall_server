package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamGoodsCategoryService;
import com.william.pojo.Result;
import com.william.pojo.WilliamGoodsCategory;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.CategoryTreeNodesResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/getGoodsCategoryTreeList")
    public List<CategoryTreeNodesResp> getGoodsCategoryTreeList(@RequestBody BaseRequest baseRequest, @RequestParam(value = "uid",required = false)String uid){
        return williamGoodsCategoryService.getGoodsCategoryTreeList(baseRequest,uid);
    }
}
