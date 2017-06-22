package com.ccc.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by Caozl on 2017-06-20.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {



    @Override
    protected Object determineCurrentLookupKey() {

        String data="dataSource1";
        Process p = null;
        try {

            p = new ProcessBuilder("mysqladmin","-h132.168.22.81","-uroot","-p1qaz2wsx","ping").start();
            byte[] b = new byte[1024];
            int readbytes = -1;
            StringBuffer sb = new StringBuffer();
            //读取进程输出值
            //在JAVA IO中,输入输出是针对JVM而言,读写是针对外部数据源而言
            InputStream in = p.getInputStream();

            while((readbytes = in.read(b)) != -1){
                sb.append(new String(b,0,readbytes));
            }
            in.close();
        } catch (IOException e) {
            data="dataSource";
        }
        return data;
    }





}
