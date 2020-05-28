package com.william.mall_server.service;

import com.william.pojo.WilliamSysStatic;
import com.william.pojo.req.PublicReq; /**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/28 15:39
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamSysServerService {

    WilliamSysStatic getProtocolByType(PublicReq publicReq, String uid);
}
