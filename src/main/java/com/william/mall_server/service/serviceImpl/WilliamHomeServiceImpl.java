package com.william.mall_server.service.serviceImpl;

import com.william.constant.Consts;
import com.william.enums.PictureEnums;
import com.william.mall_server.mapper.WilliamPictureMapper;
import com.william.mall_server.service.*;
import com.william.pojo.*;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.resp.HomePageAdvResp;
import com.william.pojo.resp.HomePageResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 16:30
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamHomeServiceImpl implements WilliamHomeService {

    @Autowired
    private WilliamPictureMapper williamPictureMapper;

    @Autowired
    private WilliamNoticService williamNoticService;

    @Autowired
    private WilliamGoodsService williamGoodsService;

    @Autowired
    private WilliamAdvService williamAdvService;

    @Autowired
    private WilliamGoodsCategoryService williamGoodsCategoryService;

    @Override
    public HomePageResp getHomePage(BaseRequest baseRequest) {
        // 租户  端
        String tenantId = baseRequest.getTenantId();
        String client = baseRequest.getClient();
        HomePageResp homePageResp = new HomePageResp();
        // 1 轮播图
        WilliamPictureExample williamPictureExample = new WilliamPictureExample();
        WilliamPictureExample.Criteria criteria = williamPictureExample.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andClientEqualTo(client);
        // 分类
        criteria.andCategoryIdEqualTo(PictureEnums.HOMEPAGE_BANNER.getCode());
        // 状态
        criteria.andStatusEqualTo(Consts.SINGAL_ONE);
        List<WilliamPicture> bannerList = williamPictureMapper.selectByExample(williamPictureExample);
        // 2 APP通知公告
        PageConditionReq pageConditionReq = new PageConditionReq();
        pageConditionReq.setKeyName("1");
        pageConditionReq.setTenantId(baseRequest.getTenantId());
        pageConditionReq.setClient(baseRequest.getClient());
        List<WilliamSysNotice> noticeList = williamNoticService.getNoticeListByType(pageConditionReq);
        PageReq pageReq = new PageReq();
        pageReq.setTenantId(tenantId);
        pageReq.setClient(client);
        // 热门商品
        List<WilliamGoods> hotGoodsByPage = williamGoodsService.getHotGoodsByPage(pageReq, null);
        // 推荐商品
        List<WilliamGoods> recommendGoodsByPage = williamGoodsService.getRecommendGoodsByPage(pageReq, null);
        // 新品上市
        PageConditionReq newGoodsPageCondition = new PageConditionReq();
        newGoodsPageCondition.setTenantId(tenantId);
        newGoodsPageCondition.setClient(client);
        List<WilliamGoods> newGoodsPageList = williamGoodsService.getNewGoodsPageCondition(newGoodsPageCondition, null);
        // 推荐分类
        PageConditionReq goodsCategroyCondition = new PageConditionReq();
        goodsCategroyCondition.setKeyName("1");
        goodsCategroyCondition.setTenantId(tenantId);
        goodsCategroyCondition.setClient(client);
        List<WilliamGoodsCategory> recommendCategoryByPage = williamGoodsCategoryService.getRecommendCategoryByPage(pageConditionReq);
        // 猜你喜欢 查收藏商品
        // .....
        // 首页广告图片
        HomePageAdvResp homePageAdv = williamAdvService.getHomePageAdv(tenantId, client, null);
        homePageResp.setHomeNoticList(noticeList);
        homePageResp.setHotGoodsList(hotGoodsByPage);
        homePageResp.setRecommendGoodsList(recommendGoodsByPage);
        homePageResp.setRecommendGoodsCategory(recommendCategoryByPage);
        homePageResp.setBannerList(bannerList);
        homePageResp.setNewGoodsList(newGoodsPageList);
        homePageResp.setHomePageAdvResp(homePageAdv);
        return homePageResp;
    }
}
