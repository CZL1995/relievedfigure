package com.ccc.base;

import org.aspectj.lang.JoinPoint;

public class DataSourceInterceptor {

	public void setdataSourceMysql(JoinPoint jp) {
		DatabaseContextHolder.setCustomerType("dataSource1");
	}
	
	public void setdataSourceOracle(JoinPoint jp) {
		DatabaseContextHolder.setCustomerType("dataSource");
	}
}