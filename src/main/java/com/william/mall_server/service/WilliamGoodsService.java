package com.william.mall_server.service;

import com.william.pojo.WilliamGoods;
import com.william.pojo.WilliamGoodsAttribute;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.req.PublicReq;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:49
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamGoodsService {

    WilliamGoods getGoodsInfo(PublicReq publicReq, String uid);

    List<WilliamGoodsAttribute> getGoodsAttributes(String goodsId);

    List<WilliamGoods> getGoodsListByCategory(PageConditionReq pageConditionReq, String uid);

    List<WilliamGoods> getNewGoodsPageCondition(PageConditionReq pageConditionReq, String uid);

    List<WilliamGoods> getRecommendGoodsByPage(PageReq pageReq, String uid);

    List<WilliamGoods> getHotGoodsByPage(PageReq pageReq, String uid);

    List<WilliamGoods> getCollectGooodsByUid(PageReq pageReq, String uid);

    List<WilliamGoods> getGuessYouLike(PageConditionReq pageConditionReq, String uid);
}
