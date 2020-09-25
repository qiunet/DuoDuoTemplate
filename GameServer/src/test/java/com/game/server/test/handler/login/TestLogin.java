package com.game.server.test.handler.login;

import com.game.server.basic.common.contants.ProtocolId;
import com.game.server.handler.login.message.req.LoginRequest;
import com.game.server.test.handler.base.BaseTestCase;
import com.game.server.test.robot.Robot;

/***
 *
 * @author qiunet
 * 2020-04-25 18:51
 **/
public class TestLogin extends BaseTestCase<LoginRequest> {

	@Override
	protected LoginRequest requestBuild(Robot robot) {
		return LoginRequest.valueOf(robot.getRobotInitInfo().getOpenId(), robot.getRobotInitInfo().getOpenId());
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
