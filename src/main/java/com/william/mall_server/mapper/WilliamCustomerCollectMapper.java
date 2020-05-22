package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamCustomerCollect;
import com.william.pojo.WilliamCustomerCollectExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamCustomerCollectMapper {
    int countByExample(WilliamCustomerCollectExample example);

    int deleteByExample(WilliamCustomerCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamCustomerCollect record);

    int insertSelective(WilliamCustomerCollect record);

    List<WilliamCustomerCollect> selectByExample(WilliamCustomerCollectExample example);

    WilliamCustomerCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamCustomerCollect record, @Param("example") WilliamCustomerCollectExample example);

    int updateByExample(@Param("record") WilliamCustomerCollect record, @Param("example") WilliamCustomerCollectExample example);

    int updateByPrimaryKeySelective(WilliamCustomerCollect record);

    int updateByPrimaryKey(WilliamCustomerCollect record);

    List<WilliamCustomerCollect> selectPage(WilliamCustomerCollectExample example);

    void saveOrSelect(WilliamCustomerCollect williamCustomerCollect);
}