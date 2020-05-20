package com.game.server.basic.commondata.setting;

import com.game.server.basic.commondata.enums._CDataType;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:57
 ***/
public final class IntCommonDataSettingBuilder extends BaseCommonDataSettingBuilder<IntCommonDataSettingBuilder> {

	 IntCommonDataSettingBuilder() {
		super(_CDataType.INT, p->"0");
	}

	@Override
	protected void build0(CommonDataSetting setting) {

	}
}
