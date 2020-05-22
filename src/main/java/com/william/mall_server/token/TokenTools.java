package com.william.mall_server.token;


import com.william.constant.Constant;
import com.william.pojo.Token;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  token工具类
 * @author     xinchuang
 * @date       2018/11/28 17:56
 * @version    v1.0
 * @since      @Copyright(c) 爱睿智健康科技(北京)有限公司
 */
public class TokenTools {

	/**
	 * 生成token
	 * @author     xinchuang
	 * @param uid :
	 * @param phoneNumber :
	 * @param timestamp :
	 * @param channel :
	 * @return : java.lang.String
	 */
	public static String createToken(String uid, String phoneNumber, String timestamp, String channel) {
		Token token = new Token();
		token.setUid(uid);
		token.setLoginPhoneNumber(phoneNumber);
		token.setTimeStamp(timestamp);
		token.setChannel(channel);
		String logintoken = TokenProccessor.getInstance().makeToken(token);
		Pattern p = Pattern.compile(Constant.REPLACE);
		Matcher m = p.matcher(logintoken);
		return m.replaceAll("");
	}
}
