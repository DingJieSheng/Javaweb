package beanDemo1;

public class educationalInfo {
	private String name;
	private String major;
	private String number;
	private String math1;
	private String math2;
	private String physical1;
	private String physical2;
	private String english1;
	private String english2;
	private String english3;
	private String english4;
	private String algorithm;
	private String datastruct;
	private String database;
	private String os;
	private String iOS;
	private String android;
	private String internet;
	private String errorInfo;
	
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
	 * @return math1
	 */
	public String getMath1() {
		return math1;
	}
	/**
	 * @param math1 Ҫ���õ� math1
	 */
	public void setMath1(String math1) {
		this.math1 = math1;
	}
	/**
	 * @return math2
	 */
	public String getMath2() {
		return math2;
	}
	/**
	 * @param math2 Ҫ���õ� math2
	 */
	public void setMath2(String math2) {
		this.math2 = math2;
	}
	/**
	 * @return physical1
	 */
	public String getPhysical1() {
		return physical1;
	}
	/**
	 * @param physical1 Ҫ���õ� physical1
	 */
	public void setPhysical1(String physical1) {
		this.physical1 = physical1;
	}
	/**
	 * @return physical2
	 */
	public String getPhysical2() {
		return physical2;
	}
	/**
	 * @param physical2 Ҫ���õ� physical2
	 */
	public void setPhysical2(String physical2) {
		this.physical2 = physical2;
	}
	/**
	 * @return english1
	 */
	public String getEnglish1() {
		return english1;
	}
	/**
	 * @param english1 Ҫ���õ� english1
	 */
	public void setEnglish1(String english1) {
		this.english1 = english1;
	}
	/**
	 * @return english2
	 */
	public String getEnglish2() {
		return english2;
	}
	/**
	 * @param english2 Ҫ���õ� english2
	 */
	public void setEnglish2(String english2) {
		this.english2 = english2;
	}
	/**
	 * @return english3
	 */
	public String getEnglish3() {
		return english3;
	}
	/**
	 * @param english3 Ҫ���õ� english3
	 */
	public void setEnglish3(String english3) {
		this.english3 = english3;
	}
	/**
	 * @return english4
	 */
	public String getEnglish4() {
		return english4;
	}
	/**
	 * @param english4 Ҫ���õ� english4
	 */
	public void setEnglish4(String english4) {
		this.english4 = english4;
	}
	/**
	 * @return algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}
	/**
	 * @param algorithm Ҫ���õ� algorithm
	 */
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	/**
	 * @return datastruct
	 */
	public String getDatastruct() {
		return datastruct;
	}
	/**
	 * @param datastruct Ҫ���õ� datastruct
	 */
	public void setDatastruct(String datastruct) {
		this.datastruct = datastruct;
	}
	/**
	 * @return database
	 */
	public String getDatabase() {
		return database;
	}
	/**
	 * @param database Ҫ���õ� database
	 */
	public void setDatabase(String database) {
		this.database = database;
	}
	/**
	 * @return os
	 */
	public String getOs() {
		return os;
	}
	/**
	 * @param os Ҫ���õ� os
	 */
	public void setOs(String os) {
		this.os = os;
	}
	/**
	 * @return iOS
	 */
	public String getiOS() {
		return iOS;
	}
	/**
	 * @param iOS Ҫ���õ� iOS
	 */
	public void setiOS(String iOS) {
		this.iOS = iOS;
	}
	/**
	 * @return android
	 */
	public String getAndroid() {
		return android;
	}
	/**
	 * @param android Ҫ���õ� android
	 */
	public void setAndroid(String android) {
		this.android = android;
	}
	/**
	 * @return internet
	 */
	public String getInternet() {
		return internet;
	}
	/**
	 * @param internet Ҫ���õ� internet
	 */
	public void setInternet(String internet) {
		this.internet = internet;
	}
    
	public boolean checkeduInfo(){
		boolean flag=true;
		if (this.math1 == null || this.math2 == null
				|| this.physical1 == null || this.physical2 == null
				|| this.english1 == null || this.english2 == null
				|| this.english3 == null || this.english4 == null
				|| this.algorithm == null || this.datastruct == null
				|| this.database == null || this.os == null
				|| this.iOS == null || this.android == null
				|| this.internet == null || this.name == null
				|| this.major == null || this.number == null){
			flag=false;
			errorInfo=new String("��Ϣ���벻���ƣ����������룡");
		}else if(!math1.matches("(\\d+\\.?\\d+)")||Double.parseDouble(math1)<0||Double.parseDouble(math1)>100){
			flag=false;
			errorInfo=new String("�����ϳɼ������������������룡");
			math1="";
		}else if(!math2.matches("(\\d+\\.?\\d+)")||Double.parseDouble(math2)<0||Double.parseDouble(math2)>100){
			flag=false;
			errorInfo=new String("�����³ɼ������������������룡");
			math2="";
		}else if(!physical1.matches("(\\d+\\.?\\d+)")||Double.parseDouble(physical1)<0||Double.parseDouble(physical1)>100){
			flag=false;
			errorInfo=new String("�����ϳɼ������������������룡");
			physical1="";
		}else if(!physical2.matches("(\\d+\\.?\\d+)")||Double.parseDouble(physical2)<0||Double.parseDouble(physical2)>100){
			flag=false;
			errorInfo=new String("�����³ɼ������������������룡");
			physical2="";
		}else if(!english1.matches("(\\d+\\.?\\d+)")||Double.parseDouble(english1)<0||Double.parseDouble(english1)>100){
			flag=false;
			errorInfo=new String("Ӣ��һ�ɼ������������������룡");
			english1="";
		}else if(!english2.matches("(\\d+\\.?\\d+)")||Double.parseDouble(english2)<0||Double.parseDouble(english2)>100){
			flag=false;
			errorInfo=new String("Ӣ����ɼ������������������룡");
			english2="";
		}else if(!english3.matches("(\\d+\\.?\\d+)")||Double.parseDouble(english3)<0||Double.parseDouble(english3)>100){
			flag=false;
			errorInfo=new String("Ӣ�����ɼ������������������룡");
			english3="";
		}else if(!english4.matches("(\\d+\\.?\\d+)")||Double.parseDouble(english4)<0||Double.parseDouble(english4)>100){
			flag=false;
			errorInfo=new String("Ӣ���ĳɼ������������������룡");
			english4="";
		}else if(!algorithm.matches("(\\d+\\.?\\d+)")||Double.parseDouble(algorithm)<0||Double.parseDouble(algorithm)>100){
			flag=false;
			errorInfo=new String("�㷨�ɼ������������������룡");
			algorithm="";
		}else if(!datastruct.matches("(\\d+\\.?\\d+)")||Double.parseDouble(datastruct)<0||Double.parseDouble(datastruct)>100){
			flag=false;
			errorInfo=new String("���ݽṹ�ɼ������������������룡");
			datastruct="";
		}else if(!database.matches("(\\d+\\.?\\d+)")||Double.parseDouble(database)<0||Double.parseDouble(database)>100){
			flag=false;
			errorInfo=new String("���ݿ�ɼ������������������룡");
			database="";
		}else if(!os.matches("(\\d+\\.?\\d+)")||Double.parseDouble(os)<0||Double.parseDouble(os)>100){
			flag=false;
			errorInfo=new String("����ϵͳ�ɼ������������������룡");
			os="";
		}else if(!iOS.matches("(\\d+\\.?\\d+)")||Double.parseDouble(iOS)<0||Double.parseDouble(iOS)>100){
			flag=false;
			errorInfo=new String("iOS�ɼ������������������룡");
			iOS="";
		}else if(!android.matches("(\\d+\\.?\\d+)")||Double.parseDouble(android)<0||Double.parseDouble(android)>100){
			flag=false;
			errorInfo=new String("android�ɼ������������������룡");
			android="";
		}else if(!internet.matches("(\\d+\\.?\\d+)")||Double.parseDouble(internet)<0||Double.parseDouble(internet)>100){
			flag=false;
			errorInfo=new String("internet�ɼ������������������룡");
			internet="";
		}
		return flag;
	}
}
