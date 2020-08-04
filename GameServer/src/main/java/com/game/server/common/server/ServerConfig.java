package com.game.server.common.server;

import org.qiunet.utils.properties.LoaderProperties;

/***
 *
 *
 * @author qiunet
 * 2020-08-04 10:50
 ***/
public class ServerConfig extends LoaderProperties {
	private volatile static ServerConfig instance = new ServerConfig();
	public static ServerConfig getInstance() {
		return instance;
	}
	/***
	 * 要求相对 classpath的地址
	 */
	public ServerConfig() {
		super("server.properties");
	}

	public int getHookPort(){
		return getInt("hook.port");
	}

	public int getServerPort(){
		return getInt("server.port");
	}

	public int getCommunicationPort() {
		return getInt("communication.port");
	}
}
