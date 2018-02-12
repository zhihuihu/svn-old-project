package com.hxkj.totop.service.inter;

import com.hxkj.totop.entity.Mingpinhui;
import com.hxkj.totop.service.IBaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huzhihui on 2016/4/25.
 */
public interface IMingpinhuiService extends IBaseService<Mingpinhui> {

    /**
     * 增加一个名品汇的图片显示
     * @param request
     * @return
     * @throws Exception
     */
    public Object doInsertOrUpdateMingpinhui(HttpServletRequest request,Mingpinhui mingpinhui) throws Exception;
}
