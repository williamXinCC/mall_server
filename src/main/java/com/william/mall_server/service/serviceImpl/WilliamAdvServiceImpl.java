package com.william.mall_server.service.serviceImpl;

import com.william.mall_server.mapper.WilliamPictureMapper;
import com.william.mall_server.service.WilliamAdvService;
import com.william.pojo.Result;
import com.william.pojo.WilliamPicture;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.resp.HomePageAdvResp;
import com.william.pojo.resp.HomePageResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/22 14:30
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamAdvServiceImpl implements WilliamAdvService {

    @Autowired
    private WilliamPictureMapper williamPictureMapper;

    @Override
    public HomePageAdvResp getHomePageAdv(String tenantId,String client, String uid) {
        List<WilliamPicture> pictureList = williamPictureMapper.getHomePageAdv(tenantId,client);
        HomePageAdvResp homePageAdvResp = new HomePageAdvResp();
        pictureList.stream().forEach(i->{
            // 顶部
            if(4 == i.getCategoryId()){
                homePageAdvResp.getHomePageTop().add(i);
            }
            // 热门
            if(5 == i.getCategoryId()){
                homePageAdvResp.getHomePageHot().add(i);
            }
            // 推荐
            if(6 == i.getCategoryId()){
                homePageAdvResp.getHomePageRecommend().add(i);
            }
            // 新品
            if(7 == i.getCategoryId()){
                homePageAdvResp.getHomePageNew().add(i);
            }
        });
        return homePageAdvResp;
    }
}
