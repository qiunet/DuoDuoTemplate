package com.game.template.server.common.context;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.contants.ProtocolId;
import com.game.template.basic.common.proto.common.CommonProto;
import com.game.template.basic.common.session.GameSession;
import io.netty.channel.Channel;
import org.qiunet.flash.handler.context.response.push.DefaultProtobufMessage;
import org.qiunet.flash.handler.context.response.push.IResponseMessage;
import org.qiunet.flash.handler.context.session.ISession;
import org.qiunet.flash.handler.netty.server.param.adapter.IStartupContext;

/***
 *
 * @author qiunet
 * 2020-04-25 15:15
 **/
public class StartupContext implements IStartupContext<GameSession, PlayerActor> {

	@Override
	public GameSession buildSession(Channel channel) {
		return new GameSession(channel);
	}

	@Override
	public PlayerActor buildPlayerActor(ISession session) {
		return new PlayerActor((GameSession) session);
	}

	@Override
	public IResponseMessage getHandlerNotFound() {
		return new DefaultProtobufMessage(ProtocolId.System.HANDLER_NOT_FIND,
			CommonProto.DefaultErrorResponse.newBuilder()
				.build());
	}

	@Override
	public IResponseMessage exception(Throwable cause) {
		return new DefaultProtobufMessage(ProtocolId.System.SERVER_EXCEPTION,
			CommonProto.DefaultErrorResponse.newBuilder()
				.build());
	}
}
