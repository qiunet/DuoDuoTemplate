package com.game.template.test.response.login;

import com.game.template.basic.common.contants.ProtocolId;
import com.game.template.basic.common.proto.login.LoginProto;
import com.game.template.test.response.base.BaseResponse;
import com.game.template.test.robot.Robot;
import org.qiunet.test.response.ILongConnResponse;
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
