package com.ccc.base;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

/**
 * Created by Caozl on 2017-06-15.
 */
public class BaseController {
    @Resource
    private SqlSession sqlSession;

    protected SqlSession getSqlSession(){
        return this.sqlSession;
    }
}
