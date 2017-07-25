package servletpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beanDemo1.personInfo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PersonDAO {
	
	private personInfo pinfo=null;
	private Connection connection=null;
	private ArrayList<personInfo> students=new ArrayList<>();
	
	
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
	 * @return pinfo
	 */
	public personInfo getPinfo() {
		return pinfo;
	}

	/**
	 * @param pinfo 要设置的 pinfo
	 */
	public void setPinfo(personInfo pinfo) {
		this.pinfo = pinfo;
	}

    
	public boolean qurey(String username){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("select * from personInfo where username=?;");
			pre.setString(1, username);
			ResultSet resultSet=pre.executeQuery();
			if(resultSet.next()){
				flag=true;
				pinfo=new personInfo();
				pinfo.setAge(resultSet.getString("age"));
				pinfo.setName(resultSet.getString("name"));
				pinfo.setHome(resultSet.getString("home"));
				pinfo.setLocal(resultSet.getString("local"));
				pinfo.setPeople(resultSet.getString("people"));
				pinfo.setPhonenumber(resultSet.getString("phonenumber"));
				pinfo.setSexy(resultSet.getString("sexy"));
				pinfo.setStatus(resultSet.getString("status"));
				pinfo.setUsername(resultSet.getString("username"));
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
	
	public boolean insert(personInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("insert into personInfo (username,name,age,home,local,people,status,phonenumber,sexy)values(?,?,?,?,?,?,?,?,?);");
			pre.setString(1,info.getUsername());
			pre.setString(2,info.getName());
			pre.setString(3,info.getAge());
			pre.setString(4,info.getHome());
			pre.setString(5,info.getLocal());
			pre.setString(6,info.getPeople());
			pre.setString(7,info.getStatus());
			pre.setString(8,info.getPhonenumber());
			pre.setString(9,info.getSexy());
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
	
	public boolean Update(personInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("update personInfo set name=?,age=?,home=?,local=?,people=?,status=?,phonenumber=?,sexy=? where username= ?;");
			pre.setString(1,info.getName());
			pre.setString(2,info.getAge());
			pre.setString(3,info.getHome());
			pre.setString(4,info.getLocal());
			pre.setString(5,info.getPeople());
			pre.setString(6,info.getStatus());
			pre.setString(7,info.getPhonenumber());
			pre.setString(8,info.getSexy());
			pre.setString(9,info.getUsername());
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
	
	public boolean itemQurey(personInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("select * from personInfo where name like ? and age like ? and home like ? and local like ? and people like ? and status like ? and phonenumber like ? and sexy like ? and username like ?;");
			pre.setString(1,info.getName().isEmpty()?"%":info.getName());
			pre.setString(2,info.getAge().isEmpty()?"%":info.getAge());
			pre.setString(3,info.getHome().isEmpty()?"%":info.getHome());
			pre.setString(4,info.getLocal().isEmpty()?"%":info.getLocal());
			pre.setString(5,info.getPeople().isEmpty()?"%":info.getPeople());
			pre.setString(6,info.getStatus().isEmpty()?"%":info.getStatus());
			pre.setString(7,info.getPhonenumber().isEmpty()?"%":info.getPhonenumber());
			pre.setString(8,info.getSexy().isEmpty()?"%":info.getSexy());
			pre.setString(9,info.getUsername().isEmpty()?"%":info.getUsername());
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
	
	public boolean itemDelete(personInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre = (PreparedStatement) connection
					.prepareStatement("delete personInfo,userInfo,educationalInfo,moreInfo from personInfo,userInfo,educationalInfo,moreInfo where personinfo.username=userinfo.username and personinfo.username=moreinfo.username and personinfo.username=educationalinfo.username and personinfo.name like ? and personinfo.age like ? and personinfo.home like ? and personinfo.local like ? and personinfo.people like ? and personinfo.status like ? and personinfo.phonenumber like ? and personinfo.sexy like ? and personinfo.username like ?;");
			pre.setString(1,info.getName().isEmpty()?"%":info.getName());
			pre.setString(2,info.getAge().isEmpty()?"%":info.getAge());
			pre.setString(3,info.getHome().isEmpty()?"%":info.getHome());
			pre.setString(4,info.getLocal().isEmpty()?"%":info.getLocal());
			pre.setString(5,info.getPeople().isEmpty()?"%":info.getPeople());
			pre.setString(6,info.getStatus().isEmpty()?"%":info.getStatus());
			pre.setString(7,info.getPhonenumber().isEmpty()?"%":info.getPhonenumber());
			pre.setString(8,info.getSexy().isEmpty()?"%":info.getSexy());
			pre.setString(9,info.getUsername().isEmpty()?"%":info.getUsername());
			if(pre.execute()){
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
	
}
