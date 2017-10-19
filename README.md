# 简介
本项目为基于 Java Spring Boot 开发，负责 权限管理功能。

# 本地运行
可通过设置环境变量的方式调整所连接的数据源信息，可设置的环境变量请参考 `application.yml` 文件。
```bash
mvn spring-boot:run -Ddb.host=localhost -Ddb.password=bar
```
# 针对于多环境 运行,打包 执行maven命令添加参数 -P dev|test|pro
```bash
mvn spring-boot:run -Ddb.host=localhost -Ddb.password=bar -P dev
mvn clean package -P dev
```
# IDEA 设置
Run -> Edit Configurations -> 选择当前项目的配置，Environment variables 中添加以下内容
```bash
db.host=localhost
db.name=test
db.username=foo
db.password=bar
```
