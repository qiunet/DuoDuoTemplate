package com.game.server.common.monitor;

import com.game.server.basic.common.logger.GameLogger;
import org.qiunet.flash.handler.handler.mapping.RequestHandlerMapping;
import org.qiunet.function.monitor.DefaultMonitor;
import org.qiunet.function.monitor.IMonitor;
import org.qiunet.function.monitor.IMonitorData;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/***
 *
 * @author qiunet
 * 2020-04-26 21:53
 **/
public enum RequestMonitor {
	instance;

	private Logger logger = GameLogger.GAME_MONITOR.getLogger();

	private IMonitor<Long, Integer> requestMonitor = new DefaultMonitor<>(
		this::getCheckCount, this::handlerTrigger, 60, TimeUnit.SECONDS
	);

	private int getCheckCount(int requestId){
		return RequestHandlerMapping.getInstance().getHandler(requestId).checkCount();
	}

	private boolean handlerTrigger(IMonitorData<Long , Integer> data) {
		logger.error("playerId:[{}] requestID:[{}] count:[{}] trigger monitor", data.getType(), data.getSubType(), data.triggerNum());
		return true;
	}

	public void addRequest(long playerId, int requestId) {
		this.requestMonitor.add(playerId, requestId);
	}
}
