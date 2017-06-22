package com.ccc.test;

import com.ccc.dao.IUserDao;
import com.ccc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Caozl on 2017-06-14.
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class CccTest {


    @Autowired
    private IUserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        int id = 1;
        User user = dao.selectUser(id);
        System.out.println(user.getName());
    }




}
