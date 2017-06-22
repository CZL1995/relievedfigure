package com.ccc.dao;

import com.ccc.model.TestProc;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
@Repository
public interface TestProcDao {
    List<TestProc> getProc(Map<String,Object> map);
}
