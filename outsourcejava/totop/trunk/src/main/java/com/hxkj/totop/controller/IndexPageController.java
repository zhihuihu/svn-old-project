package com.hxkj.totop.controller;

import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.entity.IndexPage;
import com.hxkj.totop.entity.pojo.DataInBean;
import com.hxkj.totop.service.inter.IIndexPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/25.
 */
@Controller
@RequestMapping(value = "indexPage")
public class IndexPageController {

    @Resource
    private IIndexPageService iIndexPageService;

    /**
     * 主页的四张主图的新增或者维护
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="doInsertOrUpdateMainPic")
    @ResponseBody
    public Object doInsertOrUpdateMainPic(HttpServletRequest request) throws Exception{
        IndexPage indexPage = new IndexPage();
        indexPage.setIndexPageCuid(request.getParameter("indexPageCuid"));
        return iIndexPageService.doInsertOrUpdateMainPic(request,indexPage);
    }


    /**
     * 主页公司介绍的新增或更新
     * @param request
     * @param dataInBean
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doInsertOrUpdateCompanyIntro")
    @ResponseBody
    public Object doInsertOrUpdateCompanyIntro(HttpServletRequest request,@RequestBody DataInBean dataInBean) throws Exception{
        IndexPage indexPage = dataInBean.getIndexPage();
        return iIndexPageService.doInsertOrUpdateCompanyIntro(indexPage);
    }

    /**
     * 更新公司简介右边的图片
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doInsertOrUpdateCompanyImages")
    @ResponseBody
    public Object doInsertOrUpdateCompanyImages(HttpServletRequest request) throws Exception{
        IndexPage indexPage = new IndexPage();
        indexPage.setIndexPageCuid(request.getParameter("indexPageCuid"));
        return iIndexPageService.doInsertOrUpdateCompanyImages(request,indexPage);
    }

    /**
     * 主页最下面三张图片的增加修改
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doInsertOrUpdateBottomImages")
    @ResponseBody
    public Object doInsertOrUpdateBottomImages(HttpServletRequest request) throws Exception{
        IndexPage indexPage = new IndexPage();
        indexPage.setIndexPageCuid(request.getParameter("indexPageCuid"));
        return iIndexPageService.doInsertOrUpdateBottomImages(request,indexPage);
    }

    /**
     * 获得主页的所有数据
     * @return
     * @throws Exception
     */
    @RequestMapping(value="selectAllIndexData")
    @ResponseBody
    public Object selectAllIndexData() throws Exception{
        IndexPage indexPage = new IndexPage();
        return PageBeanUtils.formatForNormalTrue("",iIndexPageService.selectByAttribute(indexPage));
    }

    @RequestMapping(value="selectechcaheList")
    @ResponseBody
    public List<Map<String, Object>> selectechcaheList() throws Exception {
        return iIndexPageService.selectechcaheList();
    }

    @RequestMapping(value = "doDeleteByPrimaryKey")
    @ResponseBody
    public Object doDeleteByPrimaryKey(HttpServletRequest request,@RequestBody IndexPage indexPage) throws Exception{
        int flg = iIndexPageService.doDeleteByPrimaryKey(indexPage);
        if(flg > 0 ){
            return PageBeanUtils.formatForNormalTrue("","删除成功");
        }
        return PageBeanUtils.formatForNormalFalse("","删除失败,请检查传入数据");
    }
}
