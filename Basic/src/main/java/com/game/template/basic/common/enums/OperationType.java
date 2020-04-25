package com.game.template.basic.common.enums;

/***
 * 资源操作变动类型
 * 一个模块使用的范围为 模块id * 100
 * @author qiunet
 * 2020-04-17 07:36
 **/
public enum OperationType {
	SHOP_BUY(100, "商城购买", 10),
	;
	private int type;

	private String desc;
	/**1分钟触发多少次, 会触发监控 像商城等. 需要减少
	 * 少.**/
	private int checkCount = 60;

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
}
