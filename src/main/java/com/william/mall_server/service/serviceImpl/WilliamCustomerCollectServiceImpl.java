package com.william.mall_server.service.serviceImpl;

import cn.hutool.core.collection.CollectionUtil;
import com.william.enums.CollectEnums;
import com.william.mall_server.mapper.WilliamCustomerCollectMapper;
import com.william.mall_server.mapper.WilliamGoodsMapper;
import com.william.mall_server.service.WilliamCustomerCollectService;
import com.william.pojo.WilliamCustomerCollect;
import com.william.pojo.WilliamCustomerCollectExample;
import com.william.pojo.WilliamGoods;
import com.william.pojo.req.CollectReq;
import com.william.pojo.req.PageConditionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 17:50
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamCustomerCollectServiceImpl implements WilliamCustomerCollectService {

    @Autowired
    private WilliamCustomerCollectMapper williamCustomerCollectMapper;

    @Autowired
    private WilliamGoodsMapper williamGoodsMapper;

    /**
     * 添加收藏
     * @author     xinchuang
     * @param collectReq :
     * @param uid :
     * @return : void
     */
    @Override
    public void saveCollect(CollectReq collectReq, String uid) {
        WilliamCustomerCollect williamCustomerCollect = doPojo(collectReq, uid,1);
        // 先查询
        WilliamCustomerCollectExample williamCustomerCollectExample = new WilliamCustomerCollectExample();
        WilliamCustomerCollectExample.Criteria criteria = williamCustomerCollectExample.createCriteria();
        criteria.andCustIdEqualTo(uid);
        criteria.andCollectIdEqualTo(collectReq.getCollectId());
        criteria.andTypeEqualTo(Integer.parseInt(collectReq.getType()));
        List<WilliamCustomerCollect> williamCustomerCollects = williamCustomerCollectMapper.selectByExample(williamCustomerCollectExample);
        // 商品收藏
        if(Objects.equals(williamCustomerCollect.getType(), CollectEnums.GOODS_COLLECT_TYPE.getCode())){
            // 不能存在 插入
            if(CollectionUtil.isEmpty(williamCustomerCollects)){
                williamCustomerCollectMapper.insertSelective(williamCustomerCollect);
                williamGoodsMapper.addGoodsFavoriteById(collectReq.getCollectId());
                // 存在修改
            }else{
                williamCustomerCollectMapper.updateByExample(williamCustomerCollect,williamCustomerCollectExample);
            }
            // 一条sql
//            williamCustomerCollectMapper.saveOrSelect(williamCustomerCollect);

        }
        // 店铺收藏
        if(Objects.equals(williamCustomerCollect.getType(),CollectEnums.STORE_COLLECT_TYPE.getCode())){

        }
    }

    /**
     * 取消收藏
     * @author     xinchuang
     * @param collectReq :
     * @param uid :
     * @return : void
     */
    @Override
    public void deleteCollect(CollectReq collectReq, String uid) {
        WilliamCustomerCollect williamCustomerCollect = doPojo(collectReq, uid,2);
        System.out.println(CollectEnums.GOODS_COLLECT_TYPE.getCode());
        // 商品收藏
        if(Objects.equals(williamCustomerCollect.getType(), CollectEnums.GOODS_COLLECT_TYPE.getCode())){
            WilliamCustomerCollectExample williamCustomerCollectExample = new WilliamCustomerCollectExample();
            WilliamCustomerCollectExample.Criteria criteria = williamCustomerCollectExample.createCriteria();
            criteria.andCustIdEqualTo(uid);
            criteria.andCollectIdEqualTo(collectReq.getCollectId());
            criteria.andTypeEqualTo(Integer.parseInt(collectReq.getType()));
            williamCustomerCollectMapper.updateByExample(williamCustomerCollect,williamCustomerCollectExample);
        }
        // 店铺收藏
        if(Objects.equals(williamCustomerCollect.getType(),CollectEnums.STORE_COLLECT_TYPE.getCode())){

        }
    }

    /**
     * 是否已收藏
     * @author     xinchuang
     * @param collectReq :
     * @param uid :
     * @return : java.lang.Integer
     */
    @Override
    public Integer getAlreadyCollect(CollectReq collectReq, String uid) {
        WilliamCustomerCollectExample williamCustomerCollectExample = new WilliamCustomerCollectExample();
        WilliamCustomerCollectExample.Criteria criteria = williamCustomerCollectExample.createCriteria();
        criteria.andCustIdEqualTo(uid);
        criteria.andCollectIdEqualTo(collectReq.getCollectId());
        criteria.andTypeEqualTo(Integer.parseInt(collectReq.getType()));
        criteria.andStatusEqualTo(1);
        List<WilliamCustomerCollect> williamCustomerCollects = williamCustomerCollectMapper.selectByExample(williamCustomerCollectExample);
        if(CollectionUtil.isNotEmpty(williamCustomerCollects)){
            return 1;
        }
        return 2;
    }

    /**
     * 我的收藏
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @Override
    public List<WilliamGoods> getMyCollect(PageConditionReq pageConditionReq, String uid) {
        return williamGoodsMapper.getMyCollect(uid);
    }

    private WilliamCustomerCollect doPojo(CollectReq collectReq,String uid,Integer status) {
        String collectId = collectReq.getCollectId();
        String type = collectReq.getType();
        WilliamCustomerCollect williamCustomerCollect = new WilliamCustomerCollect();
        williamCustomerCollect.setCustId(uid);
        williamCustomerCollect.setCollectId(collectId);
        williamCustomerCollect.setCreateTime(new Date());
        williamCustomerCollect.setType(Integer.parseInt(type));
        williamCustomerCollect.setStatus(status);
        return williamCustomerCollect;
    }
}
