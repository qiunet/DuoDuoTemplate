package com.game.server.basic.common.cfg.resource;

import com.game.server.basic.common.data.ConditionData;
import com.game.server.basic.common.enums.ResourceType;
import org.qiunet.cfg.annotation.Cfg;
import org.qiunet.cfg.base.ISimpleMapCfg;

/***
 *
 * @author qiunet
 * 2020-04-25 20:46
 **/
@Cfg("config/resource/resource_item.xd")
public class ResourceItemCfg implements ISimpleMapCfg<Integer> , IResourceCfg{
	private int id;
	private String name;
	private int type;
	private ConditionData recycle;

	public ConditionData getRecycle() {
		return recycle;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public ResourceType type() {
		return ResourceType.ITEM;
	}
}
