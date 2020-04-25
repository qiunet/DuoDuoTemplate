package com.game.template.basic.common.data;

/***
 *
 * @author qiunet
 * 2020-04-15 21:16
 **/
public class RewardData extends ResourceData<RewardData> {

	public RewardData(){}

	public RewardData(RewardData rewardData) {
		this.merge(rewardData);
	}

	/**
	 * 解析奖励字符串
	 * 格式: resourceIdx数量;...
	 *
	 * @param string
	 * @return
	 */
	public static RewardData parse(String string) {
		RewardData rewardData = new RewardData();
		rewardData.parse0(string);
		return rewardData;
	}
}
