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
@Cfg("config/resource/resource_equip.xd")
public class ResourceEquipCfg implements ISimpleMapCfg<Integer>, IResourceCfg {
	private int id;
	private ResourceSubType subType;
	private String name;
	private String attrs;

	@Override
	public ResourceSubType subType() {
		return subType;
	}

	public String getName() {
		return name;
	}

	public String getAttrs() {
		return attrs;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public ResourceType type() {
		return ResourceType.EQUIP;
	}
}
