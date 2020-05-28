package com.william.mall_server.service;

import com.william.pojo.WilliamGoods;
import com.william.pojo.req.CollectReq;
import com.william.pojo.req.PageConditionReq;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 17:50
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamCustomerCollectService {

    void saveCollect(CollectReq collectReq, String uid);

    void deleteCollect(CollectReq collectReq, String uid);

    Integer getAlreadyCollect(CollectReq collectReq, String uid);

    List<WilliamGoods> getMyCollect(PageConditionReq pageConditionReq, String uid);
}
