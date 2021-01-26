package com.game.server.basic.activity.entity;

import com.game.server.basic.activity.enums.ActivityStatus;
import org.qiunet.data.support.IEntityBo;

public class ActivityBo implements IEntityBo<ActivityDo>{
	private ActivityDo aDo;

	public ActivityBo (ActivityDo aDo) {
		this.aDo = aDo;
		this.deserialize();
	}

	public ActivityDo getDo(){
		return aDo;
	}

	public ActivityStatus getStatus(){
		return ActivityStatus.parse(aDo.getStatus());
	}

	@Override
	public void serialize() {

	}

	@Override
	public void deserialize() {

	}
}
