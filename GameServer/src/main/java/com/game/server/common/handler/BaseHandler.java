package com.game.server.common.handler;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.logger.GameLogger;
import com.game.server.common.monitor.RequestMonitor;
import org.qiunet.flash.handler.context.request.data.pb.IpbRequestData;
import org.qiunet.flash.handler.context.request.persistconn.IPersistConnRequest;
import org.qiunet.flash.handler.handler.persistconn.PersistConnPbHandler;
import org.slf4j.Logger;

/***
 *
 * @author qiunet
 * 2020-04-25 17:06
 **/
public abstract class BaseHandler<RequestData extends IpbRequestData> extends PersistConnPbHandler<PlayerActor, RequestData> {

	protected Logger logger = GameLogger.GAME_HANDLER.getLogger();

	@Override
	public void handler(PlayerActor playerActor, IPersistConnRequest<RequestData> context) throws Exception {
		if (needAuth()) {
			// 没有鉴权的请求. 监听意义不大. 况且不一定有playerId
			RequestMonitor.instance.addRequest(playerActor.getPlayerId(), this.getProtocolID());
		}
		this.handler0(playerActor, context);
	}

	protected abstract void handler0(PlayerActor playerActor, IPersistConnRequest<RequestData> context) throws Exception;
}
