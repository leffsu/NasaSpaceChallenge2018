package com.nasaspacechallenge2018.Database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.nasaspacechallenge2018.Database.Entity;
import com.nasaspacechallenge2018.Database.Item;
import com.nasaspacechallenge2018.Database.Situation;

import com.nasaspacechallenge2018.Database.EntityDao;
import com.nasaspacechallenge2018.Database.ItemDao;
import com.nasaspacechallenge2018.Database.SituationDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig entityDaoConfig;
    private final DaoConfig itemDaoConfig;
    private final DaoConfig situationDaoConfig;

    private final EntityDao entityDao;
    private final ItemDao itemDao;
    private final SituationDao situationDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        entityDaoConfig = daoConfigMap.get(EntityDao.class).clone();
        entityDaoConfig.initIdentityScope(type);

        itemDaoConfig = daoConfigMap.get(ItemDao.class).clone();
        itemDaoConfig.initIdentityScope(type);

        situationDaoConfig = daoConfigMap.get(SituationDao.class).clone();
        situationDaoConfig.initIdentityScope(type);

        entityDao = new EntityDao(entityDaoConfig, this);
        itemDao = new ItemDao(itemDaoConfig, this);
        situationDao = new SituationDao(situationDaoConfig, this);

        registerDao(Entity.class, entityDao);
        registerDao(Item.class, itemDao);
        registerDao(Situation.class, situationDao);
    }
    
    public void clear() {
        entityDaoConfig.clearIdentityScope();
        itemDaoConfig.clearIdentityScope();
        situationDaoConfig.clearIdentityScope();
    }

    public EntityDao getEntityDao() {
        return entityDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public SituationDao getSituationDao() {
        return situationDao;
    }

}
