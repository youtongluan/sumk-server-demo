## 工程介绍

本资源库包含rpc-server和web-server两个工程。rpc-server演示微服务的搭建。web-server演示web服务、数据库访问、数据库变更监听、微服务调用等。

## 如何运行演示程序

1. 启动mysql数据库，创建一个test数据库，然后执行web-server根目录下的db.sql文件

2. 启动redis和zookeeper，它们都使用默认端口

3. 分别运行web-server和rpc-server的org.test.Bootstrap类

## 如何查看演示结果

如果只是想看演示，可以通过这个地址进行查看： [http://120.55.49.121:9090/](http://120.55.49.121:9090/)

使用下列url就可以访问rest接口

- http://localhost:8081/rest/insertStudent?data={"name":"游夏","age":20}

- http://localhost:8081/rest/echoFromRpc?data={"name":"游夏"}

- http://localhost:8081/rest/echo/by/intf

- http://localhost:8081/rest/incrInRedis?data={"name":"test"}

- http://localhost:8081/rest/info?data={"name":"张三","age":23}

- 用户登录：http://localhost:8081/login?username=admin&password=123456&code=9999

- 查看登录用户的信息：http://localhost:8081/rest/userInfo

### 监控及文档

例子中只有web-server工程有提供web服务，所以这里看的也是web-server工程的监控信息及文档信息  

#### 监控信息

http://localhost:8081/_sumk_monitor?sign=helloworld&server=1&statis=1&system=1&jvm=1&threadpool=1&&localSessions=1&db.cache=1&datasource=sumk&rpcData=1

如果不想看哪个监控信息，只要将值设为0即可

#### web接口信息

http://localhost:8081/_sumk_acts?sign=helloworld&mode=http&pretty=1

支持模糊搜索，比如在参数里增加_name=app表示搜索接口名包含app的rest接口

### bean信息

http://localhost:8081/_sumk_acts?sign=helloworld&mode=beans.full

## sumk文档集合

[sumk总体介绍](https://p2nwdvhb36.feishu.cn/docx/AEIhdF4M5oDXouxdfNLc0ya2nZb)

[sumk的功能特性](https://p2nwdvhb36.feishu.cn/docx/LQxXdjwbdoWDrFxcyUTcNWTUnSh)

[sumk框架入门](https://p2nwdvhb36.feishu.cn/docx/AOl0dhDqJoymnSxuWUhcTQ1SnMf)

[注解及接口及工具类](https://p2nwdvhb36.feishu.cn/docx/UuIPduSDuo6kSlxSOEDcGzdPnSh)

[sumk常用配置](https://p2nwdvhb36.feishu.cn/docx/RUBidOGQboZTkaxGJ8uc1Z93n8c)

[sumk-db使用介绍](https://p2nwdvhb36.feishu.cn/docx/TQnUdmM1YomahpxVIKMcxPdYnFc)

[接口文档及状态信息查看](https://p2nwdvhb36.feishu.cn/docx/ZvV3dCbLuog5wfxoSAgcV6frnvc)

- 源码地址：(https://github.com/youtongluan/sumk) 或 https://gitee.com/mirrors/sumk
