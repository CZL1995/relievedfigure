package com.asiainfo.relievedfigure.service.serviceImpl;

import com.asiainfo.relievedfigure.dao.ComboProcDao;
import com.asiainfo.relievedfigure.service.ComboProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
@Service("testProcService")
public class ComboProcServiceImpl implements ComboProcService {

    @Autowired
    private ComboProcDao procDao;


    @Override
    public void getProc(Map<String,Object> map) {
         procDao.getProc(map);
    }
}
