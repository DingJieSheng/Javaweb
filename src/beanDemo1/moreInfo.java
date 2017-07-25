package beanDemo1;

public class moreInfo {
	private String username;
	private String number;
	private String health;
	private String marry;
	private String birth;
	private String education;
	private String college;
	private String major;
	private String length;
	private String weight;
	private String hobby;
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
	/**
	 * @return number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number 要设置的 number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return health
	 */
	public String getHealth() {
		return health;
	}
	/**
	 * @param health 要设置的 health
	 */
	public void setHealth(String health) {
		this.health = health;
	}
	/**
	 * @return marry
	 */
	public String getMarry() {
		return marry;
	}
	/**
	 * @param marry 要设置的 marry
	 */
	public void setMarry(String marry) {
		this.marry = marry;
	}
	/**
	 * @return birth
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * @param birth 要设置的 birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * @return education
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * @param education 要设置的 education
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * @return college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college 要设置的 college
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major 要设置的 major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * @return length
	 */
	public String getLength() {
		return length;
	}
	/**
	 * @param lenth 要设置的 length
	 */
	public void setLength(String length) {
		this.length = length;
	}
	/**
	 * @return weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight 要设置的 weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @return hobby
	 */
	public String getHobby() {
		return hobby;
	}
	/**
	 * @param hobby 要设置的 hobby
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public boolean checkMore(){
		boolean flag=true;
		if (this.birth == null || this.college == null
				|| this.education == null || this.health == null
				|| this.hobby == null || this.length == null
				|| this.major == null || this.marry == null
				|| this.number == null || this.weight == null){
			flag=false;
			errorInfo=new String("信息输入不完善，请重新输入！");
		}else if(!birth.matches("(\\d+\\.\\d+\\.\\d+)")){
			flag=false;
			errorInfo=new String("出生日期输入不正确，请重新输入！");
			birth="";
		}else if(!education.matches("(大一|大二|大三|大四)")){
			flag=false;
			errorInfo=new String("年级信息输入不正确，请重新输入！");
			education="";
		}else if(!health.matches("(健康|患病)")){
			flag=false;
			errorInfo=new String("健康信息输入不正确，请重新输入！");
			health="";
		}else if(!length.matches("(\\d+\\.?\\d+)")||Double.parseDouble(length)<=30||Double.parseDouble(length)>=250){
			flag=false;
			errorInfo=new String("身高信息输入不正确，请重新输入！");
			length="";
		}else if(!number.matches("\\d+")){
			flag=false;
			errorInfo=new String("学号信息输入不正确，请重新输入！");
			number="";
		}else if(!weight.matches("(\\d+\\.?\\d+)")||Double.parseDouble(weight)<=30||Double.parseDouble(weight)>=300){
			flag=false;
			errorInfo=new String("体重信息输入不正确，请重新输入！");
			weight="";
		}
		return flag;
	}

}
