package com.gupaoedu.vip.pattern.template.jdbc;

import com.gupaoedu.vip.pattern.template.jdbc.dao.MemberDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.executor.BaseExecutor;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 * Created by Tom.
 */
public class MemberDaoTest {

    public static void main(String[] args) {
        ComboPooledDataSource ds = new ComboPooledDataSource();


        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/editortest");

            ds.setUser("root");

            ds.setPassword("123456");

            ds.setMaxPoolSize(20);

            ds.setInitialPoolSize(10);

            ds.setMaxIdleTime(2000);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
