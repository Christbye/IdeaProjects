package org.tfm.test;

import org.junit.Test;
import org.tfm.util.DBUtil;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;


public class DBUtilTest {

    @Test
    public void testGetConn() throws Exception {
        System.out.println(DBUtil.getConn());
        System.out.println(DBUtil.getConn());
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println(DBUtil.getConn());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }, 0,1000);
    }

    @Test
    public void testBeginTransaction() throws Exception {
        DBUtil.beginTransaction();
    }

    @Test
    public void testCommit() throws Exception {
        DBUtil.commit();
    }

    @Test
    public void testRollback() throws Exception {
        DBUtil.rollback();
    }

    @Test
    public void testClose() throws Exception {
        DBUtil.close();
    }
}