package beanDemo1;

public class personInfo {
	 private String username;
	 private String name;
     private String age;
     private String local;
     private String people;
     private String sexy;
     private String status;
     private String home;
     private String phonenumber;
     private String errorInfo;
     /**
 	 * @return username
 	 */
 	public String getUsername() {
 		return username;
 	}
 	/**
 	 * @param username 要设置的 username
 	 */
 	public void setUsername(String username) {
 		this.username = username;
 	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age 要设置的 age
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return local
	 */
	public String getLocal() {
		return local;
	}
	/**
	 * @param local 要设置的 local
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	/**
	 * @return people
	 */
	public String getPeople() {
		return people;
	}
	/**
	 * @param people 要设置的 people
	 */
	public void setPeople(String people) {
		this.people = people;
	}
	/**
	 * @return sexy
	 */
	public String getSexy() {
		return sexy;
	}
	/**
	 * @param sexy 要设置的 sexy
	 */
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status 要设置的 status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return home
	 */
	public String getHome() {
		return home;
	}
	/**
	 * @param home 要设置的 home
	 */
	public void setHome(String home) {
		this.home = home;
	}
	/**
	 * @return phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber 要设置的 phonenumber
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return errorInfo
	 */
	public String getErrorInfo() {
		return errorInfo;
	}
	/**
	 * @param errorInfo 要设置的 errorInfo
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public boolean checkInfo(){
		boolean flag=true;
		if(this.name==null||this.age==null||this.home==null||this.local==null||this.people==null||this.phonenumber==null||this.sexy==null||this.status==null){
			flag=false;
			errorInfo=new String("个人信息填写不完善，请重新填写！");
		}else if(!age.matches("\\d+")||Integer.parseInt(age)<=0||Integer.parseInt(age)>=130){
			flag=false;
			errorInfo=new String("年龄输入有误，请重新填写！");
			age="";
		}else if(!phonenumber.matches("1\\d{10}")){
			flag=false;
			errorInfo=new String("电话号码输入有误，请重新填写！");
			phonenumber="";
		}else if(!sexy.matches("[男|女]")){
			flag=false;
			errorInfo=new String("性别输入有误，请重新填写！");
			sexy="";
		}
		else if(!status.matches("(群众|共青团员|党员|预备党员)")){
			flag=false;
			errorInfo=new String("政治面貌有误，请重新填写！");
			status="";
		}
		return flag;
	}
}
