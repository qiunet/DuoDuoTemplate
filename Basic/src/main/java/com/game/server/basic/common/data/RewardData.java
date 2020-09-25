package com.game.server.basic.common.data;

import com.game.server.basic.bag.listener.GainRewardEventData;
import com.game.server.basic.common.actor.PlayerActor;
import com.game.server.basic.common.cfg.resource.IResourceCfg;
import com.game.server.basic.common.cfg.resource.ResourceManager;
import com.game.server.basic.common.data.result.CheckPackResult;
import com.game.server.basic.common.data.result.IRewardResult;
import com.game.server.basic.common.deduct.IConditionDeduct;
import com.game.server.basic.common.deduct.IDeduct;
import com.game.server.basic.common.enums.OperationType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/***
 *
 * @author qiunet
 * 2020-04-15 21:16
 **/
public class RewardData extends ResourceData<RewardData> {

	private IConditionDeduct conditionDeduct;
	private RewardData(){}

	RewardData(IConditionDeduct conditionDeduct) {
		this.conditionDeduct = conditionDeduct;
	}

	RewardData(IConditionDeduct conditionDeduct, RewardData rewardData) {
		Preconditions.checkState(! rewardData.conditionDeduct.isFinished(), "Can not add a finished deduct!");
		List<IDeduct> allDeduct = rewardData.conditionDeduct.getAllDeduct();
		for (IDeduct deduct : allDeduct) {
			conditionDeduct.addDeduct(deduct);
		}
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

	/**
	 * 添加到背包
	 * @return
	 */
	public List<IRewardResult> addToPack() throws Exception {
		// RewardData 会执行扣除
		Preconditions.checkState(! this.conditionDeduct.isFinished());
		Preconditions.checkState(operationType != null);
		Preconditions.checkState(player != null);

		this.conditionDeduct.executor(player);

		List<IRewardResult> results = Lists.newArrayList();
		for (Map.Entry<Integer, Integer> entry : getResources().entrySet()) {
			IResourceCfg resourceCfg = ResourceManager.getInstance().getResourceCfg(entry.getKey());

			List<IRewardResult> resultList = resourceCfg.type().addToPack(player, entry.getKey(), entry.getValue(), operationType);
			if (resultList != null) {
				results.addAll(resultList);
			}
		}

		// 触发监听
		player.submitEvent(GainRewardEventData.valueOf(results, this, operationType));
		return results;
	}
	/**
	 * 是否能插入
	 * @param player
	 * @return
	 */
	public CheckPackResult haveEnoughSpace(PlayerActor player, OperationType type){
		Preconditions.checkState(operationType == null);
		//TODO 业务自己判断

		super.operationType = type;
		super.player = player;
		return CheckPackResult.SUCCESS;
	}
}
