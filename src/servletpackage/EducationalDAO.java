package servletpackage;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import beanDemo1.educationalInfo;
import beanDemo1.moreInfo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EducationalDAO extends HttpServlet{
	
	private educationalInfo eduinfo=null;
	private Connection connection=null;
	
	/**
	 * @return eduinfo
	 */
	public educationalInfo getEduinfo() {
		return eduinfo;
	}

	/**
	 * @param eduinfo 要设置的 eduinfo
	 */
	public void setEduinfo(educationalInfo eduinfo) {
		this.eduinfo = eduinfo;
	}

	public boolean qurey(String username){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("select * from educationalInfo where username=?;");
			pre.setString(1, username);
			ResultSet resultSet=pre.executeQuery();
			if(resultSet.next()){
				flag=true;
				eduinfo=new educationalInfo();
				eduinfo.setAlgorithm(resultSet.getString("algorithm"));
				eduinfo.setAndroid(resultSet.getString("android"));
				eduinfo.setDatabase(resultSet.getString("database1"));
				eduinfo.setDatastruct(resultSet.getString("datastruct"));
				eduinfo.setEnglish1(resultSet.getString("english1"));
				eduinfo.setEnglish2(resultSet.getString("english2"));
				eduinfo.setEnglish3(resultSet.getString("english3"));
				eduinfo.setEnglish4(resultSet.getString("english4"));
				eduinfo.setInternet(resultSet.getString("internet"));
				eduinfo.setiOS(resultSet.getString("iOS"));
				eduinfo.setMajor(resultSet.getString("major"));
				eduinfo.setMath1(resultSet.getString("math1"));
				eduinfo.setMath2(resultSet.getString("math2"));
				eduinfo.setName(resultSet.getString("name"));
				eduinfo.setNumber(resultSet.getString("number"));
				eduinfo.setOs(resultSet.getString("os"));
				eduinfo.setPhysical1(resultSet.getString("physical1"));
				eduinfo.setPhysical2(resultSet.getString("physical2"));
				eduinfo.setUsername(resultSet.getString("username"));
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
	
	public boolean insert(educationalInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("insert into educationalInfo (algorithm,android,database1,datastruct,english1,english2,english3,english4,internet,iOS,major,math1,math2,name,number,os,physical1,physical2,username)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			pre.setString(1,info.getAlgorithm());
			pre.setString(2,info.getAndroid());
			pre.setString(3,info.getDatabase());
			pre.setString(4,info.getDatastruct());
			pre.setString(5,info.getEnglish1());
			pre.setString(6,info.getEnglish2());
			pre.setString(7,info.getEnglish3());
			pre.setString(8,info.getEnglish4());
			pre.setString(9,info.getInternet());
			pre.setString(10,info.getiOS());
			pre.setString(11,info.getMajor());
			pre.setString(12,info.getMath1());
			pre.setString(13,info.getMath2());
			pre.setString(14,info.getName());
			pre.setString(15,info.getNumber());
			pre.setString(16,info.getOs());
			pre.setString(17,info.getPhysical1());
			pre.setString(18,info.getPhysical2());
			pre.setString(19,info.getUsername());
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
	
	public boolean Update(educationalInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("update educationalInfo set algorithm=?,android=?,database1=?,datastruct=?,english1=?,english2=?,english3=?,english4=?,internet=?,iOS=?,major=?,math1=?,math2=?,name=?,number=?,os=?,physical1=?,physical2=? where username=?;");
			pre.setString(1,info.getAlgorithm());
			pre.setString(2,info.getAndroid());
			pre.setString(3,info.getDatabase());
			pre.setString(4,info.getDatastruct());
			pre.setString(5,info.getEnglish1());
			pre.setString(6,info.getEnglish2());
			pre.setString(7,info.getEnglish3());
			pre.setString(8,info.getEnglish4());
			pre.setString(9,info.getInternet());
			pre.setString(10,info.getiOS());
			pre.setString(11,info.getMajor());
			pre.setString(12,info.getMath1());
			pre.setString(13,info.getMath2());
			pre.setString(14,info.getName());
			pre.setString(15,info.getNumber());
			pre.setString(16,info.getOs());
			pre.setString(17,info.getPhysical1());
			pre.setString(18,info.getPhysical2());
			pre.setString(19,info.getUsername());
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

}
