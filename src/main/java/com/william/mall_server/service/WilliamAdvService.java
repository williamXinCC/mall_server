package com.william.mall_server.service;

import com.william.pojo.WilliamPicture;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.HomePageAdvResp;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/22 14:30
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamAdvService {

    HomePageAdvResp getHomePageAdv(String tenantId,String client, String uid);

    List<WilliamPicture> getAdvListByCategory(PublicReq publicReq, String uid);
}
