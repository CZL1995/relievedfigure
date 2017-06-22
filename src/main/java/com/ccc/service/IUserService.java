package com.ccc.service;

import com.ccc.model.User;

import java.util.List;

/**
 * Created by Caozl on 2017-06-14.
 */
public interface IUserService {
    public User selectUser(int id);
    public List<User> selecUserList();
}
