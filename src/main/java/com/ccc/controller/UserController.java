package com.ccc.controller;

import com.ccc.base.BaseController;
import com.ccc.model.User;
import com.ccc.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caozl on 2017-06-14.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Resource
    private IUserService userService;
   /* @Resource
    private SqlSessionFactory sqlSessionFactory;*/

  /*  private SqlSession sqlSession = null;
    *//**
     * 获取sqlSession.
     * @return *//* public SqlSession getSqlSession(){
        if(sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }*/



    @RequestMapping("/showUser.do")
    public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //int userId = Integer.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(1);
       // List<User> list=userService.selecUserList();
        //List<User> list=new ArrayList<User>();
        //this.getSqlSession().selectOne("selectUser",1);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+user.toString());
        //System.out.println("AAAAAAAAAAAAAAAAaaaaaaaaaAAA"+user.getId());
       // ObjectMapper mapper = new ObjectMapper();
        //response.getWriter().write(mapper.writeValueAsString(user));
        //response.getWriter().close();
        ModelAndView modelAndView=new ModelAndView("succseed");
        modelAndView.addObject("id", user.getId());
        modelAndView.addObject("name", user.getName());
        return modelAndView;
    }

}
