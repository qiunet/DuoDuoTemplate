package com.game.server;

import com.game.server.common.context.StartupContext;
import com.game.server.common.hook.ServerHook;
import com.game.server.common.server.ServerConfig;
import org.qiunet.flash.handler.netty.server.BootstrapServer;
import org.qiunet.flash.handler.netty.server.param.HttpBootstrapParams;
import org.qiunet.utils.classLoader.ClassHotSwap;
import org.qiunet.utils.classScanner.ClassScanner;

import java.nio.file.Paths;

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
				ClassScanner.getInstance().scanner("com.game.server");
				server.httpListener(HttpBootstrapParams.custom()
					.setPort(ServerConfig.getInstance().getServerPort())
					.setStartupContext(new StartupContext())
					.setWebsocketPath("/ws")
					.build())
					.await();
				break;
			case "stop":
				BootstrapServer.sendHookMsg(hook.getHookPort(), hook.getShutdownMsg());
				break;
			case "hotSwap":
				ClassHotSwap.hotSwap(Paths.get(System.getProperty("hotSwap.dir")));
				break;
			default:
				BootstrapServer.sendHookMsg(hook.getHookPort(), cmd);
		}
	}
}
