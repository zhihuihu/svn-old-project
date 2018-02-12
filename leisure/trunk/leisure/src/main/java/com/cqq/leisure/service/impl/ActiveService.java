package com.cqq.leisure.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.RedisUtils;
import com.cqq.leisure.dao.IActiveDao;
import com.cqq.leisure.dao.IUserDao;
import com.cqq.leisure.entity.Active;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.inter.IActiveService;
@Service
@Transactional
public class ActiveService implements IActiveService {
	@Resource
	private IActiveDao iActiveDao;
	@Resource
	private IUserDao iUserDao;
	@Override
	public int doDeleteByPrimaryKey(Active b) throws Exception {
		return iActiveDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Active> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iActiveDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(Active b) throws Exception {
		return iActiveDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Active> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iActiveDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(Active b) throws Exception {
		return iActiveDao.doInsertSelective(b);
	}

	@Override
	public Active selectByPrimaryKey(Active b) throws Exception {
		return iActiveDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Active b) throws Exception {
		return iActiveDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Active b) throws Exception {
		return iActiveDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Active> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iActiveDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Active> pageBean)throws Exception {
		int lineCount = iActiveDao.selectByAttributeCountAnd(pageBean);
		List<Active> list = iActiveDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Active> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Active> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Active> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Active> selectNearByActive(String token) throws Exception {
		User tokenUser = RedisUtils.get(token, User.class);
		if (tokenUser == null) {
			PageBeanUtils.formatForNormalFalse("", "登录到期请重新登录");
		}
		PageBean<Active> pageBean = new PageBean<Active>(0, 10000);
		pageBean.setInVo(new Active());
		List<Active> list = new ArrayList<Active>();
		list = iActiveDao.selectByAttributeAnd(pageBean); // 分页查找所有的Active
		List<Active> recomendActive = new ArrayList<Active>();
		for (int i = 0; i < list.size(); i++) { // 遍历所有的Active
			if (list.get(i).getUserId() != tokenUser.getUserId()) {
				String attrLog = list.get(i).getActiveLog(); // 获取到每个活动的经纬度
				String attrLat = list.get(i).getActiveLat();
				String Log = tokenUser.getUserLog(); // 获取到登录用户的经纬度
				String Lat = tokenUser.getUserLat();
				if (attrLog != null && !attrLog.equals("") && attrLat != null
						&& !attrLat.equals("") && Log != null
						&& !Log.equals("") && Lat != null && !Lat.equals("")) {
					if (list.get(i).getUserId() != 0) {
						int userId = list.get(i).getUserId();
						User user = new User();
						user.setUserId(userId);
						User userExict = iUserDao.selectByPrimaryKey(user);
						list.get(i).setUser(userExict);
						double lat1 = Double.parseDouble(attrLat);
						double lat2 = Double.parseDouble(Lat);
						double lng1 = Double.parseDouble(attrLog);
						double lng2 = Double.parseDouble(Log);
						if (lat2 != 0.0 && lng2 != 0.0) {
							double radLat1 = lat1 * Math.PI / 180.0;
							double radLat2 = lat2 * Math.PI / 180.0;
							double difference = radLat1 - radLat2;
							double mdifference = lng1 * Math.PI / 180.0 - lng2
									* Math.PI / 180.0;
							double attrDistance = 2 * Math.asin(Math.sqrt(Math
									.pow(Math.sin(difference / 2), 2)
									+ Math.cos(radLat1)
									* Math.cos(radLat2)
									* Math.pow(Math.sin(mdifference / 2), 2)));
							attrDistance = attrDistance * EARTH_RADIUS;
							attrDistance = Math.round(attrDistance * 10000) / 10000;
							if (attrDistance <= 5) { // 相差的距离少于5km
								recomendActive.add(list.get(i));
							}
						}
					}
				}
			}
		}
		return recomendActive;

	}

	private static double EARTH_RADIUS = 6378.137;
	@Override
	public List<Active> selectAll(PageBean<Active> pageBean) throws Exception {
		return iActiveDao.selectAll(pageBean);
	}

	@Override
	public List<Active> selectByKeyWord(String keyWord) throws Exception {
		Active active = new Active();
		PageBean<Active> pagebean = new PageBean<Active>(0, 100);
		active.setActiveMainContent(keyWord);
		active.setActiveName(keyWord);
		active.setActiveAddress(keyWord);
		pagebean.setInVo(active);
		//iActiveDao.selectByKeyWord(pagebean);
		return iActiveDao.selectByKeyWord(pagebean);
	}

}
