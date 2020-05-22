package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamFootmarkService;
import com.william.pojo.WilliamBrowsingHistory;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PageReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.BrowsingHisResp;
import com.william.pojo.resp.FootmarkResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 9:27
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/footmark")
public class WilliamFootmarkController {

    @Autowired
    private WilliamFootmarkService footmarkService;

    @PostMapping(value = "/getFootmarkByUid")
    public List<FootmarkResp> getFootmarkByUid(@RequestBody PageReq pageReq, @RequestParam("uid") String uid){
        return footmarkService.getFootmarkByUid(pageReq,uid);
    }

    /**
     * 保存浏览记录
     * @author     xinchuang
     * @param goodsId :
     * @param uid :
     * @return : void
     */
    @PostMapping(value = "/saveFootmarkByUidAndGoodsId")
    public void saveFootmarkByUidAndGoodsId(@RequestParam("goodsId") String goodsId, @RequestParam(value = "uid")String uid){
        footmarkService.saveFootmarkByUidAndGoodsId(goodsId,uid);
    }

    /**
     * 查询足迹 日期调
     * @author     xinchuang
     * @param pageConditionReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.resp.BrowsingHisResp>
     */
    @PostMapping(value = "/getFootmarkByPageAndDate")
    public List<BrowsingHisResp> getFootmarkByPageAndDate(@RequestBody PageConditionReq pageConditionReq, @RequestParam(value = "uid") String uid){
        return footmarkService.getFootmarkByPageAndDate(pageConditionReq,uid);
    }
}
