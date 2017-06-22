package com.ccc.dao;

import com.ccc.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Caozl on 2017-06-14.
 */

@Repository
public interface IUserDao {
    User selectUser(int id);
    List<User> selecUserList();
}
