package com.hxkj.totops.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.totops.core.config.Constant;
import com.hxkj.totops.core.config.EnumConfig;
import com.hxkj.totops.core.utils.MultipleFileUtils;
import com.hxkj.totops.core.utils.PageReturnUtils;
import com.hxkj.totops.core.utils.PropertiesUtils;
import com.hxkj.totops.core.utils.TimeUtils;
import com.hxkj.totops.dao.IIndexPageDao;
import com.hxkj.totops.entity.IndexPage;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.BaseService;
import com.hxkj.totops.service.inter.IIndexPageService;

@Service
@Transactional
public class IndexPageService extends BaseService<IndexPage> implements IIndexPageService {

	@Autowired
	private IIndexPageDao iIndexPageDao;
	
	@Override
	public Map<String, Object> insertMainImage(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		IndexPage indexPageQ = new IndexPage();
		indexPageQ.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_MAIN.getIndex());
		List<IndexPage> indexPages = iIndexPageDao.selectByAttribute(indexPageQ);
		if(null != indexPages && indexPages.size() > 3){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "主页轮播图片已经达到四张不能继续新增");
		}
		String indexPageMainImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		IndexPage indexPage = parameterBean.getIndexPage();
		indexPage.setIndexPageCuid(UUID.randomUUID().toString());
		indexPage.setIndexPageMainImage(indexPageMainImage);
		indexPage.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_MAIN.getIndex());
		indexPage.setIndexPageCreateTime(TimeUtils.getNowTime());
		iIndexPageDao.insertSelective(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "新增主页图片成功");
	}

	@Override
	public Map<String, Object> updateMainImage(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		if(null == parameterBean || null == parameterBean.getIndexPage() || parameterBean.getIndexPage().getIndexPageCuid().equals("")){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入数据错误");
		}
		IndexPage indexPage = iIndexPageDao.selectByPrimaryKey(parameterBean.getIndexPage().getIndexPageCuid());
		if(null == indexPage){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有查询到该记录，修改失败");
		}
		String indexPageMainImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		indexPage = parameterBean.getIndexPage();
		indexPage.setIndexPageMainImage(indexPageMainImage);
		iIndexPageDao.updateByPrimaryKeySelective(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "主页图片更新成功");
	}

	@Override
	public Map<String, Object> insertMidInfo(HttpServletRequest request, ParameterBean parameterBean) throws Exception {
		IndexPage indexPageQ = new IndexPage();
		indexPageQ.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_MID.getIndex());
		List<IndexPage> indexPages = iIndexPageDao.selectByAttribute(indexPageQ);
		if(null != indexPages && indexPages.size() > 1){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "主页中间内容已经达到一条不能继续新增");
		}
		String indexPageMainImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		IndexPage indexPage = parameterBean.getIndexPage();
		indexPage.setIndexPageCuid(UUID.randomUUID().toString());
		indexPage.setIndexPageCenterIcon(indexPageMainImage);
		indexPage.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_MID.getIndex());
		indexPage.setIndexPageCreateTime(TimeUtils.getNowTime());
		iIndexPageDao.insertSelective(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "新增主页中间内容成功");
	}

	@Override
	public Map<String, Object> updateMidInfo(HttpServletRequest request, ParameterBean parameterBean) throws Exception {
		if(null == parameterBean || null == parameterBean.getIndexPage() || parameterBean.getIndexPage().getIndexPageCuid().equals("")){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入数据错误");
		}
		IndexPage indexPage = iIndexPageDao.selectByPrimaryKey(parameterBean.getIndexPage().getIndexPageCuid());
		if(null == indexPage){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有查询到该记录，修改失败");
		}
		indexPage = parameterBean.getIndexPage();
		String indexPageMainImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		indexPage.setIndexPageCenterIcon(indexPageMainImage);
		iIndexPageDao.updateByPrimaryKeySelective(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "主页中间内容更新成功");
	}

	@Override
	public Map<String, Object> insertBottomInfo(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		IndexPage indexPageQ = new IndexPage();
		indexPageQ.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_BOTTOM.getIndex());
		List<IndexPage> indexPages = iIndexPageDao.selectByAttribute(indexPageQ);
		if(null != indexPages && indexPages.size() > 3){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "主页底部内容已经达到三条不能继续新增");
		}
		String indexPageMainImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		IndexPage indexPage = parameterBean.getIndexPage();
		indexPage.setIndexPageCuid(UUID.randomUUID().toString());
		indexPage.setIndexPageBottomIcon(indexPageMainImage);
		indexPage.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_BOTTOM.getIndex());
		indexPage.setIndexPageCreateTime(TimeUtils.getNowTime());
		iIndexPageDao.insertSelective(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "新增主页底部内容成功");
	}

	@Override
	public Map<String, Object> updateBottomInfo(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		if(null == parameterBean || null == parameterBean.getIndexPage() || parameterBean.getIndexPage().getIndexPageCuid().equals("")){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入数据错误");
		}
		IndexPage indexPage = iIndexPageDao.selectByPrimaryKey(parameterBean.getIndexPage().getIndexPageCuid());
		if(null == indexPage){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有查询到该记录，修改失败");
		}
		indexPage = parameterBean.getIndexPage();
		String indexPageMainImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		indexPage.setIndexPageCenterIcon(indexPageMainImage);
		iIndexPageDao.updateByPrimaryKeySelective(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "主页底部内容更新成功");
	}

}
