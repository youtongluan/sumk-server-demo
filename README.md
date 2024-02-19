## 工程介绍

本资源库包含rpc-server和web-server两个工程。rpc-server演示微服务的搭建。web-server演示web服务、数据库访问、数据库变更监听、微服务调用等。



## 如何运行演示程序

1. 启动mysql数据库，创建一个test数据库，然后执行web-server根目录下的db.sql文件

2. 启动redis和zookeeper，它们都使用默认端口

3. 分别运行web-server和rpc-server的org.test.Bootstrap类
   
   

## 如何查看演示结果

使用下列url就可以访问rest接口

- http://localhost:8081/rest/insertStudent?data={"name":"游夏","age":20}

- http://localhost:8081/rest/echoFromRpc?data={"name":"游夏"}

- http://localhost:8081/rest/echo/by/intf

- http://localhost:8081/rest/incrInRedis?data={"name":"test"}

- http://localhost:8081/rest/info?data={"name":"张三","age":23}

- 用户登录：http://localhost:8081/login?username=admin&password=123456&code=9999

- 查看登录用户的信息：http://localhost:8081/rest/userInfo



## sumk介绍

* [sumk介绍](https://www.oschina.net/p/sumk)
