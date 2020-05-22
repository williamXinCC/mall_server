package com.william.mall_server.service;

import com.william.pojo.req.LoginByCaptchaOrPassword;
import com.william.pojo.resp.LoginResp;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:43
 * @since Copyright(c) 爱睿智健康科技
 */
public interface WilliamLoginService {

    LoginResp getLoginByPhoneAndCaptch(LoginByCaptchaOrPassword loginByCaptchaOrPassword);

    LoginResp getLoginByPhoneAndPassword(LoginByCaptchaOrPassword loginByCaptchaOrPassword);
}
