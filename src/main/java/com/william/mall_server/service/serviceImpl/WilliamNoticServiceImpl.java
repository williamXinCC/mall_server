package com.william.mall_server.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.william.constant.Constant;
import com.william.mall_server.mapper.WilliamSysNoticeMapper;
import com.william.mall_server.service.WilliamNoticService;
import com.william.pojo.WilliamSysNotice;
import com.william.pojo.WilliamSysNoticeExample;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 17:37
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamNoticServiceImpl implements WilliamNoticService {

    @Autowired
    private WilliamSysNoticeMapper williamSysNoticeMapper;

    /**
     * 通知分类获取通知列表
     * @author     xinchuang
     * @param pageConditionReq :
     * @return : java.util.List<com.william.pojo.WilliamSysNotice>
     */
    @Override
    public List<WilliamSysNotice> getNoticeListByType(PageConditionReq pageConditionReq) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        WilliamSysNoticeExample williamSysNoticeExample = new WilliamSysNoticeExample();
        WilliamSysNoticeExample.Criteria criteria = williamSysNoticeExample.createCriteria();
        criteria.andPageEqualTo(Constant.TYPE_ONE);
        criteria.andTypeEqualTo(Integer.parseInt(pageConditionReq.getKeyName()));
        criteria.andStatusEqualTo(Constant.STATUS_ONE_USE);
        criteria.andTenantIdEqualTo(pageConditionReq.getTenantId());
        criteria.andClientEqualTo(pageConditionReq.getClient());
        PageHelper.startPage(startPage,pageSize,false);
        return williamSysNoticeMapper.selectByExample(williamSysNoticeExample);
    }

    /**
     * 公告详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.WilliamSysNotice
     */
    @Override
    public WilliamSysNotice getNoticeInfo(PublicReq publicReq, String uid) {
        return williamSysNoticeMapper.selectByPrimaryKey(Integer.parseInt(publicReq.getKeyName()));
    }
}
