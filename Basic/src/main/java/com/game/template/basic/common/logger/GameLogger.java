package com.game.template.basic.common.logger;

import org.qiunet.utils.logger.ILoggerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *
 * @author qiunet
 * 2020-04-25 15:51
 **/
public enum  GameLogger implements ILoggerType {

	COMM_LOGGER("CommLogger"),
	GAME_HANDLER("GameHandler"),
	GAME_MONITOR("GameMonitor"),
	;
	private String loogerName;

	GameLogger(String loogerName) {
		this.loogerName = loogerName;
	}

	@Override
	public Logger getLogger() {
		return LoggerFactory.getLogger(loogerName);
	}
}
