package com.william.mall_server.service;

import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.resp.BrowsingHisResp;
import com.william.pojo.resp.FootmarkResp;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 9:30
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamFootmarkService {

    void saveFootmarkByUidAndGoodsId(String goodsId, String uid);

    List<BrowsingHisResp> getFootmarkByPageAndDate(PageConditionReq pageConditionReq, String uid);

    List<FootmarkResp> getFootmarkByUid(PageReq pageReq, String uid);
}
