package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamCouponCustomer;
import com.william.pojo.WilliamCouponCustomerExample;
import com.william.pojo.resp.CustomerCouponResp;
import org.apache.ibatis.annotations.Param;

public interface WilliamCouponCustomerMapper {

    int countByExample(WilliamCouponCustomerExample example);

    int deleteByExample(WilliamCouponCustomerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WilliamCouponCustomer record);

    int insertSelective(WilliamCouponCustomer record);

    List<WilliamCouponCustomer> selectByExample(WilliamCouponCustomerExample example);

    WilliamCouponCustomer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WilliamCouponCustomer record, @Param("example") WilliamCouponCustomerExample example);

    int updateByExample(@Param("record") WilliamCouponCustomer record, @Param("example") WilliamCouponCustomerExample example);

    int updateByPrimaryKeySelective(WilliamCouponCustomer record);

    int updateByPrimaryKey(WilliamCouponCustomer record);

    List<WilliamCouponCustomer> selectPage(WilliamCouponCustomerExample example);

    List<CustomerCouponResp> getCouponByType(@Param("type") String type, @Param("uid") String uid);

    CustomerCouponResp getCouponDetail(String couponId);

    WilliamCouponCustomer selectByCustomerIdAndCouponId(@Param("uid")String uid,@Param("couponId") Long id);
}