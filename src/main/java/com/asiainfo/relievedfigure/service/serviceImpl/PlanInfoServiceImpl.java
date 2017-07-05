package com.asiainfo.relievedfigure.service.serviceImpl;

import com.asiainfo.relievedfigure.dao.PlanInfoDao;
import com.asiainfo.relievedfigure.model.PlanInfo;
import com.asiainfo.relievedfigure.service.PlanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Caozl on 2017-07-04.
 */
@Service("planInfoService")
public class PlanInfoServiceImpl implements PlanInfoService{

    @Autowired
    private PlanInfoDao planInfoDao;

    @Override
    public boolean insertPlanInfo(PlanInfo planInfo) {
        planInfoDao.insertPlanInfo(planInfo);

        return false;
    }
}
