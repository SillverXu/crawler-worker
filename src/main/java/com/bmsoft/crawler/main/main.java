package com.bmsoft.crawler.main;

import com.bmsoft.crawler.consumer.UrlConsumer;
import com.bmsoft.crawler.utils.RabbitMQUtil;
import com.rabbitmq.client.Connection;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    private static Logger logger = Logger.getLogger(main.class);
    private static final String QUEUE_NAME="fengkan";

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        Connection connection = RabbitMQUtil.getConnection();
        for (int i = 0; i <3 ; i++) {
            exec.execute(new UrlConsumer(connection,QUEUE_NAME));
        }
    }
}
