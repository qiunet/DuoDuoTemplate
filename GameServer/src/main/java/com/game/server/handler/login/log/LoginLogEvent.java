package com.game.server.handler.login.log;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.log.BasePlayerLogEvent;
import com.game.server.basic.common.log.LogType;

/***
 *
 *
 * @author qiunet
 * 2020-05-14 18:03
 ***/
public class LoginLogEvent extends BasePlayerLogEvent {

	public LoginLogEvent(PlayerActor player) {
		super(LogType.LOGIN, player);
	}

	@Override
	public String logMessage() {
		return buildMessage()
			.toString();
	}
}
