# protobuf文件

	改为新项目后, 可以自行移到其它目录. 放到该出仅仅是方便git作为一个项目管理.
	
	proto生成的java文件需要输出到Basic模块下.


##### 转换命令:
> protoc --java_out=<项目路径>/DuoDuoTemplate/Basic/src/main/java ./*.proto
