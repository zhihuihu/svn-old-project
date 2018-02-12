package com.hxkj.totop.controller;

import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.entity.Mingpinhui;
import com.hxkj.totop.entity.pojo.DataInBean;
import com.hxkj.totop.entity.pojo.PageBean;
import com.hxkj.totop.service.inter.IMingpinhuiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 名品汇的控制层
 * Created by huzhihui on 2016/4/29.
 */
@Controller
@RequestMapping(value = "mingpinhui")
public class MingpinhuiController {

    @Resource
    private IMingpinhuiService iMingpinhuiService;

    /**
     * 增加或者更新一个名品汇
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doInsertOrUpdateMingpinhui")
    @ResponseBody
    public Object doInsertOrUpdateMingpinhui(HttpServletRequest request) throws Exception{
        Mingpinhui mingpinhui = new Mingpinhui();
        mingpinhui.setMingpinthuiCuid(request.getParameter("mingpinthuiCuid"));
        return iMingpinhuiService.doInsertOrUpdateMingpinhui(request,mingpinhui);
    }

    /**
     * 通过主键删除名品汇
     * @param request
     * @param mingpinhui
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doDeleteByPrimaryKey")
    @ResponseBody
    public Object doDeleteByPrimaryKey(HttpServletRequest request, @RequestBody Mingpinhui mingpinhui) throws Exception{
        int flg = iMingpinhuiService.doDeleteByPrimaryKey(mingpinhui);
        if(flg > 0 ){
            return PageBeanUtils.formatForNormalTrue("","删除名品汇成功");
        }
        return PageBeanUtils.formatForNormalFalse("","删除失败,请检查传入数据");
    }

    /**
     * 通过主键进行数据查询
     * @param request
     * @param mingpinhui
     * @return
     * @throws Exception
     */
    @RequestMapping(value="selectByPrimaryKey")
    @ResponseBody
    public Object selectByPrimaryKey(HttpServletRequest request,@RequestBody Mingpinhui mingpinhui) throws Exception{
        mingpinhui = iMingpinhuiService.selectByPrimaryKey(mingpinhui);
        if(mingpinhui == null){
            return PageBeanUtils.formatForNormalFalse("","没有该数据");
        }
        return PageBeanUtils.formatForNormalTrue("",mingpinhui);
    }

    /**
     * 分页查询
     * @param request
     * @param dataInBean
     * @return
     * @throws Exception
     */
    @RequestMapping(value="selectByAttributeAnd")
    @ResponseBody
    public Object selectByAttributeAnd(HttpServletRequest request, @RequestBody DataInBean dataInBean) throws Exception{
        PageBean<Mingpinhui> pageBean = new PageBean<Mingpinhui>(dataInBean.getCurrentPage(),dataInBean.getPageSize(),dataInBean.getMingpinhui());
        return iMingpinhuiService.selectByAttributeAnd(pageBean);
    }

}
