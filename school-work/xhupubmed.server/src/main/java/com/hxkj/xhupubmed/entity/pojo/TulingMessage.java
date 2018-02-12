package com.hxkj.xhupubmed.entity.pojo;

import java.util.List;

/**
 * 
* @ClassName: TulingMessage 
* @Description: TODO 图灵机器人返回结果bean
* @author huzhihui_c@qq.com
* @date 2016年4月14日 下午2:55:43 
*
 */
public class TulingMessage {

	/**
	 * 标识码
	 */
	private String code;
	
	/**
	 * 返回文字
	 */
	private String text;
	
	/**
	 * 连接地址
	 */
	private String url;
	
	/**
	 * 信息列表
	 */
	private List<NewList> list;
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<NewList> getList() {
		return list;
	}


	public void setList(List<NewList> list) {
		this.list = list;
	}


	public class NewList{
		/**
		 * 新闻标题
		 */
		private String article;
		/**
		 * 数据来源
		 */
		private String source;
		/**
		 * 数据图片
		 */
		private String icon;
		/**
		 * 连接详情
		 */
		private String detailurl;
		
		/**
		 * 菜名
		 */
		private String name;
		
		/**
		 * 菜谱信息
		 */
		private String info;
		public String getArticle() {
			return article;
		}
		public void setArticle(String article) {
			this.article = article;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getDetailurl() {
			return detailurl;
		}
		public void setDetailurl(String detailurl) {
			this.detailurl = detailurl;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		
		
	}
	
}
