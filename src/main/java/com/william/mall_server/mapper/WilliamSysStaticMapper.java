package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamSysStatic;
import com.william.pojo.WilliamSysStaticExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamSysStaticMapper {
    int countByExample(WilliamSysStaticExample example);

    int deleteByExample(WilliamSysStaticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamSysStatic record);

    int insertSelective(WilliamSysStatic record);

    List<WilliamSysStatic> selectByExample(WilliamSysStaticExample example);

    WilliamSysStatic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamSysStatic record, @Param("example") WilliamSysStaticExample example);

    int updateByExample(@Param("record") WilliamSysStatic record, @Param("example") WilliamSysStaticExample example);

    int updateByPrimaryKeySelective(WilliamSysStatic record);

    int updateByPrimaryKey(WilliamSysStatic record);

    List<WilliamSysStatic> selectPage(WilliamSysStaticExample example);
}