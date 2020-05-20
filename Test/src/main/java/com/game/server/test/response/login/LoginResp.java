package com.game.server.test.response.login;

import com.game.server.basic.common.contants.ProtocolId;
import com.game.server.basic.common.proto.login.LoginProto;
import com.game.server.test.response.base.BaseResponse;
import com.game.server.test.robot.Robot;
import org.qiunet.test.response.annotation.Response;

/***
 *
 * @author qiunet
 * 2020-04-25 18:49
 **/

@Response(ID = ProtocolId.Login.RESP_LOGIN)
public class LoginResp extends BaseResponse<LoginProto.LoginResponse> {
	@Override
	public void response(Robot robot, LoginProto.LoginResponse loginResponse) {
		System.out.println("===================="+loginResponse.getUid());
	}
}
