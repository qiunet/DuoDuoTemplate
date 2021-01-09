package com.game.server.basic.common.enums;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import org.qiunet.function.base.IOperationType;

import java.util.concurrent.TimeUnit;

/***
 * 资源操作变动类型
 * 一个模块使用的范围为 模块id * 100
 * @author qiunet
 * 2020-04-17 07:36
 **/
public enum OperationType implements EnumReadable, IOperationType {
	@Protobuf(description = "商城购买")
	SHOP_BUY(100, "商城购买", 10),
	;
	private final int type;

	private final String desc;
	/**1分钟触发多少次, 会触发监控 像商城等. 需要减少
	 * 少.**/
	private int checkCount = 60;
	/**
	 * 检测时间的间隔.
	 * 默认一分钟
	 */
	private long checkTimeMillis = TimeUnit.SECONDS.toMillis(60);

	OperationType(int type, String desc, int checkCount, long checkTimeMillis) {
		this.checkTimeMillis = checkTimeMillis;
		this.checkCount = checkCount;
		this.type = type;
		this.desc = desc;
	}

	OperationType(int type, String desc, int checkCount) {
		this.checkCount = checkCount;
		this.type = type;
		this.desc = desc;
	}

	OperationType(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

	public int getCheckCount() {
		return checkCount;
	}

	public long getCheckTimeMillis() {
		return checkTimeMillis;
	}

	@Override
	public int value() {
		return type;
	}
}
