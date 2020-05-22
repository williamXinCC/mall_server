package com.william.mall_server.service;

import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.CategoryTreeNodesResp;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 11:35
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamGoodsCategoryService {

    List<CategoryTreeNodesResp> getGoodsCategoryTreeList(BaseRequest baseRequest, String uid);
}
