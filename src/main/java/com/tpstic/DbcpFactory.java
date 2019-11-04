import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DbcpFactory {
    public static Connection conn;
    public static void init() throws Exception, IOException{
        Properties pps = new Properties();
        pps.load(new FileReader("dbcp.properties"));
        BasicDataSourceFactory factory = new BasicDataSourceFactory();
        DataSource Source = factory.createDataSource(pps);
        conn = Source.getConnection();
    }

    public static void main(String[] args) {
        Connection con  = conn; 
        try {
            PreparedStatement ps =con.prepareStatement("select * from huhu");
            ResultSet rs = ps.executeQuery();
            List li = new ArrayList();
            while(rs.next()){
                String ss = rs.getString("Sname");
                int s2 = rs.getInt("Sage");
                String result = ss +s2;
                li.add(result);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}