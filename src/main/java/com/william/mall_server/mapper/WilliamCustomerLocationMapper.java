package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamCustomerLocation;
import com.william.pojo.WilliamCustomerLocationExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamCustomerLocationMapper {
    int countByExample(WilliamCustomerLocationExample example);

    int deleteByExample(WilliamCustomerLocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamCustomerLocation record);

    int insertSelective(WilliamCustomerLocation record);

    List<WilliamCustomerLocation> selectByExample(WilliamCustomerLocationExample example);

    WilliamCustomerLocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamCustomerLocation record, @Param("example") WilliamCustomerLocationExample example);

    int updateByExample(@Param("record") WilliamCustomerLocation record, @Param("example") WilliamCustomerLocationExample example);

    int updateByPrimaryKeySelective(WilliamCustomerLocation record);

    int updateByPrimaryKey(WilliamCustomerLocation record);

    List<WilliamCustomerLocation> selectPage(WilliamCustomerLocationExample example);

    WilliamCustomerLocation selectByUidAndCheckType(String uid);

    void updateAddressNoChecked(String uid);
}