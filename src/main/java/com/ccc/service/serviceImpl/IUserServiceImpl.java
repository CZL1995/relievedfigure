package com.ccc.service.serviceImpl;

import com.ccc.dao.IUserDao;
import com.ccc.model.User;
import com.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Caozl on 2017-06-14.
 */
@Service("userService")
public class IUserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    public User selectUser(int id){
      return   this.userDao.selectUser(id );

    }

    @Override
    public List<User> selecUserList() {
        return userDao.selecUserList();
    }

}
