package com.ccc.controller;

import com.ccc.service.TestProcService;
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
import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
@Controller
@RequestMapping("/proc")
public class TestProcController {

    private final static Logger logger = Logger.getLogger(UserController.class);


    @Resource
    private TestProcService testProcService;

    @RequestMapping("/testproc")
    @ResponseBody
    public Map<String ,Object> selectUser()  {
        Map<String,Object> map =new HashMap<>();
        map.put("P_IN1",1);
        map.put("P_IN2",2);
        testProcService.getProc(map);
        //logger.info(map.get("P_OUT2")+"-----------------------------------------------------------");
        //ModelAndView modelAndView=new ModelAndView("1");
        //modelAndView.addObject("id", map.get("P_OUT1"));
        //modelAndView.addObject("name",map.get("P_OUT2"));
        return map;
    }
}
