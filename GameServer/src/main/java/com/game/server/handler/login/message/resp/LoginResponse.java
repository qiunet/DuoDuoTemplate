package com.game.server.handler.login.message.resp;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.server.basic.common.contants.ProtocolId;
import org.qiunet.flash.handler.context.request.data.pb.IpbResponseData;
import org.qiunet.flash.handler.context.request.data.pb.PbResponse;

/***
 *
 *
 * @author qiunet
 * 2020-09-25 16:36
 */
@PbResponse(ProtocolId.Login.RESP_LOGIN)
@ProtobufClass(description = "登录下行")
public class LoginResponse implements IpbResponseData {
	@Protobuf(description = "玩家id")
	private long playerId;
	@Protobuf(description = "是否需要注册")
	private boolean needRegister;

	public static LoginResponse valueOf(long playerId, boolean needRegister) {
		LoginResponse response = new LoginResponse();
		response.needRegister = needRegister;
		response.playerId = playerId;
		return response;
	}

	public boolean isNeedRegister() {
		return needRegister;
	}

	public long getPlayerId() {
		return playerId;
	}
}
