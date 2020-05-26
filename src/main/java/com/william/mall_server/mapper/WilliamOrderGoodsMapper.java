package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamOrderGoods;
import com.william.pojo.WilliamOrderGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamOrderGoodsMapper {
    int countByExample(WilliamOrderGoodsExample example);

    int deleteByExample(WilliamOrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamOrderGoods record);

    int insertSelective(WilliamOrderGoods record);

    List<WilliamOrderGoods> selectByExample(WilliamOrderGoodsExample example);

    WilliamOrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamOrderGoods record, @Param("example") WilliamOrderGoodsExample example);

    int updateByExample(@Param("record") WilliamOrderGoods record, @Param("example") WilliamOrderGoodsExample example);

    int updateByPrimaryKeySelective(WilliamOrderGoods record);

    int updateByPrimaryKey(WilliamOrderGoods record);

    List<WilliamOrderGoods> selectPage(WilliamOrderGoodsExample example);
}