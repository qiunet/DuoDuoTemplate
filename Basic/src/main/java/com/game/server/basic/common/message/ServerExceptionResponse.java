package com.game.server.basic.common.message;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.server.basic.common.contants.ProtocolId;
import org.qiunet.flash.handler.context.request.data.pb.IpbResponseData;
import org.qiunet.flash.handler.context.request.data.pb.PbResponse;

/***
 *
 *
 * @author qiunet
 * 2020-09-25 16:59
 */
@PbResponse(ProtocolId.System.SERVER_EXCEPTION)
@ProtobufClass(description = "服务器异常")
public class ServerExceptionResponse implements IpbResponseData {
}
