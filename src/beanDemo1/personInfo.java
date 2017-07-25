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
 	 * @param username Ҫ���õ� username
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
	 * @param name Ҫ���õ� name
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
	 * @param age Ҫ���õ� age
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
	 * @param local Ҫ���õ� local
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
	 * @param people Ҫ���õ� people
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
	 * @param sexy Ҫ���õ� sexy
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
	 * @param status Ҫ���õ� status
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
	 * @param home Ҫ���õ� home
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
	 * @param phonenumber Ҫ���õ� phonenumber
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
	 * @param errorInfo Ҫ���õ� errorInfo
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public boolean checkInfo(){
		boolean flag=true;
		if(this.name==null||this.age==null||this.home==null||this.local==null||this.people==null||this.phonenumber==null||this.sexy==null||this.status==null){
			flag=false;
			errorInfo=new String("������Ϣ��д�����ƣ���������д��");
		}else if(!age.matches("\\d+")||Integer.parseInt(age)<=0||Integer.parseInt(age)>=130){
			flag=false;
			errorInfo=new String("��������������������д��");
			age="";
		}else if(!phonenumber.matches("1\\d{10}")){
			flag=false;
			errorInfo=new String("�绰��������������������д��");
			phonenumber="";
		}else if(!sexy.matches("[��|Ů]")){
			flag=false;
			errorInfo=new String("�Ա�����������������д��");
			sexy="";
		}
		else if(!status.matches("(Ⱥ��|������Ա|��Ա|Ԥ����Ա)")){
			flag=false;
			errorInfo=new String("������ò������������д��");
			status="";
		}
		return flag;
	}
}
