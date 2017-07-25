package servletpackage;

import java.sql.ResultSet;
import java.sql.SQLException;

import beanDemo1.moreInfo;
import beanDemo1.personInfo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MoreinfoDAO {
	private moreInfo minfo=null;
	private Connection connection=null;
	
	/**
	 * @return minfo
	 */
	public moreInfo getMinfo() {
		return minfo;
	}
	/**
	 * @param minfo 要设置的 minfo
	 */
	public void setMinfo(moreInfo minfo) {
		this.minfo = minfo;
	}
	
	public boolean qurey(String username){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("select * from moreInfo where username=?;");
			pre.setString(1, username);
			ResultSet resultSet=pre.executeQuery();
			if(resultSet.next()){
				flag=true;
				minfo=new moreInfo();
				minfo.setBirth(resultSet.getString("birth"));
				minfo.setCollege(resultSet.getString("college"));
				minfo.setEducation(resultSet.getString("education"));
				minfo.setHealth(resultSet.getString("health"));
				minfo.setHobby(resultSet.getString("hobby"));
				minfo.setLength(resultSet.getString("length"));
				minfo.setMajor(resultSet.getString("major"));
				minfo.setMarry(resultSet.getString("marry"));
				minfo.setNumber(resultSet.getString("number"));
				minfo.setWeight(resultSet.getString("weight"));
				minfo.setUsername(resultSet.getString("username"));
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
	
	public boolean insert(moreInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("insert into moreInfo (username,birth,college,education,health,hobby,length,major,marry,number,weight)values(?,?,?,?,?,?,?,?,?,?,?);");
			pre.setString(1,info.getUsername());
			pre.setString(2,info.getBirth());
			pre.setString(3,info.getCollege());
			pre.setString(4,info.getEducation());
			pre.setString(5,info.getHealth());
			pre.setString(6,info.getHobby());
			pre.setString(7,info.getLength());
			pre.setString(8,info.getMajor());
			pre.setString(9,info.getMarry());
			pre.setString(10,info.getNumber());
			pre.setString(11,info.getWeight());
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
	
	public boolean Update(moreInfo info){
		boolean flag=false;
		try {
			connection=DatabaseUtil.getConn();
			PreparedStatement pre=(PreparedStatement) connection.prepareStatement("update moreInfo set birth=?,college=?,education=?,health=?,hobby=?,length=?,major=?,marry=?,number=?,weight=? where username=?;");
			pre.setString(1,info.getBirth());
			pre.setString(2,info.getCollege());
			pre.setString(3,info.getEducation());
			pre.setString(4,info.getHealth());
			pre.setString(5,info.getHobby());
			pre.setString(6,info.getLength());
			pre.setString(7,info.getMajor());
			pre.setString(8,info.getMarry());
			pre.setString(9,info.getNumber());
			pre.setString(10,info.getWeight());
			pre.setString(11,info.getUsername());
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
