package com.game.server.basic.activity;

import com.game.server.basic.activity.entity.ActivityBo;
import com.game.server.basic.activity.entity.ActivityDo;
import org.qiunet.data.support.CacheDataSupport;

public enum ActivityService {
	instance;
	private CacheDataSupport<Integer, ActivityDo, ActivityBo> dataSupport = new CacheDataSupport<>(ActivityDo.class, ActivityBo::new);
	/***
	* 获得一个 ActivityBo 对象
	* @param activity_id 获取对象的主键
	* @return ActivityBo 对象
	*/
	public ActivityBo getActivityBo(Integer activity_id) {
		return dataSupport.getBo(activity_id);
	}
}
