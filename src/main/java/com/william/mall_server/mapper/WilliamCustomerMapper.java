package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamCustomer;
import com.william.pojo.WilliamCustomerExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamCustomerMapper {
    int countByExample(WilliamCustomerExample example);

    int deleteByExample(WilliamCustomerExample example);

    int deleteByPrimaryKey(String customerId);

    int insert(WilliamCustomer record);

    int insertSelective(WilliamCustomer record);

    List<WilliamCustomer> selectByExample(WilliamCustomerExample example);

    WilliamCustomer selectByPrimaryKey(String customerId);

    int updateByExampleSelective(@Param("record") WilliamCustomer record, @Param("example") WilliamCustomerExample example);

    int updateByExample(@Param("record") WilliamCustomer record, @Param("example") WilliamCustomerExample example);

    int updateByPrimaryKeySelective(WilliamCustomer record);

    int updateByPrimaryKey(WilliamCustomer record);

    List<WilliamCustomer> selectPage(WilliamCustomerExample example);

    WilliamCustomer getLoginByPhoneAndPassword(@Param("phone") String phone,@Param("password") String password);

    WilliamCustomer selectByPhone(String customerPhone);
}