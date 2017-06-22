package com.ccc.service;

import com.ccc.model.TestProc;
import com.ccc.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
public interface TestProcService {
    public List<TestProc> getProc(Map<String,Object> map);

}
