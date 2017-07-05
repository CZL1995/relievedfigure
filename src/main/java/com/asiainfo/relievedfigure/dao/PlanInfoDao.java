package com.asiainfo.relievedfigure.dao;

import com.asiainfo.relievedfigure.model.PlanInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Caozl on 2017-07-04.
 */
@Repository
public interface PlanInfoDao {
    boolean insertPlanInfo(PlanInfo planInfo);
}
