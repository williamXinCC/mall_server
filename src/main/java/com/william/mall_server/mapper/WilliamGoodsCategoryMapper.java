package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamGoodsCategory;
import com.william.pojo.WilliamGoodsCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamGoodsCategoryMapper {
    int countByExample(WilliamGoodsCategoryExample example);

    int deleteByExample(WilliamGoodsCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamGoodsCategory record);

    int insertSelective(WilliamGoodsCategory record);

    List<WilliamGoodsCategory> selectByExample(WilliamGoodsCategoryExample example);

    WilliamGoodsCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamGoodsCategory record, @Param("example") WilliamGoodsCategoryExample example);

    int updateByExample(@Param("record") WilliamGoodsCategory record, @Param("example") WilliamGoodsCategoryExample example);

    int updateByPrimaryKeySelective(WilliamGoodsCategory record);

    int updateByPrimaryKey(WilliamGoodsCategory record);

    List<WilliamGoodsCategory> selectPage(WilliamGoodsCategoryExample example);
}