package com.hxkj.xhupubmed.service.inter;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:IPostService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午9:47:54 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IPostService extends IBaseService<Post> {
	
	/**
	 * 
	* @Function: 增加帖子图片
	* @Title: doInsertImages  
	* @param request
	* @param postCuid
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月7日 下午3:40:58
	* @Since JDK 1.8
	 */
	public Object doInsertImages(HttpServletRequest request,String postCuid) throws Exception;

}
