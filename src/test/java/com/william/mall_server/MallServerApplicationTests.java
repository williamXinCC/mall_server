package com.william.mall_server;

import cn.hutool.json.JSONUtil;
import com.william.mall_server.controller.WilliamEvaluateController;
import com.william.mall_server.service.WilliamAdvService;
import com.william.mall_server.service.WilliamOrderService;
import com.william.pojo.Result;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.EvaluateCountResp;
import com.william.pojo.resp.OrderResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MallServerApplicationTests {

    @Autowired
    private WilliamEvaluateController evaluateController;

    PublicReq publicReq = new PublicReq();

    BaseRequest baseRequest = new BaseRequest();

    @Autowired
    private WilliamAdvService williamAdvService;

    @Autowired
    private WilliamOrderService williamOrderService;

    @Test
    public void testAdv(){
        PageConditionReq pageConditionReq = new PageConditionReq();
        pageConditionReq.setTenantId("123");
        pageConditionReq.setClient("123");
        pageConditionReq.setKeyName("1");
        String uid = "5c0880505aedb400012dfd89";
        List<OrderResp> orderListByStatus = williamOrderService.getOrderListByStatus(pageConditionReq, uid);
        System.out.println(JSONUtil.toJsonPrettyStr(orderListByStatus));
    }

    @Test
    public void getTest(){
        publicReq.setKeyName("5de4c06986f91705fc413856");
        EvaluateCountResp countByType = evaluateController.getCountByType(publicReq);
        System.out.println(JSONUtil.toJsonStr(countByType));
    }


}
