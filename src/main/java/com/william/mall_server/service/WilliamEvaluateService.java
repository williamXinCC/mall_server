package com.william.mall_server.service;

import com.william.pojo.WilliamEvaluate;
import com.william.pojo.req.EvaluateListReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.EvaluateCountResp;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:55
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamEvaluateService {

    List<WilliamEvaluate> getEvaluateListByGoodsIdAndType(EvaluateListReq pageConditionReq, String uid);

    Integer getEvaluateCountByGoodsId(String goodsId);

    EvaluateCountResp getCountByType(PublicReq publicReq);
}
