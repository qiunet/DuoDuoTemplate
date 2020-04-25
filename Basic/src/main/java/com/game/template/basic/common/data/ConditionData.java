package com.game.template.basic.common.data;

/***
 *
 * @author qiunet
 * 2020-04-16 08:31
 **/
public class ConditionData extends ResourceData<ConditionData> {
	public ConditionData(){}

	public ConditionData(ConditionData conditionData) {
		this.merge(conditionData);
	}

	/**
	 * 解析
	 * 格式: resourceIdx数量;...
	 * @param string
	 * @return
	 */
	public static ConditionData parse(String string) {
		ConditionData conditionData = new ConditionData();
		conditionData.parse0(string);
		return conditionData;
	}
}
