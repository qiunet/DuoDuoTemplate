package com.game.template.basic.commondata.setting;

import com.game.template.basic.commondata.enums._CDataType;

/***
 *
 *
 * @author qiunet
 * 2020-05-15 18:57
 ***/
public final class IntCommonDataSetting extends CommonDataSetting<IntCommonDataSetting> {

	 IntCommonDataSetting() {
		super(_CDataType.INT, ()->"0");
	}
}
