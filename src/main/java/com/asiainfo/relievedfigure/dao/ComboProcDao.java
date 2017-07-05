package com.asiainfo.relievedfigure.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Caozl on 2017-06-14.
 */
@Repository
public interface ComboProcDao {
    void getProc(Map<String,Object> map);
}
