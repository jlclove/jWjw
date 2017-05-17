package com.goodlaike.wjw.config;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Dao 管理器<br>
 * 包含读写分离的Dao
 * 
 * @author Jail Hu
 */
public abstract class DaoManagement {
  
  @Autowired
  @Qualifier(DataSourceConfig.BEANNAME_SQLSESSION_COMMON)
  protected SqlSession sqlSessionCommon;
}
