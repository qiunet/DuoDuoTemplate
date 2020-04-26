package com.game.template.server.common.handler;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.logger.GameLogger;
import com.google.protobuf.GeneratedMessageV3;
import org.qiunet.flash.handler.context.request.websocket.IWebSocketRequest;
import org.qiunet.flash.handler.handler.websocket.WebSocketProtobufHandler;
import org.slf4j.Logger;

/***
 *
 * @author qiunet
 * 2020-04-25 17:06
 **/
public abstract class BaseHandler<RequestData extends GeneratedMessageV3> extends WebSocketProtobufHandler<PlayerActor, RequestData> {

	protected Logger logger = GameLogger.GAME_HANDLER.getLogger();

	@Override
	public void handler(PlayerActor playerActor, IWebSocketRequest<RequestData> context) throws Exception {
		this.handler0(playerActor, context);
	}

	protected abstract void handler0(PlayerActor playerActor, IWebSocketRequest<RequestData> context) throws Exception;
}
