package com.game.server;

import com.game.server.basic.common.redis.RedisDataUtil;
import com.game.server.common.context.StartupContext;
import com.game.server.common.hook.ServerHook;
import org.qiunet.cross.common.contants.ScannerParamKey;
import org.qiunet.data.util.ServerConfig;
import org.qiunet.flash.handler.netty.server.BootstrapServer;
import org.qiunet.flash.handler.netty.server.param.HttpBootstrapParams;
import org.qiunet.utils.config.properties.PropertiesUtil;
import org.qiunet.utils.data.IKeyValueData;
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
					.addParam(ScannerParamKey.SERVER_NODE_REDIS_INSTANCE_SUPPLIER, RedisDataUtil::getInstance)
					.scanner("com.game.server");
				server.httpListener(HttpBootstrapParams.custom()
					.setPort(ServerConfig.getServerPort())
					.setStartupContext(new StartupContext())
					.setWebsocketPath("/ws")
					.build())
					.await();
				break;
			default:
				IKeyValueData<Object, Object> keyValueData = PropertiesUtil.loadProperties(ServerConfig.CONFIG_FILE_NAME);
				BootstrapServer.sendHookMsg(keyValueData.getInt(ServerConfig.HORT_PORT), hook.getShutdownMsg());
				BootstrapServer.sendHookMsg(keyValueData.getInt(ServerConfig.HORT_PORT), cmd);
		}
	}
}
