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
	 * @param username Ҫ���õ� username
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
	 * @param errorInfo Ҫ���õ� errorInfo
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
	 * @param number Ҫ���õ� number
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
	 * @param health Ҫ���õ� health
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
	 * @param marry Ҫ���õ� marry
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
	 * @param birth Ҫ���õ� birth
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
	 * @param education Ҫ���õ� education
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
	 * @param college Ҫ���õ� college
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
	 * @param major Ҫ���õ� major
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
	 * @param lenth Ҫ���õ� length
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
	 * @param weight Ҫ���õ� weight
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
	 * @param hobby Ҫ���õ� hobby
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
			errorInfo=new String("��Ϣ���벻���ƣ����������룡");
		}else if(!birth.matches("(\\d+\\.\\d+\\.\\d+)")){
			flag=false;
			errorInfo=new String("�����������벻��ȷ�����������룡");
			birth="";
		}else if(!education.matches("(��һ|���|����|����)")){
			flag=false;
			errorInfo=new String("�꼶��Ϣ���벻��ȷ�����������룡");
			education="";
		}else if(!health.matches("(����|����)")){
			flag=false;
			errorInfo=new String("������Ϣ���벻��ȷ�����������룡");
			health="";
		}else if(!length.matches("(\\d+\\.?\\d+)")||Double.parseDouble(length)<=30||Double.parseDouble(length)>=250){
			flag=false;
			errorInfo=new String("�����Ϣ���벻��ȷ�����������룡");
			length="";
		}else if(!number.matches("\\d+")){
			flag=false;
			errorInfo=new String("ѧ����Ϣ���벻��ȷ�����������룡");
			number="";
		}else if(!weight.matches("(\\d+\\.?\\d+)")||Double.parseDouble(weight)<=30||Double.parseDouble(weight)>=300){
			flag=false;
			errorInfo=new String("������Ϣ���벻��ȷ�����������룡");
			weight="";
		}
		return flag;
	}

}
