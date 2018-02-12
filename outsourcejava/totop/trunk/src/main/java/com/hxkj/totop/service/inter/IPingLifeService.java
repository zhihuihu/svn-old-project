package com.hxkj.totop.service.inter;

import com.hxkj.totop.entity.PingLife;
import com.hxkj.totop.service.IBaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huzhihui on 2016/4/25.
 */
public interface IPingLifeService extends IBaseService<PingLife> {
    /**
     * type为1的主页的两张图片显示
     * @param request
     * @param pingLife
     * @return
     * @throws Exception
     */
    public Object doInsertOrUpdateMainImage(HttpServletRequest request,PingLife pingLife) throws Exception;
}
