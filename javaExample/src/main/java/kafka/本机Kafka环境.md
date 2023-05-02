### kafka
占用端口：9092， 9093， 9094
#### bin目录
/Users/qin/software/kafka_2.11-1.1.1/bin

#### conf目录
/Users/qin/conf/kafka

#### data目录
/Users/qin/data/kafka/kafka1
/Users/qin/data/kafka/kafka2
/Users/qin/data/kafka/kafka3
#### log目录
/Users/qin/logs/kafka

#### 启动 
集群启动，分别启动三个kafka进程：
kafka-server-start.sh -daemon /Users/qin/conf/kafka/server1.properties

kafka-server-start.sh -daemon /Users/qin/conf/kafka/server2.properties

kafka-server-start.sh -daemon /Users/qin/conf/kafka/server3.properties



#### 验证kafka集群
shell中执行如下命令从创建topic
```shell
kafka-topics.sh --create --zookeeper localhost:2181,localhost:2182,localhost:2183 --replication-factor 3 --partitions 3 --topic testTopic
```
如下命令查看topic有没有创建成功
```shell
kafka-topics.sh --zookeeper localhost:2181,localhost:2182,localhost:2183 --describe --topic  testTopic
```
如下命令生产消息：
```shell
kafka-console-producer.sh --broker-list localhost:9092,localhost:9093,localhost:9094   --topic testTopic
```
如下命令消费消息：
```shell
kafka-console-consumer.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094  --topic testTopic
```


### 安装过程
#### 下载并解压
下载到/Users/qin/software目录
下载页面：https://kafka.apache.org/downloads.html
tar -zxvf kafka_2.11-1.1.1.tgz


#### 修改server.properties
修改对应配置文件， 启动即可