package com.game.server.basic.common.session;

import com.game.server.basic.common.actor.PlayerActor;
import io.netty.channel.Channel;
import org.qiunet.flash.handler.context.session.AbstractSession;

/***
 *
 * @author qiunet
 * 2020-04-15 21:00
 **/
public class GameSession extends AbstractSession<PlayerActor> {

	public GameSession(Channel channel) {
		super(channel);
	}
}
