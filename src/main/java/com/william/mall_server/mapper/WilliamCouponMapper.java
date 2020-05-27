package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamCoupon;
import com.william.pojo.WilliamCouponExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamCouponMapper {
    int countByExample(WilliamCouponExample example);

    int deleteByExample(WilliamCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WilliamCoupon record);

    int insertSelective(WilliamCoupon record);

    List<WilliamCoupon> selectByExample(WilliamCouponExample example);

    WilliamCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WilliamCoupon record, @Param("example") WilliamCouponExample example);

    int updateByExample(@Param("record") WilliamCoupon record, @Param("example") WilliamCouponExample example);

    int updateByPrimaryKeySelective(WilliamCoupon record);

    int updateByPrimaryKey(WilliamCoupon record);

    List<WilliamCoupon> selectPage(WilliamCouponExample example);
}