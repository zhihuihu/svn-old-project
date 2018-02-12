package com.hxkj.totop.service.impl;

import com.hxkj.totop.core.utils.Constant;
import com.hxkj.totop.core.utils.MultipleFileUtils;
import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.core.utils.TimeUtils;
import com.hxkj.totop.dao.IPingLifeDao;
import com.hxkj.totop.dao.IRichTextDao;
import com.hxkj.totop.entity.PingLife;
import com.hxkj.totop.entity.RichText;
import com.hxkj.totop.entity.pojo.PageBean;
import com.hxkj.totop.service.inter.IPingLifeService;
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
public class PingLifeService implements IPingLifeService {

    @Resource
    private IPingLifeDao iPingLifeDao;
    @Resource
    private IRichTextDao iRichTextDao;

    @Override
    public int doInsert(PingLife pingLife) throws Exception {
        pingLife.setPingLifeCreateTime(TimeUtils.getMySqlFormatTime());
        return iPingLifeDao.doInsert(pingLife);
    }

    @Override
    public int doInsertSelective(PingLife pingLife) throws Exception {
        return iPingLifeDao.doInsertSelective(pingLife);
    }

    @Override
    public int doDeleteByPrimaryKey(PingLife pingLife) throws Exception {
        return iPingLifeDao.doDeleteByPrimaryKey(pingLife);
    }

    @Override
    public int doUpdateByPrimaryKeySelective(PingLife pingLife) throws Exception {
        return iPingLifeDao.doUpdateByPrimaryKeySelective(pingLife);
    }

    @Override
    public int doUpdateByPrimaryKey(PingLife pingLife) throws Exception {
        return iPingLifeDao.doUpdateByPrimaryKey(pingLife);
    }

    @Override
    public PingLife selectByPrimaryKey(PingLife pingLife) throws Exception {
        /*PingLife pingLifeOut = iPingLifeDao.selectByPrimaryKey(pingLife);
        if(pingLifeOut != null){
            RichText richText = new RichText();
            //richText.setRichTextCuid(pingLife.get);
            pingLifeOut.setRichText(iRichTextDao.selectByPrimaryKey(richText));
        }*/
        return iPingLifeDao.selectByPrimaryKey(pingLife);
    }

    @Override
    public List<PingLife> selectByAttribute(PingLife pingLife) throws Exception {
        return iPingLifeDao.selectByAttribute(pingLife);
    }

    @Override
    public Map<String, Object> selectByAttributeAnd(PageBean<PingLife> pageBean) throws Exception {
        List<PingLife> list = iPingLifeDao.selectByAttributeAnd(pageBean);
        int lineCount = iPingLifeDao.selectByAttributeAndCount(pageBean);
        int pageCount = PageBeanUtils.getPageCount(lineCount,pageBean.getPageSize());
        return PageBeanUtils.formatForPageTrue(list,pageBean.getCurrentPage(),pageBean.getPageSize(),pageCount);
    }

    @Override
    public int selectByAttributeAndCount(PageBean<PingLife> pageBean) throws Exception {
        return 0;
    }

    @Override
    public Object doInsertOrUpdateMainImage(HttpServletRequest request, PingLife pingLife) throws Exception {
        PingLife pingLifeIsExit = iPingLifeDao.selectByPrimaryKey(pingLife);
        if(pingLifeIsExit == null){
            PingLife pingLifeOut = new PingLife();
            pingLifeOut.setPingLifeType(1);
            List<PingLife> list = iPingLifeDao.selectByAttribute(pingLifeOut);
            if(list.size()>2){
                return PageBeanUtils.formatForNormalFalse("","图片已经超过最大数");
            }
            String imgUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
            pingLife.setPingLifeType(1);
            pingLife.setPingLifeMainUrl(imgUrl);
            pingLife.setPingLifeCreateTime(TimeUtils.getMySqlFormatTime());
            iPingLifeDao.doInsert(pingLife);
            return PageBeanUtils.formatForNormalTrue("","数据增加成功");
        }
        String imgUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
        pingLife.setPingLifeMainUrl(imgUrl);
        pingLife.setPingLifeUpdateTime(TimeUtils.getMySqlFormatTime());
        iPingLifeDao.doUpdateByPrimaryKeySelective(pingLife);
        return PageBeanUtils.formatForNormalTrue("","数据更新成功");
    }
}
