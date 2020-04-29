package com.game.template.basic.common.deduct;

import com.game.template.basic.common.actor.PlayerActor;
import com.game.template.basic.common.data.RewardData;

import java.util.List;

/***
 *
 * @author qiunet
 * 2020-04-28 07:46
 **/
public interface IConditionDeduct<T extends IConditionDeduct> {
	/**
	 * 添加一个扣除代码.
	 * 请勿重复添加, 会多次扣除
	 * @param deduct
	 * @return
	 */
	T addDeduct(IDeduct deduct);

	/**
	 * 获得所有的扣除代码
	 * @return
	 */
	List<IDeduct> getAllDeduct();
	/**
	 * 是否已经扣除
	 * @return
	 */
	boolean isFinished();

	/**
	 * 执行扣除
	 */
	void executor(PlayerActor player) throws Exception;
	/**
	 * new 一个新的RewardData
	 * 所有业务都需要new 新的. 不能使用cfg里面的
	 * @return
	 */
	RewardData newRewardData();

	/**
	 * 使用另一个rewardData 创建一个新的RewardData
	 * @param data
	 * @return
	 */
	RewardData newRewardData(RewardData data);

	/**
	 * 合并另一个.
	 * 要求两个都没有finished
	 * @param conditionDeduct
	 */
	void mergeDeduct(T conditionDeduct);
}
