package com.game.server;

import com.game.server.basic.common.redis.RedisDataUtil;
import com.game.server.common.context.StartupContext;
import com.game.server.common.hook.ServerHook;
import org.qiunet.cross.common.contants.ScannerParamKey;
import org.qiunet.data.util.ServerConfig;
import org.qiunet.flash.handler.netty.server.BootstrapServer;
import org.qiunet.flash.handler.netty.server.param.HttpBootstrapParams;
import org.qiunet.utils.scanner.ClassScanner;

/***
 *
 * @author qiunet
 * 2020-04-25 13:19
 **/
public class GameBootstrap {

	public static void main(String[] args) throws Exception {
		ServerHook hook = new ServerHook();

		String cmd = "start";
		if (args.length >= 1) cmd = args[args.length - 1];

		switch (cmd) {
			case "start":
				BootstrapServer server = BootstrapServer.createBootstrap(hook);
				ClassScanner.getInstance()
					.addParam(ScannerParamKey.SERVER_NODE_REDIS_INSTANCE, RedisDataUtil.getInstance())
					.scanner("com.game.server");
				server.httpListener(HttpBootstrapParams.custom()
					.setPort(ServerConfig.getServerPort())
					.setStartupContext(new StartupContext())
					.setWebsocketPath("/ws")
					.build())
					.await();
				break;
			case "stop":
				BootstrapServer.sendHookMsg(hook.getHookPort(), hook.getShutdownMsg());
				break;
			default:
				BootstrapServer.sendHookMsg(hook.getHookPort(), cmd);
		}
	}
}
