package com.bmsoft.crawler.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;


public class UrlConsumer implements Runnable {
    private String queuename;
    private Connection connection;
    public UrlConsumer(Connection connection, String queuename){
        this.queuename = queuename;
        this.connection = connection;
    }
    public void run() {
        try {
            final Channel channel = connection.createChannel();
            channel.queueDeclare(queuename, true, false, false, null);
            channel.basicQos(1);
            channel.basicConsume(queuename, false, new CrawlerWorker(channel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
