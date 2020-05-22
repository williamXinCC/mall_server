package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamEvaluate;
import com.william.pojo.WilliamEvaluateExample;
import com.william.pojo.req.EvaluateListReq;
import com.william.pojo.resp.EvaluateCountResp;
import org.apache.ibatis.annotations.Param;

public interface WilliamEvaluateMapper {
    int countByExample(WilliamEvaluateExample example);

    int deleteByExample(WilliamEvaluateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamEvaluate record);

    int insertSelective(WilliamEvaluate record);

    List<WilliamEvaluate> selectByExample(WilliamEvaluateExample example);

    WilliamEvaluate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamEvaluate record, @Param("example") WilliamEvaluateExample example);

    int updateByExample(@Param("record") WilliamEvaluate record, @Param("example") WilliamEvaluateExample example);

    int updateByPrimaryKeySelective(WilliamEvaluate record);

    int updateByPrimaryKey(WilliamEvaluate record);

    List<WilliamEvaluate> selectPage(WilliamEvaluateExample example);

    List<WilliamEvaluate> getEvaluateListByGoodsIdAndType(EvaluateListReq evaluateListReq);

    Integer getEvaluateCountByGoodsId(String goodsId);

    EvaluateCountResp getCountByType(String goodsId);
}