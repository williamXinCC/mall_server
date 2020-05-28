package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamGoods;
import com.william.pojo.WilliamGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamGoodsMapper {
    int countByExample(WilliamGoodsExample example);

    int deleteByExample(WilliamGoodsExample example);

    int deleteByPrimaryKey(String id);

    int insert(WilliamGoods record);

    int insertSelective(WilliamGoods record);

    List<WilliamGoods> selectByExample(WilliamGoodsExample example);

    WilliamGoods selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WilliamGoods record, @Param("example") WilliamGoodsExample example);

    int updateByExample(@Param("record") WilliamGoods record, @Param("example") WilliamGoodsExample example);

    int updateByPrimaryKeySelective(WilliamGoods record);

    int updateByPrimaryKey(WilliamGoods record);

    List<WilliamGoods> selectPage(WilliamGoodsExample example);

    // 商品收藏数
    void addGoodsFavoriteById(String collectId);
    void updateGoodsFavoriteById(String collectId);

    // 推荐商品
    List<WilliamGoods> getRecommendGoodsByPage(@Param("tenantId") String tenantId,@Param("client") String client);

    // 收藏商品
    List<WilliamGoods> getCollectGooodsByUid(@Param("tenantId") String tenantId,@Param("client") String client,@Param("uid") String uid);

    // 猜你喜欢
    List<WilliamGoods> selectByCategoryIdAndGuessLike(@Param("tenantId") String tenantId,@Param("client") String client,@Param("categoryId") Integer categoryId);

    List<WilliamGoods> getMyCollect(String uid);
}