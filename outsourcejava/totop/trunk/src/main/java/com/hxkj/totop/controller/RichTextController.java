package com.hxkj.totop.controller;

import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.entity.RichText;
import com.hxkj.totop.service.inter.IRichTextService;
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
@RequestMapping(value = "richText")
public class RichTextController {

    @Resource
    private IRichTextService iRichTextService;

    /**
     * 添加数据
     * @param request
     * @param richText
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doInsert")
    @ResponseBody
    public Object doInsert(HttpServletRequest request, @RequestBody RichText richText) throws Exception{
        int flg = iRichTextService.doInsert(richText);
        if(flg == 0){
            return PageBeanUtils.formatForNormalFalse("","该详细数据已经存在一条,不能重复添加");
        }
        return PageBeanUtils.formatForNormalTrue("","增加数据成功");
    }

    /**
     * 通过主键进行更新
     * @param request
     * @param richText
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "doUpdateByPrimaryKey")
    @ResponseBody
    public Object doUpdateByPrimaryKey(HttpServletRequest request, @RequestBody RichText richText) throws Exception{
        iRichTextService.doUpdateByPrimaryKeySelective(richText);
        return PageBeanUtils.formatForNormalTrue("","更新数据成功");
    }

    @RequestMapping(value = "doDeleteByPrimaryKey")
    @ResponseBody
    public Object doDeleteByPrimaryKey(HttpServletRequest request, @RequestBody RichText richText) throws Exception{
        iRichTextService.doDeleteByPrimaryKey(richText);
        return PageBeanUtils.formatForNormalTrue("","删除数据成功");
    }
}
