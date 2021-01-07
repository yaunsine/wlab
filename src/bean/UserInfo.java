/**
 * 
 */
package bean;

/**
 * @author Administrator
 *
 */
public class UserInfo {

	/**
	 * 
	 */
	private String username="";
	private String password="";
	private int age = 0;
	private String power = "";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public UserInfo() {
		// TODO Auto-generated constructor stub
		
	}
	public void setuser(String username,String password,int age,String power){
		setUsername(username);
		setPassword(password);
		setAge(age);
		setPower(power);
	}
	public UserInfo user(String username,String password,int age,String power){
		UserInfo user = new UserInfo();
		user.username = username;
		user.password = password;
		user.age = age;
		user.power = power;
		return user;
	}
}
