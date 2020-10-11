package com.game.server.common.context;

import com.game.server.basic.common.actor.PlayerActor;
import org.qiunet.flash.handler.context.session.DSession;
import org.qiunet.flash.handler.netty.server.param.adapter.IStartupContext;

/***
 *
 * @author qiunet
 * 2020-04-25 15:15
 **/
public class StartupContext implements IStartupContext<PlayerActor> {

	@Override
	public PlayerActor buildMessageActor(DSession session) {
		return new PlayerActor(session);
	}

}
