package com.game.server.test.handler.login;

import com.game.server.basic.common.contants.ProtocolId;
import com.game.server.basic.common.proto.login.LoginProto;
import com.game.server.test.handler.base.BaseTestCase;
import com.game.server.test.robot.Robot;

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
