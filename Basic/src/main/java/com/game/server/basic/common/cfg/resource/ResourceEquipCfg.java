package com.game.server.basic.common.cfg.resource;

import com.game.server.basic.common.enums.ResourceType;
import org.qiunet.cfg.annotation.Cfg;
import org.qiunet.cfg.base.ISimpleMapCfg;

/***
 *
 * @author qiunet
 * 2020-04-25 20:46
 **/
@Cfg("config/resource/resource_equip.xd")
public class ResourceEquipCfg implements ISimpleMapCfg<Integer>, IResourceCfg {
	private int id;
	private String name;
	private String attrs;
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
