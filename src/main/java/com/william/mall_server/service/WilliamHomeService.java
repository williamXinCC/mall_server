package com.william.mall_server.service;

import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.HomePageResp;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 16:30
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamHomeService {

    HomePageResp getHomePage(BaseRequest baseRequest);
}
