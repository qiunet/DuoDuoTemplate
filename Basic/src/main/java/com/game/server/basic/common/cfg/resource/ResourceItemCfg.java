package com.game.server.basic.common.cfg.resource;

import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.enums.ResourceSubType;
import com.game.server.basic.common.enums.ResourceType;
import org.qiunet.cfg.annotation.Cfg;
import org.qiunet.cfg.base.IAfterLoad;
import org.qiunet.cfg.base.ISimpleMapCfg;
import org.qiunet.function.reward.Rewards;

/***
 *
 * @author qiunet
 * 2020-04-25 20:46
 **/
@Cfg("config/resource/resource_item.xd")
public class ResourceItemCfg implements ISimpleMapCfg<Integer> , IResourceCfg, IAfterLoad {
	private int id;
	private String name;
	private int type;
	private ResourceSubType subType;
	private Rewards<PlayerActor> recycle;

	public Rewards<PlayerActor> getRecycle() {
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

	@Override
	public void afterLoad() {

	}
}
