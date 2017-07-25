package servletpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beanDemo1.managerInfo;
import beanDemo1.personInfo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ManagerDAO {
	private managerInfo minfo=null;
	private Connection connection=null;
	private ArrayList<personInfo> students=new ArrayList<>();
	
    public boolean qureyall(){
    	boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("select * from personInfo;");
			ResultSet resultSet=pre.executeQuery();
			while(resultSet.next()){
				flag=true;
				personInfo pinfo=new personInfo();
				pinfo.setAge(resultSet.getString("age"));
				pinfo.setName(resultSet.getString("name"));
				pinfo.setHome(resultSet.getString("home"));
				pinfo.setLocal(resultSet.getString("local"));
				pinfo.setPeople(resultSet.getString("people"));
				pinfo.setPhonenumber(resultSet.getString("phonenumber"));
				pinfo.setSexy(resultSet.getString("sexy"));
				pinfo.setStatus(resultSet.getString("status"));
				pinfo.setUsername(resultSet.getString("username"));
				students.add(pinfo);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return flag;
    }
    
    
	public boolean qurey(String username){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("select * from managerInfo where managername=?;");
			pre.setString(1, username);
			ResultSet resultSet=pre.executeQuery();
			if(resultSet.next()){
				flag=true;
				minfo=new managerInfo();
				minfo.setName(resultSet.getString("managername"));
				minfo.setPsw(resultSet.getString("password"));
//				--------------------------------------------------------------------------------------------------------------------
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public boolean insert(managerInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("insert into managerInfo(managername,password)values(?,?);");
			pre.setString(1, info.getName());
			pre.setString(2, info.getPsw());
			if(!(pre.executeUpdate()<0)){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return flag;
	}


	/**
	 * @return students
	 */
	public ArrayList<personInfo> getStudents() {
		return students;
	}


	/**
	 * @param students 要设置的 students
	 */
	public void setStudents(ArrayList<personInfo> students) {
		this.students = students;
	}


	/**
	 * @return minfo
	 */
	public managerInfo getMinfo() {
		return minfo;
	}


	/**
	 * @param minfo 要设置的 minfo
	 */
	public void setMinfo(managerInfo minfo) {
		this.minfo = minfo;
	}
	
	

}
