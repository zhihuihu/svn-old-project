/*package com.hxkj.xhupubmed.core.utils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

*//** 
 * ClassName:GithubRepoPageProcessor
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午11:21:26 
 * @version  1.0 
 * @since    JDK 1.8      
 *//*
public class GithubRepoPageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
    	Spider.create(new GithubRepoPageProcessor())
        //从"https://github.com/code4craft"开始抓
        .addUrl("https://github.com/code4craft")
        .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
        //开启5个线程抓取
        .thread(5)
        //启动爬虫
        .run();
    }

}
*/