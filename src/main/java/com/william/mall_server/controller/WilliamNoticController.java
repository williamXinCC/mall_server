package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamNoticService;
import com.william.pojo.WilliamSysNotice;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/20 17:34
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/notice")
public class WilliamNoticController {

    @Autowired
    private WilliamNoticService williamNoticService;

    /**
     * 公告详情
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : com.william.pojo.WilliamSysNotice
     */
    @PostMapping(value = "/getNoticeInfo")
    public WilliamSysNotice getNoticeInfo(@RequestBody PublicReq publicReq, @RequestParam("uid") String uid){
        return williamNoticService.getNoticeInfo(publicReq,uid);
    }

    /**
     * 类型获取公告 列表
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamSysNotice>
     */
    @PostMapping(value = "/getNoticeListByType")
    public List<WilliamSysNotice> getNoticeListByType(@RequestBody PageConditionReq pageConditionReq,@RequestParam("uid")String uid){
        return williamNoticService.getNoticeListByType(pageConditionReq);
    }
}
