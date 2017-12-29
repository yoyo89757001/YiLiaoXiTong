package com.xiaojun.yiliaoxitong.beans;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.xiaojun.yiliaoxitong.beans.DengLuBean;

import com.xiaojun.yiliaoxitong.beans.DengLuBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dengLuBeanDaoConfig;

    private final DengLuBeanDao dengLuBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dengLuBeanDaoConfig = daoConfigMap.get(DengLuBeanDao.class).clone();
        dengLuBeanDaoConfig.initIdentityScope(type);

        dengLuBeanDao = new DengLuBeanDao(dengLuBeanDaoConfig, this);

        registerDao(DengLuBean.class, dengLuBeanDao);
    }
    
    public void clear() {
        dengLuBeanDaoConfig.clearIdentityScope();
    }

    public DengLuBeanDao getDengLuBeanDao() {
        return dengLuBeanDao;
    }

}