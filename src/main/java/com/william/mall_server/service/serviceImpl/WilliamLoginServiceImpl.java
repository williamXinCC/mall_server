package com.william.mall_server.service.serviceImpl;

import com.william.constant.Constant;
import com.william.mall_server.mapper.WilliamCustomerMapper;
import com.william.mall_server.redis.RedisService;
import com.william.mall_server.service.WilliamLoginService;
import com.william.mall_server.token.TokenTools;
import com.william.pojo.WilliamCustomer;
import com.william.pojo.req.LoginByCaptchaOrPassword;
import com.william.pojo.resp.LoginResp;
import com.william.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:43
 * @since Copyright(c) 爱睿智健康科技
 */
@Service
public class WilliamLoginServiceImpl implements WilliamLoginService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private WilliamCustomerMapper williamCustomerMapper;

    /**
     * 验证码登录
     * @author     xinchuang
     * @param loginByCaptchaOrPassword :
     * @return : com.william.pojo.resp.LoginResp
     */
    @Override
    public LoginResp getLoginByPhoneAndCaptch(LoginByCaptchaOrPassword loginByCaptchaOrPassword) {
        String reidsCaptch = redisService.getStr(Constant.CAPTCHA.concat(loginByCaptchaOrPassword.getCustomerPhone()));
        if(Objects.equals(loginByCaptchaOrPassword.getCondition(),reidsCaptch)){
            WilliamCustomer williamCustomer = williamCustomerMapper.selectByPhone(loginByCaptchaOrPassword.getCustomerPhone());
            if(Objects.nonNull(williamCustomer)){
                return getLoginResp(loginByCaptchaOrPassword, williamCustomer.getCustomerId(), williamCustomer);
            }
        }
        return null;
    }

    /**
     * 手机号密码登录
     * @author     xinchuang
     * @param loginByCaptchaOrPassword :
     * @return : com.william.pojo.resp.LoginResp
     */
    @Override
    public LoginResp getLoginByPhoneAndPassword(LoginByCaptchaOrPassword loginByCaptchaOrPassword) {
        String phone = loginByCaptchaOrPassword.getCustomerPhone();
        String password = Md5Util.md5(loginByCaptchaOrPassword.getCondition());
        WilliamCustomer williamCustomer = williamCustomerMapper.getLoginByPhoneAndPassword(phone,password);
        if(Objects.nonNull(williamCustomer)){
            String customerPassword = williamCustomer.getCustomerPassword();
            if(Objects.equals(customerPassword,password)){
                return getLoginResp(loginByCaptchaOrPassword, williamCustomer.getCustomerId(), williamCustomer);
            }
        }
        return null;
    }

    /**
     * 获取loginResp
     * @author     xinchuang
     * @param loginByCaptchaOrPassword :
     * @param uid :
     * @param williamCustomer :
     * @return : com.william.pojo.resp.LoginResp
     */
    private LoginResp getLoginResp(LoginByCaptchaOrPassword loginByCaptchaOrPassword, String uid, WilliamCustomer williamCustomer) {
        LoginResp loginResp = new LoginResp();
        loginResp.setCustomer(williamCustomer);
        String token = TokenTools.createToken(uid, williamCustomer.getCustomerPhone(), loginByCaptchaOrPassword.getTimeStamp(), "william");
        loginResp.setAccessToken(token);
        return loginResp;
    }
}
