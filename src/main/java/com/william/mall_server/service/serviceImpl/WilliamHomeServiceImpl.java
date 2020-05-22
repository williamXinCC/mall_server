package com.william.mall_server.service.serviceImpl;

import com.william.constant.Consts;
import com.william.enums.PictureEnums;
import com.william.mall_server.mapper.WilliamPictureMapper;
import com.william.mall_server.service.WilliamAdvService;
import com.william.mall_server.service.WilliamGoodsService;
import com.william.mall_server.service.WilliamHomeService;
import com.william.mall_server.service.WilliamNoticService;
import com.william.pojo.WilliamGoods;
import com.william.pojo.WilliamPicture;
import com.william.pojo.WilliamPictureExample;
import com.william.pojo.WilliamSysNotice;
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
        // 热门商品
        List<WilliamGoods> hotGoodsByPage = williamGoodsService.getHotGoodsByPage(new PageReq(), null);
        // 推荐商品
        List<WilliamGoods> recommendGoodsByPage = williamGoodsService.getRecommendGoodsByPage(new PageReq(), null);
        // 新品上市
        List<WilliamGoods> newGoodsPageCondition = williamGoodsService.getNewGoodsPageCondition(new PageConditionReq(), null);
        // 猜你喜欢
        // .....
        // 首页广告图片
        HomePageAdvResp homePageAdv = williamAdvService.getHomePageAdv(tenantId, client, null);
        homePageResp.setHomeNoticList(noticeList);
        homePageResp.setHotGoodsList(hotGoodsByPage);
        homePageResp.setRecommendGoodsList(recommendGoodsByPage);
        homePageResp.setBannerList(bannerList);
        homePageResp.setNewGoodsList(newGoodsPageCondition);
        homePageResp.setHomePageAdvResp(homePageAdv);
        return homePageResp;
    }
}
