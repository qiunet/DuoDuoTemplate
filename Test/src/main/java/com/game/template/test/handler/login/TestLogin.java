package com.game.template.test.handler.login;

import com.game.template.basic.common.contants.ProtocolId;
import com.game.template.basic.common.proto.login.LoginProto;
import com.game.template.test.handler.base.BaseTestCase;
import com.game.template.test.response.base.BaseResponse;
import com.game.template.test.robot.Robot;

/***
 *
 * @author qiunet
 * 2020-04-25 18:51
 **/
public class TestLogin extends BaseTestCase<LoginProto.LoginRequest> {

	@Override
	protected LoginProto.LoginRequest requestBuild(Robot robot) {
		return LoginProto.LoginRequest.newBuilder()
			.setOpenid(robot.getRobotInitInfo().getOpenId())
			.build();
	}

	@Override
	protected int getRequestID() {
		return ProtocolId.Login.REQ_LOGIN;
	}

	@Override
	public boolean conditionJudge(Robot robot) {
		return true;
	}

	@Override
	protected int syncWaitForResponse() {
		return ProtocolId.Login.RESP_LOGIN;
	}
}
