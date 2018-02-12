/*package com.hxkj.xhupubmed.core.utils;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

*//** 
 * ClassName:OschinaBlogPageProcesser
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午12:54:02 
 * @version  1.0 
 * @since    JDK 1.8      
 *//*
public class OschinaBlogPageProcesser implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	
	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		page.addTargetRequests(page.getHtml().links().regex("(http://www.xhu.edu.cn)").all());
        page.putField("author", page.getUrl().regex("http://www.xhu.edu.cn.*").toString());
        page.putField("name", page.getHtml().xpath("//a[@class='quick']text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
	}
	
	public static void main(String[] args) {
		Spider.create(new OschinaBlogPageProcesser()).addUrl("http://www.xhu.edu.cn").thread(5).run();
    }

}
*/