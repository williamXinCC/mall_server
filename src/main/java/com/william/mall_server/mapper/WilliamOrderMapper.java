package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamOrder;
import com.william.pojo.WilliamOrderExample;
import com.william.pojo.resp.OrderResp;
import org.apache.ibatis.annotations.Param;

public interface WilliamOrderMapper {
    int countByExample(WilliamOrderExample example);

    int deleteByExample(WilliamOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(WilliamOrder record);

    int insertSelective(WilliamOrder record);

    List<WilliamOrder> selectByExample(WilliamOrderExample example);

    WilliamOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") WilliamOrder record, @Param("example") WilliamOrderExample example);

    int updateByExample(@Param("record") WilliamOrder record, @Param("example") WilliamOrderExample example);

    int updateByPrimaryKeySelective(WilliamOrder record);

    int updateByPrimaryKey(WilliamOrder record);

    List<WilliamOrder> selectPage(WilliamOrderExample example);

    // 订单状态 查询订单列表,带商品
    List<OrderResp> getOrderListByStatus(@Param("orderStatus") String orderStatus,@Param("uid") String uid,@Param("tenantId") String tenantId,@Param("client") String client);
}