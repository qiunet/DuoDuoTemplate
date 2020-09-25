package com.game.server.common.context;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.message.HandlerNotFoundResponse;
import com.game.server.basic.common.message.ServerExceptionResponse;
import org.qiunet.flash.handler.context.request.data.pb.IpbResponseData;
import org.qiunet.flash.handler.context.response.push.IResponseMessage;
import org.qiunet.flash.handler.context.session.DSession;
import org.qiunet.flash.handler.netty.server.param.adapter.IStartupContext;

/***
 *
 * @author qiunet
 * 2020-04-25 15:15
 **/
public class StartupContext implements IStartupContext<PlayerActor> {

	@Override
	public PlayerActor buildPlayerActor(DSession session) {
		return new PlayerActor(session);
	}

	@Override
	public IResponseMessage<IpbResponseData> getHandlerNotFound() {
		return new HandlerNotFoundResponse().buildResponseMessage();
	}

	@Override
	public IResponseMessage<IpbResponseData> exception(Throwable cause) {
		return new ServerExceptionResponse().buildResponseMessage();
	}
}
