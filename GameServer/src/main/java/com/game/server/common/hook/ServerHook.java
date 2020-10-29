package com.game.server.common.hook;

import com.game.server.basic.common.logger.GameLogger;
import org.qiunet.cfg.manager.CfgManagers;
import org.qiunet.data.util.ServerConfig;
import org.qiunet.flash.handler.netty.server.hook.Hook;
import org.qiunet.listener.event.data.ServerShutdownEventData;
import org.qiunet.utils.classLoader.ClassHotSwap;

import java.nio.file.Paths;

/***
 *
 * @author qiunet
 * 2020-04-25 15:43
 **/
public class ServerHook implements Hook {


	@Override
	public String getReloadCfgMsg() {
		return "RELOAD";
	}

	@Override
	public void reloadCfg() {
		try {
			CfgManagers.getInstance().reloadSetting();
		} catch (Throwable throwable) {
			GameLogger.COMM_LOGGER.error("Exception: ", throwable);
		}
	}

	@Override
	public int getHookPort() {
		return ServerConfig.getHookPort();
	}

	@Override
	public String getShutdownMsg() {
		return "SHUTDOWN0";
	}

	@Override
	public void shutdown() {
		// 触发停服监听
		ServerShutdownEventData.fireShutdownEventHandler();
	}

	@Override
	public void custom(String msg) {
		switch (msg) {
			case "hotSwap":
				ClassHotSwap.hotSwap(Paths.get(System.getProperty("hotSwap.dir")));
				break;
		}
	}
}
