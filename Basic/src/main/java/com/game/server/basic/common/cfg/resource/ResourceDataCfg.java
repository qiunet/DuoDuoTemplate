package com.game.server.basic.common.cfg.resource;

import com.game.server.basic.common.enums.ResourceSubType;
import com.game.server.basic.common.enums.ResourceType;
import org.qiunet.cfg.annotation.Cfg;
import org.qiunet.cfg.base.ISimpleMapCfg;
import org.qiunet.function.base.IResourceCfg;

/***
 *
 * @author qiunet
 * 2020-04-25 20:46
 **/
@Cfg("config/resource_data.xd")
public class ResourceDataCfg implements ISimpleMapCfg<Integer>, IResourceCfg {
	private int id;
	private String name;
	private ResourceSubType subType;


	@Override
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public ResourceSubType subType() {
		return subType;
	}

	@Override
	public ResourceType type() {
		return ResourceType.DATA;
	}
}
