package com.bmsoft.crawler.consumer;

import com.bmsoft.crawler.crawlers.CommonCrawler;
import com.bmsoft.crawler.crawlers.factory.CrawlerFactory;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class CrawlerWorker extends DefaultConsumer {

    public CrawlerWorker(Channel channel) {
        super(channel);
    }
    @Override
    public void handleDelivery(String consumerTag, Envelope envelope,
                               AMQP.BasicProperties properties, byte[] body)
            throws IOException {
        String temp = new String(body, "utf-8");
        String[] task = temp.split("<");
        CrawlerFactory cf = new CrawlerFactory();
        CommonCrawler commonCrawler = cf.getCrwaler(task[1]);
        commonCrawler.setUrl(task[0]);
        commonCrawler.setWebsite(task[1]);
        commonCrawler.getInfo();
        super.getChannel().basicAck(envelope.getDeliveryTag(), false);
    }

}
