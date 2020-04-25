package com.game.template.basic.common.cfg.resource;

import com.game.template.basic.common.enums.ResourceType;
import org.qiunet.cfg.annotation.Cfg;
import org.qiunet.cfg.base.ISimpleMapCfg;

/***
 *
 * @author qiunet
 * 2020-04-25 20:46
 **/
@Cfg("config/resource/resource_data.xd")
public class ResourceDataCfg implements ISimpleMapCfg<Integer>, IResourceCfg {
	private int id;
	private String name;
	@Override
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public ResourceType type() {
		return ResourceType.DATA;
	}
}
