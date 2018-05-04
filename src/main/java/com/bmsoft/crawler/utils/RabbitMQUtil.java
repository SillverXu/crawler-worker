package com.bmsoft.crawler.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.bmsoft.crawler.conf.CrawlerKeys.RABBITMQ_ADDRESS_DEFAULT;
import static com.bmsoft.crawler.conf.CrawlerKeys.RABBITMQ_PASSWORD_DEFAULT;
import static com.bmsoft.crawler.conf.CrawlerKeys.RABBITMQ_USERNAME_DEFAULT;


/**
 * RabbitMQ util class
 * get connection
 */
public class RabbitMQUtil {
    private static Logger logger = Logger.getLogger(RabbitMQUtil.class);
    public static Connection getConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RABBITMQ_ADDRESS_DEFAULT);
        factory.setUsername(RABBITMQ_USERNAME_DEFAULT);
        factory.setPassword(RABBITMQ_PASSWORD_DEFAULT);
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            logger.info("Please check the username & password for connect to RabbitMQ.",e);
        } catch (TimeoutException e) {
            logger.info("Connect to RabbitMQ timemout.",e);
        }
        return connection;
    }
}
