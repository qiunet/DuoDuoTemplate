package com.game.server.test.response.base;

import com.game.server.test.robot.Robot;
import org.qiunet.flash.handler.context.request.data.pb.IpbResponseData;
import org.qiunet.test.response.ProtobufResponse;

/***
 *
 * @author qiunet
 * 2020-04-25 18:48
 **/
public abstract class BaseResponse<Resp extends IpbResponseData> extends ProtobufResponse<Resp, Robot> {

}
