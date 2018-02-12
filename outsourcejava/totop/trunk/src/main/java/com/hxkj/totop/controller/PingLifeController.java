package com.hxkj.totop.controller;

import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.core.utils.TimeUtils;
import com.hxkj.totop.entity.PingLife;
import com.hxkj.totop.entity.pojo.DataInBean;
import com.hxkj.totop.entity.pojo.PageBean;
import com.hxkj.totop.service.inter.IPingLifeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by huzhihui on 2016/4/29.
 */
@Controller
@RequestMapping(value = "pingLife")
public class PingLifeController {

    @Resource
    private IPingLifeService iPingLifeService;

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doInsertOrUpdateMainImage")
    @ResponseBody
    public Object doInsertOrUpdateMainImage(HttpServletRequest request) throws Exception{
        PingLife pingLife = new PingLife();
        pingLife.setPingLifeCuid(request.getParameter("pingLifeCuid"));
        return iPingLifeService.doInsertOrUpdateMainImage(request,pingLife);
    }

    /**
     * 增加一个小标签
     * @param request
     * @param pingLife 基本的数据全部传入
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doInsertNorMal")
    @ResponseBody
    public Object doInsertNorMal(HttpServletRequest request, @RequestBody PingLife pingLife) throws Exception{
        iPingLifeService.doInsert(pingLife);
        return PageBeanUtils.formatForNormalTrue("","增加数据成功");
    }

    /**
     * 通过主键查询内容
     * @param request
     * @param pingLife
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectByPrimaryKey")
    @ResponseBody
    public Object selectByPrimaryKey(HttpServletRequest request, @RequestBody PingLife pingLife) throws Exception{
        pingLife = iPingLifeService.selectByPrimaryKey(pingLife);
        if(pingLife == null){
            return PageBeanUtils.formatForNormalFalse("","没有该数据,查询失败");
        }
        return PageBeanUtils.formatForNormalTrue("",pingLife);
    }

    /**
     * 分页查询
     * @param request
     * @param dataInBean
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectByAttributeAnd")
    @ResponseBody
    public Object selectByAttributeAnd(HttpServletRequest request, @RequestBody DataInBean dataInBean) throws Exception{
        PageBean<PingLife> pageBean = new PageBean<PingLife>(dataInBean.getCurrentPage(),dataInBean.getPageSize(),dataInBean.getPingLife());
        return iPingLifeService.selectByAttributeAnd(pageBean);
    }

    /**
     * 通过主键进行删除
     * @param request
     * @param pingLife
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doDeleteByPrimaryKey")
    @ResponseBody
    public Object doDeleteByPrimaryKey(HttpServletRequest request, @RequestBody PingLife pingLife) throws Exception{
        int flg = iPingLifeService.doDeleteByPrimaryKey(pingLife);
        if(flg == 0){
            return PageBeanUtils.formatForNormalFalse("","没有该数据,删除失败");
        }
        return PageBeanUtils.formatForNormalTrue("","删除成功");
    }

    /**
     * 品生活数据更新
     * @param request
     * @param pingLife
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doUpdateByPrimary")
    @ResponseBody
    public Object doUpdateByPrimary(HttpServletRequest request, @RequestBody PingLife pingLife) throws Exception{
        int flg = iPingLifeService.doUpdateByPrimaryKeySelective(pingLife);
        if(flg == 0){
            return PageBeanUtils.formatForNormalFalse("","没有该数据,更新失败");
        }
        return PageBeanUtils.formatForNormalTrue("","更新成功");
    }
}
