package com.william.mall_server.token;


import com.william.pojo.Token;
import com.william.utils.Base64Utils;

/**
 *  token生成
 * @author     xinchuang
 * @date       2018/11/28 17:56
 * @version    v1.0
 * @since      @Copyright(c) 爱睿智健康科技(北京)有限公司
 */
public class TokenProccessor {

	private TokenProccessor() {
	};

	private static final TokenProccessor INSTANCE = new TokenProccessor();

	public static TokenProccessor getInstance() {
		return INSTANCE;
	}

	/**
	 * 生成Token
	 * @author     xinchuang
	 * @param token :
	 * @return : java.lang.String
	 */
	public String makeToken(Token token) {
		String resultToken = "-9999";
		resultToken = Base64Utils.getBase64(
				token.getUid() + "-" + token.getLoginPhoneNumber() + "-" + token.getTimeStamp() + "-" + token.getChannel());
		return resultToken;
	}

	/**
	 * Token转化为实体
	 * @param token
	 * @return
	 */
	public Token converToken(String token) {
		Token bean = new Token();
		String stoken = Base64Utils.getFromBase64(token);
		String[] tokenbean = stoken.split("-");
		if (tokenbean.length == 4) {
			bean.setUid(tokenbean[0]);
			bean.setLoginPhoneNumber(tokenbean[1]);
			bean.setTimeStamp(tokenbean[2]);
			bean.setChannel(tokenbean[3]);
		}
		return bean;
	}
}
