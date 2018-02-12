package com.hxkj.totop.service.impl;

import com.hxkj.totop.dao.ISysUserDao;
import com.hxkj.totop.entity.SysUser;
import com.hxkj.totop.entity.pojo.PageBean;
import com.hxkj.totop.service.inter.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/25.
 */
@Service
@Transactional
public class SysUserService implements ISysUserService {

    @Resource
    private ISysUserDao iSysUserDao;

    @Override
    public int doInsert(SysUser sysUser)  throws Exception{
        return iSysUserDao.doInsert(sysUser);
    }

    @Override
    public int doInsertSelective(SysUser sysUser) throws Exception {
        return iSysUserDao.doInsertSelective(sysUser);
    }

    @Override
    public int doDeleteByPrimaryKey(SysUser sysUser) throws Exception {
        return iSysUserDao.doDeleteByPrimaryKey(sysUser);
    }

    @Override
    public int doUpdateByPrimaryKeySelective(SysUser sysUser) throws Exception {
        return iSysUserDao.doUpdateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int doUpdateByPrimaryKey(SysUser sysUser) throws Exception {
        return iSysUserDao.doUpdateByPrimaryKey(sysUser);
    }

    @Override
    public SysUser selectByPrimaryKey(SysUser sysUser) throws Exception {
        return iSysUserDao.selectByPrimaryKey(sysUser);
    }

    @Override
    public List<SysUser> selectByAttribute(SysUser sysUser) throws Exception {
        return iSysUserDao.selectByAttribute(sysUser);
    }

    @Override
    public Map<String, Object> selectByAttributeAnd(PageBean<SysUser> pageBean) throws Exception {
        return null;
    }

    @Override
    public int selectByAttributeAndCount(PageBean<SysUser> pageBean) throws Exception {
        return 0;
    }

    /**
     * 管理员登录方法
     *
     * @param sysUser
     * @return
     * @throws Exception
     */
    @Override
    public SysUser doLogin(SysUser sysUser) throws Exception {
        List<SysUser> sysUsers = iSysUserDao.selectByAttribute(sysUser);
        if(sysUsers == null || sysUsers.size() == 0 || sysUsers.size() > 1){
            return null;
        }
        return sysUsers.get(0);
    }
}
