package com.william.mall_server.service.serviceImpl;

import com.william.constant.Constant;
import com.william.mall_server.mapper.WilliamCustomerLocationMapper;
import com.william.mall_server.service.WilliamAddressService;
import com.william.pojo.WilliamCustomerLocation;
import com.william.pojo.WilliamCustomerLocationExample;
import com.william.pojo.req.AddressReq;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.PublicReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 地址管理
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/26 11:49
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamAddressServiceImpl implements WilliamAddressService {

    @Autowired
    private WilliamCustomerLocationMapper locationMapper;

    /**
     * 地址列表
     * @author     xinchuang
     * @param baseRequest :
     * @param uid :
     * @return : java.util.List<com.william.pojo.WilliamCustomerLocation>
     */
    @Override
    public List<WilliamCustomerLocation> getCustomerAddressList(BaseRequest baseRequest, String uid) {
        WilliamCustomerLocationExample williamCustomerLocationExample = new WilliamCustomerLocationExample();
        WilliamCustomerLocationExample.Criteria criteria = williamCustomerLocationExample.createCriteria();
        criteria.andCustomerIdEqualTo(uid);
        criteria.andStatusEqualTo(Constant.STATUS_ONE_USE);
        return locationMapper.selectByExample(williamCustomerLocationExample);
    }

    /**
     * 删除地址
     * @author     xinchuang
     * @param publicReq :
     * @param uid :
     * @return : void
     */
    @Override
    public void deleteAddress(PublicReq publicReq, String uid) {
        WilliamCustomerLocation williamCustomerLocation = new WilliamCustomerLocation();
        williamCustomerLocation.setId(Integer.parseInt(publicReq.getKeyName()));
        williamCustomerLocation.setStatus(2);
        locationMapper.updateByPrimaryKeySelective(williamCustomerLocation);
    }

    @Override
    public void updateAddress(AddressReq addressReq, String uid) {
        WilliamCustomerLocation williamCustomerLocation = new WilliamCustomerLocation();
        williamCustomerLocation.setId(Integer.parseInt(addressReq.getId()));
        williamCustomerLocation.setCustomerId(uid);
        williamCustomerLocation.setReceivingName(addressReq.getReceivingName());
        williamCustomerLocation.setReceivingPhone(addressReq.getReceivingPhone());
        williamCustomerLocation.setProvince(addressReq.getProvince());
        williamCustomerLocation.setCity(addressReq.getCity());
        williamCustomerLocation.setCounty(addressReq.getCounty());
        williamCustomerLocation.setLocation(addressReq.getLocation());
        williamCustomerLocation.setChecked(Integer.parseInt(addressReq.getChecked()));
        williamCustomerLocation.setType(Integer.parseInt(addressReq.getType()));
        williamCustomerLocation.setUpdateTime(new Date());
        locationMapper.updateByPrimaryKeySelective(williamCustomerLocation);
    }

    @Override
    public void saveAddress(AddressReq addressReq, String uid) {
        WilliamCustomerLocation williamCustomerLocation = new WilliamCustomerLocation();
        williamCustomerLocation.setCustomerId(uid);
        williamCustomerLocation.setReceivingName(addressReq.getReceivingName());
        williamCustomerLocation.setReceivingPhone(addressReq.getReceivingPhone());
        williamCustomerLocation.setProvince(addressReq.getProvince());
        williamCustomerLocation.setCity(addressReq.getCity());
        williamCustomerLocation.setCounty(addressReq.getCounty());
        williamCustomerLocation.setLocation(addressReq.getLocation());
        williamCustomerLocation.setChecked(Integer.parseInt(addressReq.getChecked()));
        if(1 == Integer.parseInt(addressReq.getChecked())){
            // 修改默认地址
            locationMapper.updateAddressNoChecked(uid);
        }
        if(StringUtils.isNotBlank(addressReq.getType())){
            williamCustomerLocation.setType(Integer.parseInt(addressReq.getType()));
        }
        williamCustomerLocation.setCreateTime(new Date());
        locationMapper.insertSelective(williamCustomerLocation);
    }

    @Override
    public WilliamCustomerLocation getDefaultAddress(BaseRequest baseRequest, String uid) {
        return locationMapper.selectByUidAndCheckType(uid);
    }

    @Override
    public void updateDefaultAddress(PublicReq publicReq, String uid) {
        locationMapper.updateAddressNoChecked(uid);
        WilliamCustomerLocation williamCustomerLocation = new WilliamCustomerLocation();
        williamCustomerLocation.setId(Integer.parseInt(publicReq.getKeyName()));
        williamCustomerLocation.setChecked(1);
        locationMapper.updateByPrimaryKey(williamCustomerLocation);
    }
}
