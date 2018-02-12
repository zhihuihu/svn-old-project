package com.hxkj.totop.service.impl;

import com.hxkj.totop.core.utils.Constant;
import com.hxkj.totop.core.utils.MultipleFileUtils;
import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.core.utils.TimeUtils;
import com.hxkj.totop.dao.IMingpinhuiDao;
import com.hxkj.totop.entity.Mingpinhui;
import com.hxkj.totop.entity.pojo.PageBean;
import com.hxkj.totop.service.inter.IMingpinhuiService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/29.
 */
@Service
@Transactional
public class MingpinhuiService implements IMingpinhuiService {

    @Resource
    private IMingpinhuiDao iMingpinhuiDao;
    @Override
    public int doInsert(Mingpinhui mingpinhui) throws Exception {
        return iMingpinhuiDao.doInsert(mingpinhui);
    }

    @Override
    public int doInsertSelective(Mingpinhui mingpinhui) throws Exception {
        return iMingpinhuiDao.doInsertSelective(mingpinhui);
    }

    @Override
    public int doDeleteByPrimaryKey(Mingpinhui mingpinhui) throws Exception {
        return iMingpinhuiDao.doDeleteByPrimaryKey(mingpinhui);
    }

    @Override
    public int doUpdateByPrimaryKeySelective(Mingpinhui mingpinhui) throws Exception {
        return iMingpinhuiDao.doUpdateByPrimaryKeySelective(mingpinhui);
    }

    @Override
    public int doUpdateByPrimaryKey(Mingpinhui mingpinhui) throws Exception {
        return iMingpinhuiDao.doUpdateByPrimaryKey(mingpinhui);
    }

    @Override
    public Mingpinhui selectByPrimaryKey(Mingpinhui mingpinhui) throws Exception {
        return iMingpinhuiDao.selectByPrimaryKey(mingpinhui);
    }

    @Override
    public List<Mingpinhui> selectByAttribute(Mingpinhui mingpinhui) throws Exception {
        return iMingpinhuiDao.selectByAttribute(mingpinhui);
    }

    @Override
    public Map<String, Object> selectByAttributeAnd(PageBean<Mingpinhui> pageBean) throws Exception {
        List<Mingpinhui> list = iMingpinhuiDao.selectByAttributeAnd(pageBean);
        int lineCount = iMingpinhuiDao.selectByAttributeAndCount(pageBean);
        int pageCount = PageBeanUtils.getPageCount(lineCount,pageBean.getPageSize());
        return PageBeanUtils.formatForPageTrue(list,pageBean.getCurrentPage(),pageBean.getPageSize(),pageCount);
    }

    @Override
    public int selectByAttributeAndCount(PageBean<Mingpinhui> pageBean) throws Exception {
        return 0;
    }

    /**
     * 增加一个名品汇的图片显示
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public Object doInsertOrUpdateMingpinhui(HttpServletRequest request,Mingpinhui mingpinhui) throws Exception {
        Mingpinhui mingpinhuiOut = iMingpinhuiDao.selectByPrimaryKey(mingpinhui);
        Map<String,String> inputNameMap = new HashedMap();
        inputNameMap.put("mingpinthuiThumbUrl","");
        inputNameMap.put("mingpinthuiMainImageUrl1","");
        inputNameMap = MultipleFileUtils.uploadMultipleFileByInputName(request, Constant.IMAGE_ROOT_URL,"",true,inputNameMap);
        if(mingpinhuiOut == null){
            mingpinhui = new Mingpinhui();
            mingpinhui.setMingpinthuiThumbUrl(inputNameMap.get("mingpinthuiThumbUrl"));
            mingpinhui.setMingpinthuiMainImageUrl1(inputNameMap.get("mingpinthuiMainImageUrl1"));
            mingpinhui.setMingpinthuiCreateTime(TimeUtils.getMySqlFormatTime());
            iMingpinhuiDao.doInsert(mingpinhui);
            return PageBeanUtils.formatForNormalTrue("","增加名品汇成功");
        }
        if(!inputNameMap.get("mingpinthuiThumbUrl").equals("")){
            mingpinhui.setMingpinthuiThumbUrl(inputNameMap.get("mingpinthuiThumbUrl"));
        }
        if(!inputNameMap.get("mingpinthuiMainImageUrl1").equals("")){
            mingpinhui.setMingpinthuiMainImageUrl1(inputNameMap.get("mingpinthuiMainImageUrl1"));
        }
        mingpinhui.setMingpinthuiUpdateTime(TimeUtils.getMySqlFormatTime());
        iMingpinhuiDao.doUpdateByPrimaryKeySelective(mingpinhui);
        return PageBeanUtils.formatForNormalTrue("","更新名品汇成功");
    }
}
