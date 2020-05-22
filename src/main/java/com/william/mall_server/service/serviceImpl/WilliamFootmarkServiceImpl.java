package com.william.mall_server.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.william.constant.Consts;
import com.william.mall_server.mapper.WilliamBrowsingHistoryMapper;
import com.william.mall_server.service.WilliamFootmarkService;
import com.william.pojo.WilliamBrowsingHistory;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.resp.BrowsingHisResp;
import com.william.pojo.resp.FootmarkResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 9:30
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamFootmarkServiceImpl implements WilliamFootmarkService {

    @Autowired
    private WilliamBrowsingHistoryMapper williamBrowsingHistoryMapper;

    /**
     * 保存商品 浏览记录
     * @author     xinchuang
     * @param goodsId :
     * @param uid :
     * @return : void
     */
    @Override
    public void saveFootmarkByUidAndGoodsId(String goodsId, String uid) {
        WilliamBrowsingHistory williamBrowsingHistory = new WilliamBrowsingHistory();
        williamBrowsingHistory.setCreateTime(new Date());
        williamBrowsingHistory.setGoodsId(goodsId);
        williamBrowsingHistory.setStatus(Consts.SINGAL_ONE);
        williamBrowsingHistory.setCustomerId(uid);
        Integer result = williamBrowsingHistoryMapper.saveAndSelect(williamBrowsingHistory);
        if(0 == result){
            williamBrowsingHistoryMapper.updateCount(williamBrowsingHistory);
        }
    }

    /**
     * 足迹
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamBrowsingHistory>
     */
    @Override
    public List<BrowsingHisResp> getFootmarkByPageAndDate(PageConditionReq pageConditionReq, String uid) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        String dayTime = pageConditionReq.getKeyName();
        if(StringUtils.isBlank(dayTime)){
            PageHelper.startPage(startPage,pageSize,false);
            return williamBrowsingHistoryMapper.getBrowsingHisByUid(uid);
        }else {
            return williamBrowsingHistoryMapper.getBrowsingHisByUidAndDayTime(uid,dayTime);
        }

    }

    @Override
    public List<FootmarkResp> getFootmarkByUid(PageReq pageReq, String uid) {
        Integer startPage = pageReq.getStartPage() == null ? 1 : Integer.parseInt(pageReq.getStartPage());
        Integer pageSize = pageReq.getPageSize() == null ? 10 : Integer.parseInt(pageReq.getPageSize());
        PageHelper.startPage(startPage,pageSize,false);
        return williamBrowsingHistoryMapper.getFootmarkByUid(uid);
    }
}
