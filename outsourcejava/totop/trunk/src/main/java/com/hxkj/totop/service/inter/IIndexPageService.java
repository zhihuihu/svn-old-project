package com.hxkj.totop.service.inter;

import com.hxkj.totop.entity.IndexPage;
import com.hxkj.totop.service.IBaseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/25.
 */
public interface IIndexPageService extends IBaseService<IndexPage> {

    /**
     * 主页的四张主图的新增或者维护
     * @param request
     * @param indexPage
     * @return
     * @throws Exception
     */
    public Map<String,Object> doInsertOrUpdateMainPic(HttpServletRequest request, IndexPage indexPage) throws Exception;

    /**
     *主页公司介绍的更改或更新
     * @param indexPage
     * @return
     * @throws Exception
     */
    public Map<String,Object> doInsertOrUpdateCompanyIntro(IndexPage indexPage) throws Exception;

    /**
     * 更新公司简介右边的图片
     * @param request
     * @param indexPage
     * @return
     * @throws Exception
     */
    public Map<String,Object> doInsertOrUpdateCompanyImages(HttpServletRequest request,IndexPage indexPage) throws Exception;

    /**
     * 主页最下面三张图片的增加修改
     * @param request
     * @param indexPage
     * @return
     * @throws Exception
     */
    public Map<String,Object> doInsertOrUpdateBottomImages(HttpServletRequest request,IndexPage indexPage) throws Exception;

    public List<Map<String,Object>> selectechcaheList() throws Exception;
}
