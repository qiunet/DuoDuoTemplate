package com.game.server.server.handler.login;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.cfg.resource.ResourceDataCfg;
import com.game.server.basic.common.contants.ProtocolId;
import com.game.server.basic.common.proto.login.LoginProto;
import com.game.server.basic.login.LoginService;
import com.game.server.basic.login.entity.LoginBo;
import com.game.server.basic.player.PlayerService;
import com.game.server.basic.player.entity.PlayerBo;
import com.game.server.server.common.handler.BaseHandler;
import org.qiunet.cfg.annotation.CfgWrapperAutoWired;
import org.qiunet.cfg.wrapper.ISimpleMapCfgWrapper;
import org.qiunet.flash.handler.common.annotation.RequestHandler;
import org.qiunet.flash.handler.context.request.websocket.IWebSocketRequest;

/***
 *
 * @author qiunet
 * 2020-04-25 17:08
 **/
@RequestHandler(ID = ProtocolId.Login.REQ_LOGIN, desc = "登录")
public class LoginHandler extends BaseHandler<LoginProto.LoginRequest> {
	/***
	 * 一个wrapper使用示例
	 */
	@CfgWrapperAutoWired
	private ISimpleMapCfgWrapper<Integer, ResourceDataCfg> dataResourceWrapper;

	@Override
	public void handler0(PlayerActor playerActor, IWebSocketRequest<LoginProto.LoginRequest> context) throws Exception {
		LoginProto.LoginRequest request = context.getRequestData();
		LoginBo loginBo = LoginService.instance.getLoginBo(request.getOpenid());
		if (loginBo == null) {
			loginBo = LoginService.instance.register(request.getOpenid(), request.getSecret());
			PlayerService.instance.register(loginBo);
		}
		PlayerBo playerBo = PlayerService.instance.getPlayerBo(loginBo.getDo().getPlayerId());
		playerActor.auth(playerBo);

		playerActor.sendPacket(ProtocolId.Login.RESP_LOGIN, LoginProto.LoginResponse.newBuilder()
			.setUid(loginBo.getDo().getPlayerId())
			.setNeedRegister(true)
			.build());
	}

	@Override
	public boolean needAuth() {
		return false;
	}
}