package com.hxkj.totop.service.impl;

import com.hxkj.totop.core.utils.TimeUtils;
import com.hxkj.totop.dao.IRichTextDao;
import com.hxkj.totop.entity.RichText;
import com.hxkj.totop.entity.pojo.PageBean;
import com.hxkj.totop.service.inter.IRichTextService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/29.
 */
@Service
@Transactional
public class RichTextService implements IRichTextService {

    @Resource
    private IRichTextDao iRichTextDao;

    @Override
    public int doInsert(RichText richText) throws Exception {
        richText.setRichTextCreateTime(TimeUtils.getMySqlFormatTime());
        RichText richTextIsExit = new RichText();
        richTextIsExit.setPingLifeCuid(richText.getPingLifeCuid());
        List<RichText> richTexts = iRichTextDao.selectByAttribute(richTextIsExit);
        if(richTexts.size() > 0){
            return 0;
        }
        return iRichTextDao.doInsert(richText);
    }

    @Override
    public int doInsertSelective(RichText richText) throws Exception {
        return iRichTextDao.doInsertSelective(richText);
    }

    @Override
    public int doDeleteByPrimaryKey(RichText richText) throws Exception {
        return iRichTextDao.doDeleteByPrimaryKey(richText);
    }

    @Override
    public int doUpdateByPrimaryKeySelective(RichText richText) throws Exception {
        return iRichTextDao.doUpdateByPrimaryKeySelective(richText);
    }

    @Override
    public int doUpdateByPrimaryKey(RichText richText) throws Exception {
        return iRichTextDao.doUpdateByPrimaryKey(richText);
    }

    @Override
    public RichText selectByPrimaryKey(RichText richText) throws Exception {
        return iRichTextDao.selectByPrimaryKey(richText);
    }

    @Override
    public List<RichText> selectByAttribute(RichText richText) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> selectByAttributeAnd(PageBean<RichText> pageBean) throws Exception {
        return null;
    }

    @Override
    public int selectByAttributeAndCount(PageBean<RichText> pageBean) throws Exception {
        return 0;
    }
}
