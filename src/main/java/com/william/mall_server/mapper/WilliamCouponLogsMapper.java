package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamCouponLogs;
import com.william.pojo.WilliamCouponLogsExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamCouponLogsMapper {
    int countByExample(WilliamCouponLogsExample example);

    int deleteByExample(WilliamCouponLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WilliamCouponLogs record);

    int insertSelective(WilliamCouponLogs record);

    List<WilliamCouponLogs> selectByExample(WilliamCouponLogsExample example);

    WilliamCouponLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WilliamCouponLogs record, @Param("example") WilliamCouponLogsExample example);

    int updateByExample(@Param("record") WilliamCouponLogs record, @Param("example") WilliamCouponLogsExample example);

    int updateByPrimaryKeySelective(WilliamCouponLogs record);

    int updateByPrimaryKey(WilliamCouponLogs record);

    List<WilliamCouponLogs> selectPage(WilliamCouponLogsExample example);
}