package com.game.server.basic.common.cfg.resource;


import com.game.server.basic.common.enums.ResourceType;
import org.qiunet.function.base.IResourceCfg;

/***
 *
 * @author qiunet
 * 2020-04-25 20:54
 **/
public class ResourceManager {
	private volatile static ResourceManager instance;

	private ResourceManager() {
		if (instance != null) throw new RuntimeException("Instance Duplication!");
		instance = this;
	}

	public static ResourceManager getInstance() {
		if (instance == null) {
			synchronized (ResourceManager.class) {
				if (instance == null)
				{
					new ResourceManager();
				}
			}
		}
		return instance;
	}

	/**
	 * 获得cfgId对应的cfg
	 * @param resourceId
	 * @param <T>
	 * @return
	 */
	public <T extends IResourceCfg> T getResourceCfg(int resourceId) {
		return (T) ResourceType.getCfgById(resourceId);
	}
}
