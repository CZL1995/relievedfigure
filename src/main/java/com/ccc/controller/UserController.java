package com.ccc.controller;

import com.ccc.base.BaseController;
import com.ccc.model.User;
import com.ccc.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    private final static Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public Map<String, Object> selectUser()  {
        Map<String,Object> map =new HashMap<>();
        //User user = this.userService.selectUser(1);
         List<User> list=userService.selecUserList();
         User user=list.get(0);
        logger.info("-------------------"+user.toString()+"-------------------");
       // ModelAndView modelAndView=new ModelAndView("succseed");
        //modelAndView.addObject("id", user.getId());
       // modelAndView.addObject("name", user.getName());
        map.put("id",user.getId());
        map.put("name",user.getName());
        return map;
    }

}
