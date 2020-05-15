package com.game.template.basic.commondata.setting;

import com.game.template.basic.commondata.enums._CDataType;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:57
 ***/
public final class LongCommonDataSettingBuilder extends BaseCommonDataSettingBuilder<LongCommonDataSettingBuilder> {

	 LongCommonDataSettingBuilder() {
		super(_CDataType.LONG, ()->"0");
	}

	@Override
	protected void build0(CommonDataSetting setting) {

	}
}
