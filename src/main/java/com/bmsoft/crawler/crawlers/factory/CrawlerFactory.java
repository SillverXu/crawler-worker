package com.bmsoft.crawler.crawlers.factory;

import com.bmsoft.crawler.crawlers.AQSC;
import com.bmsoft.crawler.crawlers.CommonCrawler;
import org.apache.log4j.Logger;

public class CrawlerFactory {
    private static Logger logger = Logger.getLogger(CrawlerFactory.class);

    public CommonCrawler getCrwaler(String website) {
        if(website ==null){
            return null;
        }
        switch (website){
            case "安全生产网>政策法规":
                return new AQSC();
            case "安全生产网>事故通报":
                return new AQSC();
            default:
                logger.info("Do not find matched crawler.");
        }
        return null;
    }
}
