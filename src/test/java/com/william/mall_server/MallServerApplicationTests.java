package com.william.mall_server;

import cn.hutool.json.JSONUtil;
import com.william.mall_server.controller.WilliamEvaluateController;
import com.william.mall_server.service.WilliamAdvService;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.EvaluateCountResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MallServerApplicationTests {

    @Autowired
    private WilliamEvaluateController evaluateController;

    PublicReq publicReq = new PublicReq();

    BaseRequest baseRequest = new BaseRequest();

    @Autowired
    private WilliamAdvService williamAdvService;

    @Test
    public void testAdv(){
    }

    @Test
    public void getTest(){
        publicReq.setKeyName("5de4c06986f91705fc413856");
        EvaluateCountResp countByType = evaluateController.getCountByType(publicReq);
        System.out.println(JSONUtil.toJsonStr(countByType));
    }


}
