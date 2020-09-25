package com.game.server.test.response.login;

import com.game.server.basic.common.contants.ProtocolId;
import com.game.server.handler.login.message.resp.LoginResponse;
import com.game.server.test.response.base.BaseResponse;
import com.game.server.test.robot.Robot;
import org.qiunet.test.response.annotation.Response;

/***
 *
 * @author qiunet
 * 2020-04-25 18:49
 **/

@Response(ID = ProtocolId.Login.RESP_LOGIN)
public class LoginResp extends BaseResponse<LoginResponse> {
	@Override
	public void response(Robot robot, LoginResponse loginResponse) {
		System.out.println("===================="+loginResponse.getPlayerId());
	}
}
