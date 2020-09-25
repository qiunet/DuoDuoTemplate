package com.game.server.handler.login.message.req;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import org.qiunet.flash.handler.context.request.data.pb.IpbRequestData;

/***
 *
 *
 * @author qiunet
 * 2020-09-25 16:34
 */
@ProtobufClass(description = "登录请求")
public class LoginRequest implements IpbRequestData {
	@Protobuf(description = "登录使用 openId")
	private String openId;
	@Protobuf(description = "登录使用 secret")
	private String secret;

	public static LoginRequest valueOf(String openId, String secret) {
		LoginRequest request = new LoginRequest();
		request.openId = openId;
		request.secret = secret;
		return request;
	}

	public String getOpenId() {
		return openId;
	}

	public String getSecret() {
		return secret;
	}
}
