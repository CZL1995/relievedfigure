package com.ccc.service.serviceImpl;

import com.ccc.dao.TestProcDao;
import com.ccc.model.TestProc;
import com.ccc.service.TestProcService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
@Service("testProcService")
public class TestProServiceImpl  implements TestProcService{

    @Autowired
    private TestProcDao procDao;


    @Override
    public List<TestProc> getProc(Map<String,Object> map) {
        List<TestProc> testProcList=new ArrayList<>();
        testProcList=procDao.getProc(map);



        return testProcList;
    }
}
