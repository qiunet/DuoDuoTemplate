package com.game.server.common.server;

import org.qiunet.utils.properties.anno.DProperties;
import org.qiunet.utils.properties.anno.DPropertiesValue;

/***
 *
 *
 * @author qiunet
 * 2020-08-04 10:50
 ***/
@DProperties("server.properties")
public class ServerConfig {
	@DPropertiesValue("hook.port")
	private static int hookPort;

	@DPropertiesValue("server.port")
	private static int serverPort;

	@DPropertiesValue("communication.port")
	private static int commnicationPort;

	public static int getHookPort() {
		return hookPort;
	}

	public static int getServerPort() {
		return serverPort;
	}

	public static int getCommnicationPort() {
		return commnicationPort;
	}
}
