package com.william.mall_server.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.william.constant.Constant;
import com.william.mall_server.mapper.WilliamGoodsAttributeMapper;
import com.william.mall_server.mapper.WilliamGoodsMapper;
import com.william.mall_server.service.WilliamGoodsService;
import com.william.pojo.WilliamGoods;
import com.william.pojo.WilliamGoodsAttribute;
import com.william.pojo.WilliamGoodsAttributeExample;
import com.william.pojo.WilliamGoodsExample;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.req.PublicReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:50
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamGoodsServiceImpl implements WilliamGoodsService {

    @Autowired
    private WilliamGoodsMapper williamGoodsMapper;

    @Autowired
    private WilliamGoodsAttributeMapper williamGoodsAttributeMapper;

    @Override
    public List<WilliamGoodsAttribute> getGoodsAttributes(String goodsId) {
        WilliamGoodsAttributeExample williamGoodsAttributeExample = new WilliamGoodsAttributeExample();
        WilliamGoodsAttributeExample.Criteria criteria = williamGoodsAttributeExample.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        return williamGoodsAttributeMapper.selectByExample(williamGoodsAttributeExample);
    }

    /**
     * 分页 分类查询商品列表 
     * @author     xinchuang
     * @param pageConditionReq : 
     * @param uid : 
     * @return : java.util.List<com.william.pojo.WilliamGoods> 
     */
    @Override
    public List<WilliamGoods> getGoodsListByCategory(PageConditionReq pageConditionReq, String uid) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        WilliamGoodsExample williamGoodsExample = new WilliamGoodsExample();
        WilliamGoodsExample.Criteria criteria = williamGoodsExample.createCriteria();
        criteria.andCategoryIdEqualTo(Integer.parseInt(pageConditionReq.getKeyName()));
        PageHelper.startPage(startPage,pageSize,false);
        return williamGoodsMapper.selectByExample(williamGoodsExample);
    }

    /**
     * 新品上市
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @Override
    public List<WilliamGoods> getNewGoodsPageCondition(PageConditionReq pageConditionReq, String uid) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        WilliamGoodsExample williamGoodsExample = new WilliamGoodsExample();
        WilliamGoodsExample.Criteria criteria = williamGoodsExample.createCriteria();
        if(StringUtils.isNotBlank(pageConditionReq.getKeyName())){
            criteria.andCategoryIdEqualTo(Integer.parseInt(pageConditionReq.getKeyName()));
        }
        williamGoodsExample.setOrderByClause("id desc");
        PageHelper.startPage(startPage,pageSize,false);
        return williamGoodsMapper.selectByExample(williamGoodsExample);
    }


    /**
     * 推荐商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @Override
    public List<WilliamGoods> getRecommendGoodsByPage(PageReq pageReq, String uid) {
        Integer startPage = pageReq.getStartPage() == null ? 1 : Integer.parseInt(pageReq.getStartPage());
        Integer pageSize = pageReq.getPageSize() == null ? 10 : Integer.parseInt(pageReq.getPageSize());
        PageHelper.startPage(startPage,pageSize,false);
        return williamGoodsMapper.getRecommendGoodsByPage(pageReq.getTenantId(),pageReq.getClient());
    }

    /**
     * 热门商品
     * @author     xinchuang
     * @param pageReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamGoods>
     */
    @Override
    public List<WilliamGoods> getHotGoodsByPage(PageReq pageReq, String uid) {
        Integer startPage = pageReq.getStartPage() == null ? 1 : Integer.parseInt(pageReq.getStartPage());
        Integer pageSize = pageReq.getPageSize() == null ? 10 : Integer.parseInt(pageReq.getPageSize());
        WilliamGoodsExample williamGoodsExample = new WilliamGoodsExample();
        WilliamGoodsExample.Criteria criteria = williamGoodsExample.createCriteria();
        // 状态正常可用
        criteria.andStatusEqualTo(Constant.STATUS_ONE_USE);
        // 上架商品
        criteria.andPutawayEqualTo(Constant.STATUS_ONE_USE);
        // 库存剩余大于10
        criteria.andResidueGreaterThan(10);
        williamGoodsExample.setOrderByClause("sell_total desc");
        PageHelper.startPage(startPage,pageSize,false);
        return williamGoodsMapper.selectByExample(williamGoodsExample);
    }

    @Override
    public WilliamGoods getGoodsInfo(PublicReq publicReq, String uid) {
        return williamGoodsMapper.selectByPrimaryKey(publicReq.getKeyName());
    }
}
