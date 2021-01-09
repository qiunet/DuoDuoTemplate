package com.game.server.handler.login;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.cfg.resource.ResourceDataCfg;
import com.game.server.basic.common.contants.ProtocolId;
import com.game.server.basic.login.LoginService;
import com.game.server.basic.login.entity.LoginBo;
import com.game.server.basic.player.PlayerService;
import com.game.server.basic.player.entity.PlayerBo;
import com.game.server.common.handler.BaseHandler;
import com.game.server.handler.login.log.LoginLogEvent;
import com.game.server.handler.login.message.req.LoginRequest;
import com.game.server.handler.login.message.resp.LoginResponse;
import org.qiunet.cfg.annotation.CfgWrapperAutoWired;
import org.qiunet.cfg.wrapper.ISimpleMapCfgWrapper;
import org.qiunet.flash.handler.common.annotation.RequestHandler;
import org.qiunet.flash.handler.context.request.persistconn.IPersistConnRequest;

/***
 *
 * @author qiunet
 * 2020-04-25 17:08
 **/
@RequestHandler(ID = ProtocolId.Login.REQ_LOGIN, desc = "登录")
public class LoginHandler extends BaseHandler<LoginRequest> {
	/***
	 * 一个wrapper使用示例
	 */
	@CfgWrapperAutoWired
	private ISimpleMapCfgWrapper<Integer, ResourceDataCfg> dataResourceWrapper;

	@Override
	public void handler0(PlayerActor playerActor, IPersistConnRequest<LoginRequest> context) throws Exception {
		LoginRequest request = context.getRequestData();

		LoginBo loginBo = LoginService.instance.getLoginBo(request.getOpenId());
		if (loginBo == null) {
			loginBo = LoginService.instance.register(request.getOpenId(), request.getSecret());
			PlayerService.instance.register(loginBo);
		}
		PlayerBo playerBo = PlayerService.instance.getPlayerBo(loginBo.getDo().getPlayerId());
		playerActor.setPlayerBo(playerBo);

		new LoginLogEvent(playerActor).send();

		playerActor.sendPacket(LoginResponse.valueOf(loginBo.getDo().getPlayerId(), true));
	}

	@Override
	public boolean needAuth() {
		return false;
	}
}
