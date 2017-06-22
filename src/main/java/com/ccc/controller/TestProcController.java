package com.ccc.controller;

import com.ccc.model.TestProc;
import com.ccc.model.User;
import com.ccc.service.TestProcService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/proc")
public class TestProcController {
    @Resource
    private TestProcService testProcService;

    @RequestMapping("/testproc")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //request.setCharacterEncoding("UTF-8");
        //response.setCharacterEncoding("UTF-8");
        //int userId = Integer.parseLong(request.getParameter("id"));
       ///List<TestProc> testProcList = this.testProcService.getProc(1,2);
        //Map<String,Object> map =new HashMap<>();
        //map.put("P_IN1",1);
        //map.put("P_IN2",2);
        //List<TestProc> testProcList= testProcService.getProc(map);
        //System.out.println(map.get("P_OUT1"));
        //System.out.println(map.get("P_OUT2"));
        // ObjectMapper mapper = new ObjectMapper();
        //response.getWriter().write(mapper.writeValueAsString(user));
        //response.getWriter().close();
    }
}
