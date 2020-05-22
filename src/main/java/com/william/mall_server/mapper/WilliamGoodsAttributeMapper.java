package com.william.mall_server.mapper;

import com.william.pojo.WilliamGoodsAttribute;
import com.william.pojo.WilliamGoodsAttributeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WilliamGoodsAttributeMapper {
    int countByExample(WilliamGoodsAttributeExample example);

    int deleteByExample(WilliamGoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamGoodsAttribute record);

    int insertSelective(WilliamGoodsAttribute record);

    List<WilliamGoodsAttribute> selectByExample(WilliamGoodsAttributeExample example);

    WilliamGoodsAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamGoodsAttribute record, @Param("example") WilliamGoodsAttributeExample example);

    int updateByExample(@Param("record") WilliamGoodsAttribute record, @Param("example") WilliamGoodsAttributeExample example);

    int updateByPrimaryKeySelective(WilliamGoodsAttribute record);

    int updateByPrimaryKey(WilliamGoodsAttribute record);

    List<WilliamGoodsAttribute> selectPage(WilliamGoodsAttributeExample example);

}