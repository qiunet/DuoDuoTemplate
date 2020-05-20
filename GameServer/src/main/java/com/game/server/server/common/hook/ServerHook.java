package com.game.server.server.common.hook;

import com.game.server.basic.common.logger.GameLogger;
import org.qiunet.cfg.manager.CfgManagers;
import org.qiunet.flash.handler.netty.server.hook.Hook;
import org.qiunet.utils.args.ArgsMapping;
import org.qiunet.utils.listener.data.ServerShutdownEventData;

/***
 *
 * @author qiunet
 * 2020-04-25 15:43
 **/
public class ServerHook implements Hook {
	private ArgsMapping mapping;
	public ServerHook(ArgsMapping mapping) {
		this.mapping = mapping;
	}


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
		return mapping.getInt("hookPort", 1314);
	}

	@Override
	public String getShutdownMsg() {
		return "SHUTDOWN0";
	}

	@Override
	public void shutdown() {

	}

	@Override
	public void custom(String msg) {
		// 触发停服监听
		ServerShutdownEventData.fireShutdownEventHandler();
	}
}
