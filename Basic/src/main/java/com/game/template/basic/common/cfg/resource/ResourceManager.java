package com.game.template.basic.common.cfg.resource;


import com.game.template.basic.common.enums.ResourceType;

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

	public <T extends IResourceCfg> T getResourceCfg(int resourceId) {
		return (T) ResourceType.parseByResourceId(resourceId).getResourceCfg(resourceId);
	}
}
