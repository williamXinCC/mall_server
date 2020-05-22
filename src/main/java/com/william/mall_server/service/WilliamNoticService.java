package com.william.mall_server.service;

import com.william.pojo.WilliamSysNotice;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 17:37
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamNoticService {

    List<WilliamSysNotice> getNoticeListByType(PageConditionReq pageConditionReq);

    WilliamSysNotice getNoticeInfo(PublicReq publicReq, String uid);
}
