package com.william.mall_server.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.william.constant.Constant;
import com.william.mall_server.mapper.WilliamGoodsCategoryMapper;
import com.william.mall_server.service.WilliamGoodsCategoryService;
import com.william.pojo.WilliamGoodsCategory;
import com.william.pojo.WilliamGoodsCategoryExample;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PageConditionReq;
import com.william.pojo.req.PublicReq;
import com.william.pojo.resp.CategoryTreeNodesResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/21 11:36
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamGoodsCategoryServiceImpl implements WilliamGoodsCategoryService {

    @Value("${tenant_category_pid}")
    private String cpid;

    @Autowired
    private WilliamGoodsCategoryMapper williamGoodsCategoryMapper;

    /**
     * 根据展示页面 查询推荐分类
     * @author     xinchuang
     * @param pageConditionReq :
     * @return : java.util.List<com.william.pojo.WilliamGoodsCategory>
     */
    @Override
    public List<WilliamGoodsCategory> getRecommendCategoryByPage(PageConditionReq pageConditionReq) {
        Integer startPage = pageConditionReq.getStartPage() == null ? 1 : Integer.parseInt(pageConditionReq.getStartPage());
        Integer pageSize = pageConditionReq.getPageSize() == null ? 10 : Integer.parseInt(pageConditionReq.getPageSize());
        WilliamGoodsCategoryExample williamGoodsCategoryExample = new WilliamGoodsCategoryExample();
        WilliamGoodsCategoryExample.Criteria criteria = williamGoodsCategoryExample.createCriteria();
        criteria.andTenantIdEqualTo(pageConditionReq.getTenantId());
        criteria.andClientEqualTo(pageConditionReq.getClient());
        criteria.andRecommendPageEqualTo(Integer.parseInt(pageConditionReq.getKeyName()));
        williamGoodsCategoryExample.setOrderByClause("seq asc");
        PageHelper.startPage(startPage,pageSize,false);
        return williamGoodsCategoryMapper.selectByExample(williamGoodsCategoryExample);
    }


    // ========================== 分类树 开始
    @Override
    public List<CategoryTreeNodesResp> getGoodsCategoryTreeList(BaseRequest baseRequest, String uid) {
        String tenantId = baseRequest.getTenantId();
        String client = baseRequest.getClient();
        WilliamGoodsCategoryExample williamGoodsCategoryExample = new WilliamGoodsCategoryExample();
        WilliamGoodsCategoryExample.Criteria criteria = williamGoodsCategoryExample.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andClientEqualTo(client);
        criteria.andAppShowEqualTo(Constant.TYPE_ONE);
        criteria.andPidEqualTo(Integer.parseInt(cpid));
        williamGoodsCategoryExample.setOrderByClause("seq asc");
        List<WilliamGoodsCategory> categoryList = williamGoodsCategoryMapper.selectByExample(williamGoodsCategoryExample);
        List<CategoryTreeNodesResp> categoryTreeNodesRespList = new ArrayList<>();
        CategoryTreeNodesResp categoryTreeNodesResp;
        for (WilliamGoodsCategory williamGoodsCategory : categoryList) {
            categoryTreeNodesResp = new CategoryTreeNodesResp();
            categoryTreeNodesResp.setIcon(williamGoodsCategory.getIcon());
            categoryTreeNodesResp.setSeq(williamGoodsCategory.getSeq());
            categoryTreeNodesResp.setId(williamGoodsCategory.getId());
            categoryTreeNodesResp.setPid(williamGoodsCategory.getPid());
            categoryTreeNodesResp.setTitle(williamGoodsCategory.getName());
            categoryTreeNodesResp.setAvdImage(williamGoodsCategory.getImage());
            categoryTreeNodesRespList.add(categoryTreeNodesResp);
        }
        List<CategoryTreeNodesResp> recursion = recursion(categoryTreeNodesRespList, tenantId, client);
        return recursion;
    }

    /**
     * 递归查询分类
     * @author     xinchuang
     * @param treeNodesRespList :
     * @param tenantId :
     * @param clientId :
     * @return : java.util.List<com.william.pojo.resp.CategoryTreeNodesResp>
     */
    private List<CategoryTreeNodesResp> recursion(List<CategoryTreeNodesResp> treeNodesRespList,String tenantId, String clientId){
        List<CategoryTreeNodesResp> list = null;
        for (CategoryTreeNodesResp categoryTreeNodesResp : treeNodesRespList) {
            List<CategoryTreeNodesResp> recursions = recursions(categoryTreeNodesResp.getId(), tenantId, clientId);
            categoryTreeNodesResp.setChild(recursions);
        }
        return treeNodesRespList;
    }

    private List<CategoryTreeNodesResp> recursions(Integer id,String tenantId, String clientId){
        WilliamGoodsCategoryExample williamGoodsCategoryExample = new WilliamGoodsCategoryExample();
        WilliamGoodsCategoryExample.Criteria criteria = williamGoodsCategoryExample.createCriteria();
        criteria.andTenantIdEqualTo(tenantId);
        criteria.andClientEqualTo(clientId);
        criteria.andAppShowEqualTo(Constant.TYPE_ONE);
        criteria.andPidEqualTo(id);
        williamGoodsCategoryExample.setOrderByClause("seq asc");
        List<WilliamGoodsCategory> categoryList = williamGoodsCategoryMapper.selectByExample(williamGoodsCategoryExample);
        List<CategoryTreeNodesResp> list = null;
        for (WilliamGoodsCategory williamGoodsCategory : categoryList) {
            CategoryTreeNodesResp convert = convert(williamGoodsCategory);
            convert.setChild(recursions(williamGoodsCategory.getId(),tenantId,clientId));
            list = new ArrayList<>();
            list.add(convert);
        }
        return list;
    }

    private CategoryTreeNodesResp convert(WilliamGoodsCategory williamGoodsCategory){
        CategoryTreeNodesResp categoryTreeNodesResp = new CategoryTreeNodesResp();
        categoryTreeNodesResp.setIcon(williamGoodsCategory.getIcon());
        categoryTreeNodesResp.setSeq(williamGoodsCategory.getSeq());
        categoryTreeNodesResp.setId(williamGoodsCategory.getId());
        categoryTreeNodesResp.setPid(williamGoodsCategory.getPid());
        categoryTreeNodesResp.setTitle(williamGoodsCategory.getName());
        categoryTreeNodesResp.setAvdImage(williamGoodsCategory.getImage());
        return categoryTreeNodesResp;
    }

    // =====================================  分类树结束
}
