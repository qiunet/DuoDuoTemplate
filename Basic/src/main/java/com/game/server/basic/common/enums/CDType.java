package com.game.server.basic.common.enums;


import org.qiunet.function.cd.ICdType;

import java.util.concurrent.TimeUnit;

/***
 *
 * 玩法中各种cd的类型集合
 *
 * @author qiunet
 * 2020-04-17 07:24
 **/
public enum  CDType implements ICdType {
	FIGHT(5000, "发起战斗间隔"),
	;

	private long period;
	private TimeUnit unit;
	private String desc;

	CDType(long period, String desc) {
		this(period, TimeUnit.MILLISECONDS, desc);
	}

	CDType(long period, TimeUnit unit, String desc) {
		this.period = period;
		this.unit = unit;
		this.desc = desc;
	}

	@Override
	public long period() {
		return period;
	}

	@Override
	public TimeUnit unit() {
		return unit;
	}

	@Override
	public String desc() {
		return desc;
	}
}
