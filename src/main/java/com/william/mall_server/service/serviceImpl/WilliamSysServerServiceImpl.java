package com.william.mall_server.service.serviceImpl;

import com.william.mall_server.mapper.WilliamSysStaticMapper;
import com.william.mall_server.service.WilliamSysServerService;
import com.william.pojo.WilliamSysStatic;
import com.william.pojo.WilliamSysStaticExample;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/28 15:40
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamSysServerServiceImpl implements WilliamSysServerService {

    @Autowired
    private WilliamSysStaticMapper williamSysStaticMapper;

    @Override
    public WilliamSysStatic getProtocolByType(PublicReq publicReq, String uid) {
        String tenantId = publicReq.getTenantId();
        String client = publicReq.getClient();
        String type = publicReq.getKeyName();
        WilliamSysStaticExample williamSysStaticExample = new WilliamSysStaticExample();
        WilliamSysStaticExample.Criteria criteria = williamSysStaticExample.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andClientIdEqualTo(client);
        criteria.andTypeEqualTo(Integer.parseInt(type));
        return williamSysStaticMapper.selectByExample(williamSysStaticExample).get(0);
    }
}
