package com.bmsoft.crawler.crawlers;


import org.apache.log4j.Logger;

public class AQSC extends CommonCrawler implements Runnable {
    private static Logger logger = Logger.getLogger(AQSC.class);
    private String url;
    private String website;
    public AQSC(){

    }
    @Override
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public void setWebsite(String website) {
        this.website = website;
    }
    /**
     * for test use
     * */
    public AQSC(String url, String website) {
        this.url = url;
        this.website = website;

    }

    public void run() {
        try {
            Thread.sleep(10000);
            System.out.println("Work done"+Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInfo() {
        System.out.println(url);
        System.out.println(website);
        try {
            Thread.sleep(10000);
            System.out.println("Work done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
