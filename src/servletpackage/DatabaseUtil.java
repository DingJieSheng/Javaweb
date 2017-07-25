package servletpackage;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseUtil {
	
	private static Connection conn=null;
	private static String driverName="com.mysql.jdbc.Driver";
    private static String userName="SDJ";
	private static String userPassword="sdj808545365";
	private static String url="jdbc:mysql://127.0.0.1:3306/webproject";
	private static boolean loadflag=false;
	
	public DatabaseUtil(){
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * @return conn
	 */
	public static Connection getConn() {
		try {
			if(!loadflag){
				Class.forName(driverName);
				loadflag=true;
			}
			conn=(Connection) DriverManager.getConnection(url, userName, userPassword);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
;		return conn;
	}

	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	

}
