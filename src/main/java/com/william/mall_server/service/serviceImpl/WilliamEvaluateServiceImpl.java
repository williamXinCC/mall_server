package com.william.mall_server.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.william.mall_server.mapper.WilliamEvaluateMapper;
import com.william.mall_server.service.WilliamEvaluateService;
import com.william.pojo.WilliamEvaluate;
import com.william.pojo.WilliamEvaluateExample;
import com.william.pojo.req.EvaluateListReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.EvaluateCountResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/19 15:55
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamEvaluateServiceImpl implements WilliamEvaluateService {

    @Autowired
    private WilliamEvaluateMapper williamEvaluateMapper;
    /**
     * 商品评价
     * @author     xinchuang
     * @param evaluateListReq :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamEvaluate>
     */
    @Override
    public List<WilliamEvaluate> getEvaluateListByGoodsIdAndType(EvaluateListReq evaluateListReq, String uid) {
        Integer startPage = evaluateListReq.getStartPage() == null ? 1 : Integer.parseInt(evaluateListReq.getStartPage());
        Integer pageSize = evaluateListReq.getPageSize() == null ? 10 : Integer.parseInt(evaluateListReq.getPageSize());
        if(Objects.equals(evaluateListReq.getType(),"0")){
            WilliamEvaluateExample williamEvaluateExample = new WilliamEvaluateExample();
            WilliamEvaluateExample.Criteria criteria = williamEvaluateExample.createCriteria();
            criteria.andGoodsIdEqualTo(evaluateListReq.getGoodsId());
            criteria.andIshowEqualTo(1);
            PageHelper.startPage(startPage,pageSize,false);
            williamEvaluateMapper.selectByExample(williamEvaluateExample);
        }
        PageHelper.startPage(startPage,pageSize,false);
        return williamEvaluateMapper.getEvaluateListByGoodsIdAndType(evaluateListReq);
    }


    /**
     * 商品评价总数
     * @author     xinchuang
     * @param goodsId :
     * @return : java.lang.Integer
     */
    @Override
    public Integer getEvaluateCountByGoodsId(String goodsId) {
        return williamEvaluateMapper.getEvaluateCountByGoodsId(goodsId);
    }

    /**
     * 商品评价 分类统计
     * @author     xinchuang
     * @param publicReq :
     * @return : com.william.pojo.resp.EvaluateCountResp
     */
    @Override
    public EvaluateCountResp getCountByType(PublicReq publicReq) {
        EvaluateCountResp evaluateCountResp = williamEvaluateMapper.getCountByType(publicReq.getKeyName());
        return evaluateCountResp;
    }
}
