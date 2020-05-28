package com.william.mall_server.controller;

import com.william.mall_server.service.WilliamLoginService;
import com.william.pojo.req.BaseRequest;
import com.william.pojo.req.LoginByCaptchaOrPassword;
import com.william.pojo.resp.LoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinchuang
 * @version v1.0
 * @date 2020/5/18 17:41
 * @since Copyright(c) 爱睿智健康科技
 */
@RestController
@RequestMapping("/login")
public class WilliamLoginController {

    @Autowired
    private WilliamLoginService williamLoginService;

    /**
     * token登录
     * @author     xinchuang
     * @param baseRequest :
     * @param token :
     * @return : com.william.pojo.resp.LoginResp
     */
    @PostMapping(value = "/loginByToken")
    public LoginResp loginByToken(@RequestBody BaseRequest baseRequest, @RequestParam("token") String token,@RequestParam("uid") String uid){
        return williamLoginService.loginByToken(baseRequest,token,uid);
    }

    /**
     * 手机验证码登录
     * @author     xinchuang
     * @param loginByCaptchaOrPassword :
     * @return : com.william.pojo.resp.LoginResp
     */
    @PostMapping(value = "/getLoginByPhoneAndCaptch")
    public LoginResp getLoginByPhoneAndCaptch(@RequestBody LoginByCaptchaOrPassword loginByCaptchaOrPassword){
        return williamLoginService.getLoginByPhoneAndCaptch(loginByCaptchaOrPassword);
    }


    /**
     * 手机密码登录
     * @author     xinchuang
     * @param loginByCaptchaOrPassword :
     * @return : com.william.pojo.resp.LoginResp
     */
    @PostMapping(value = "/getLoginByPhoneAndPassword")
    public LoginResp getLoginByPhoneAndPassword(@RequestBody LoginByCaptchaOrPassword loginByCaptchaOrPassword){
        return williamLoginService.getLoginByPhoneAndPassword(loginByCaptchaOrPassword);
    }
}
