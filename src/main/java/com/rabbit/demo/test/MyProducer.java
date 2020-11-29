package com.rabbit.demo.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MyProducer {
    private final static String QUEUE_NAME = "lispylon";

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        Channel channel = null;
        ConnectionFactory factory = new ConnectionFactory();
        // 连接IP
        factory.setHost("80.102.0.14");

        //factory.setHost("127.0.0.1");
        // 连接端口
        factory.setPort(5672);
        // 虚拟机
        factory.setVirtualHost("/");
        // 用户
        factory.setUsername("admin");
        factory.setPassword("Wonders@1");
        /* 创建连接 */
        connection = factory.newConnection();
        /* 创建信道 */
        channel = connection.createChannel();

        // 声明一个队列：名称、持久性的（重启仍存在此队列）、非私有的、非自动删除的
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //String message = "{\"code\":1,\"msg\":\"获取信息成功\",\"data\":{\"barcode\":\"123\",\"patientAge\":16,\"patientCode\":\"12231114\",\"patientName\":\"张三\",\"patientSex\":\"男\",\"sex\":\"1\",\"sampleno\":\"1\",\"patType\":\"急诊\",\"channel\":\"[\\\"ALP\\\",\\\"PCT\\\"]\"}}";
        String message="{\"barcode\":\"1202011070082\",\"channel\":\"[\\\"D-Dimer\\\"]\",\"instrNo\":\"PYLON\",\"patType\":\"门诊\",\"patientAge\":30,\"patientBirthday\":\"1990-09-25\",\"patientCode\":\"a73b07d4-1190-4886-b917-7466cb26b612\",\"patientName\":\"测试123\",\"patientSex\":\"女\",\"sampleno\":\"1\",\"sex\":\"2\"}";
        /* 发送消息，使用默认的direct交换器 */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("Send message -> " + message);
    }
}
