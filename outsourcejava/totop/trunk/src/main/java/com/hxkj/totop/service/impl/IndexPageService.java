package com.hxkj.totop.service.impl;

import com.hxkj.totop.core.utils.Constant;
import com.hxkj.totop.core.utils.MultipleFileUtils;
import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.core.utils.TimeUtils;
import com.hxkj.totop.dao.IIndexPageDao;
import com.hxkj.totop.entity.IndexPage;
import com.hxkj.totop.entity.pojo.PageBean;
import com.hxkj.totop.service.inter.IIndexPageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/25.
 */
@Service
@Transactional
public class IndexPageService implements IIndexPageService {

    @Resource
    private IIndexPageDao iIndexPageDao;

    @Override
    public int doInsert(IndexPage indexPage) throws Exception {
        return iIndexPageDao.doInsert(indexPage);
    }

    @Override
    public int doInsertSelective(IndexPage indexPage) throws Exception {
        return iIndexPageDao.doInsertSelective(indexPage);
    }

    @Override
    public int doDeleteByPrimaryKey(IndexPage indexPage) throws Exception {
        return iIndexPageDao.doDeleteByPrimaryKey(indexPage);
    }

    @Override
    public int doUpdateByPrimaryKeySelective(IndexPage indexPage) throws Exception {
        return iIndexPageDao.doUpdateByPrimaryKeySelective(indexPage);
    }

    @Override
    public int doUpdateByPrimaryKey(IndexPage indexPage) throws Exception {
        return iIndexPageDao.doUpdateByPrimaryKey(indexPage);
    }

    @Override
    public IndexPage selectByPrimaryKey(IndexPage indexPage) throws Exception {
        return iIndexPageDao.selectByPrimaryKey(indexPage);
    }

    @Override
    public List<IndexPage> selectByAttribute(IndexPage indexPage) throws Exception {
        return iIndexPageDao.selectByAttribute(indexPage);
    }

    @Override
    public Map<String, Object> selectByAttributeAnd(PageBean<IndexPage> pageBean) throws Exception {
        return null;
    }

    @Override
    public int selectByAttributeAndCount(PageBean<IndexPage> pageBean) throws Exception {
        return 0;
    }

    /**
     * 主页的四张主图的新增或者维护
     *
     * @param request
     * @param indexPage
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> doInsertOrUpdateMainPic(HttpServletRequest request, IndexPage indexPage) throws Exception {
        indexPage = iIndexPageDao.selectByPrimaryKey(indexPage);
        if(indexPage == null){//新增主页的一张图片
            indexPage = new IndexPage();
            IndexPage indexPageIn = new IndexPage();
            indexPageIn.setIndexPageType(1);
            List<IndexPage> indexPageList = iIndexPageDao.selectByAttribute(indexPageIn);
            if(indexPageList.size()==4){
                return PageBeanUtils.formatForNormalFalse("","主页滑动图片已经设置为最多状态");
            }
            String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
            indexPage.setIndexPageImageUrl(imageUrl);
            indexPage.setIndexPageType(1);//主页的四张图
            indexPage.setIndexPageCreateTime(TimeUtils.getMySqlFormatTime());
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doInsert(indexPage);
            return PageBeanUtils.formatForNormalTrue("","新增主页图片成功");
        }else{//修改主页显示的一张图片
            String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
            indexPage.setIndexPageImageUrl(imageUrl);
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doUpdateByPrimaryKeySelective(indexPage);
            return PageBeanUtils.formatForNormalTrue("","修改主页图片成功");
        }
    }

    /**
     * 主页公司介绍的更改或更新
     *
     * @param indexPage
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> doInsertOrUpdateCompanyIntro(IndexPage indexPage) throws Exception {
        IndexPage indexPageInOut = new IndexPage();
        indexPageInOut.setIndexPageCuid(indexPage.getIndexPageCuid());
        indexPageInOut = iIndexPageDao.selectByPrimaryKey(indexPageInOut);
        if(indexPageInOut == null){
            indexPage.setIndexPageCreateTime(TimeUtils.getMySqlFormatTime());
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doInsert(indexPage);
            return PageBeanUtils.formatForNormalTrue("","新增公司简介成功");
        }else{
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doUpdateByPrimaryKeySelective(indexPage);
            return PageBeanUtils.formatForNormalTrue("","更新公司简介成功");
        }
    }

    /**
     * 更新公司简介右边的图片
     *
     * @param request
     * @param indexPage
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> doInsertOrUpdateCompanyImages(HttpServletRequest request, IndexPage indexPage) throws Exception {
        indexPage = iIndexPageDao.selectByPrimaryKey(indexPage);
        if(indexPage == null){
            indexPage = new IndexPage();
            IndexPage indexPageIn = new IndexPage();
            indexPageIn.setIndexPageType(3);
            List<IndexPage> indexPageList = iIndexPageDao.selectByAttribute(indexPageIn);
            if(indexPageList.size()==1){
                return PageBeanUtils.formatForNormalFalse("","主营产品图片上传至最大数目");
            }
            String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
            indexPage.setIndexPageImageUrl(imageUrl);
            indexPage.setIndexPageType(3);//主页的四张图
            indexPage.setIndexPageCreateTime(TimeUtils.getMySqlFormatTime());
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doInsert(indexPage);
            return PageBeanUtils.formatForNormalTrue("","主营产品图片上传成功");
        }else{
            String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
            indexPage.setIndexPageImageUrl(imageUrl);
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doUpdateByPrimaryKeySelective(indexPage);
            return PageBeanUtils.formatForNormalTrue("","主营产品图片修改成功");
        }
    }

    /**
     * 主页最下面三张图片的增加修改
     *
     * @param request
     * @param indexPage
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> doInsertOrUpdateBottomImages(HttpServletRequest request, IndexPage indexPage) throws Exception {
        indexPage = iIndexPageDao.selectByPrimaryKey(indexPage);
        if(indexPage == null){
            indexPage = new IndexPage();
            IndexPage indexPageIn = new IndexPage();
            indexPageIn.setIndexPageType(4);
            List<IndexPage> indexPageList = iIndexPageDao.selectByAttribute(indexPageIn);
            if(indexPageList.size()==3){
                return PageBeanUtils.formatForNormalFalse("","简介图片上传至最大数目");
            }
            String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
            indexPage.setIndexPageImageUrl(imageUrl);
            indexPage.setIndexPageType(4);//主页的四张图
            indexPage.setIndexPageCreateTime(TimeUtils.getMySqlFormatTime());
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doInsert(indexPage);
            return PageBeanUtils.formatForNormalTrue("","产品简介图片上传成功");
        }else{
            String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, Constant.IMAGE_ROOT_URL,"",true);
            indexPage.setIndexPageImageUrl(imageUrl);
            indexPage.setIndexPageUpdateTime(TimeUtils.getMySqlFormatTime());
            iIndexPageDao.doUpdateByPrimaryKeySelective(indexPage);
            return PageBeanUtils.formatForNormalTrue("","简介图片修改成功");
        }
    }

    @Override
    public List<Map<String, Object>> selectechcaheList() throws Exception {
        return iIndexPageDao.selectechcaheList();
    }
}
