
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import lab.crazyspark.aml.BeanCfg;

public class DBUtils {
    private static ComboPooledDataSource dssrc = null;
    private static ComboPooledDataSource dstarget = null;

    static {
        dssrc = new ComboPooledDataSource("src");
        dstarget = new ComboPooledDataSource("target");
    }

    public synchronized static DataSource getDataSource(String ds) {
        if (ds.equals("src")) {
            return dssrc;
        } else {
            return dstarget;
        }
    }

    public synchronized static Connection getConnection(String ds)  {
        Connection con = null;
        try {
            if (ds.equals("src")) {
                con = dssrc.getConnection();
            } else {
                con = dstarget.getConnection();
            }
        } catch (SQLException e) {
            System.out.println("获取数据库连接失败！");
        }
        return con;
    }

    public static void closeResource(ResultSet rs, Statement stmt, Connection con)  {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("关闭资源失败！");
            // e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        System.out.println(getConnection("mysql"));
    }

    public static <T> BeanCfg GetBeanConfig(Class<T> cls, String objectname) {
        String sql = String.format("SELECT * FROM sys_bean_cfg WHERE objectname = '%s'", objectname);
        try {
            QueryRunner runner = new QueryRunner(DBUtils.getDataSource("mysql"));
            BeanCfg beanCfg = runner.query(sql, new BeanHandler<BeanCfg>(BeanCfg.class));
            return beanCfg;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}