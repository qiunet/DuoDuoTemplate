package com.game.template.server;

import com.game.template.server.common.context.StartupContext;
import com.game.template.server.common.hook.ServerHook;
import org.qiunet.flash.handler.netty.server.BootstrapServer;
import org.qiunet.flash.handler.netty.server.param.HttpBootstrapParams;
import org.qiunet.utils.args.ArgsMapping;
import org.qiunet.utils.classScanner.ClassScanner;

/***
 *
 * @author qiunet
 * 2020-04-25 13:19
 **/
public class GameBootstrap {

	public static void main(String[] args) throws Exception {
		ArgsMapping argsMapping  = new ArgsMapping(args);

		ServerHook hook = new ServerHook(argsMapping);

		String cmd = "start";
		if (args.length >= 1) cmd = args[args.length - 1];

		switch (cmd) {
			case "start":
				BootstrapServer server = BootstrapServer.createBootstrap(hook);
				ClassScanner.getInstance().scanner("com.game.template");
				server.httpListener(HttpBootstrapParams.custom()
					.setPort(argsMapping.getInt("port", 8888))
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
