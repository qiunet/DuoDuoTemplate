package com.game.template.server.handler.login;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.cfg.resource.IResourceCfg;
import com.game.template.basic.common.cfg.resource.ResourceDataCfg;
import com.game.template.basic.common.cfg.resource.ResourceManager;
import com.game.template.basic.common.contants.ProtocolId;
import com.game.template.basic.common.proto.login.LoginProto;
import com.game.template.server.common.handler.BaseHandler;
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
	public void handler(PlayerActor playerActor, IWebSocketRequest<LoginProto.LoginRequest> context) throws Exception {
		System.out.println("=========="+context.getRequestData().getOpenid());
		IResourceCfg resourceCfg = ResourceManager.getInstance().getResourceCfg(1);
		System.out.println(resourceCfg.type());

		playerActor.sendPacket(ProtocolId.Login.RESP_LOGIN, LoginProto.LoginResponse.newBuilder()
			.setNeedRegister(true)
			.setUid(10000)
			.build());
	}

	@Override
	public boolean needAuth() {
		return false;
	}
}
