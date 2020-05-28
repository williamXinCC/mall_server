package com.william.mall_server.service.serviceImpl;

import com.william.constant.RespCodeAndMsg;
import com.william.mall_server.mapper.WilliamCustomerMapper;
import com.william.mall_server.service.WilliamCustomerService;
import com.william.pojo.Result;
import com.william.pojo.WilliamCustomer;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.UpdateCustomerReq;
import com.william.pojo.req.UpdatePassword;
import com.william.utils.Md5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:22
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamCustomerServiceImpl implements WilliamCustomerService {

    @Autowired
    private WilliamCustomerMapper williamCustomerMapper;

    @Override
    public WilliamCustomer getCustomerInfo(BaseRequest baseRequest, String uid) {
        return williamCustomerMapper.selectByPrimaryKey(uid);
    }

    @Override
    public Result updateCustomerInfo(UpdateCustomerReq updateCustomerReq, String uid) {
        WilliamCustomer williamCustomer = new WilliamCustomer();
        BeanUtils.copyProperties(updateCustomerReq,williamCustomer);
        williamCustomerMapper.updateByPrimaryKeySelective(williamCustomer);
        return Result.getResult(RespCodeAndMsg.OPERATE_SUCCESS);
    }

    @Override
    public void updatePassword(UpdatePassword updatePassword, String uid) {
        String password = updatePassword.getPassword();
        String md5Password = Md5Util.md5(password);
        WilliamCustomer williamCustomer = new WilliamCustomer();
        williamCustomer.setCustomerPassword(md5Password);
        williamCustomer.setCustomerId(uid);
        williamCustomerMapper.updateByPrimaryKeySelective(williamCustomer);
    }

}
