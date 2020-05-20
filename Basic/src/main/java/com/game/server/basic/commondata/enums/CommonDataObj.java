package com.game.server.basic.commondata.enums;

import com.game.server.basic.commondata.entity.CommonDataBo;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 15:12
 ***/
public abstract class CommonDataObj {

	private CommonDataBo commonDataBo;

	void setCommonDataBo(CommonDataBo commonDataBo) {
		this.commonDataBo = commonDataBo;
	}

	public synchronized void update() {
		commonDataBo.update();
	}
}
