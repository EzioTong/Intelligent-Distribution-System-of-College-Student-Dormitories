package Model;

public class RegisterModel extends Student{
	private String account;
	private String password;

	public RegisterModel() {
		this.account=this.getId();
		this.password="000000";
	}
	
	public String getAccount() {
		return this.account;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return this.password;
	}
	public boolean match(String account,String password) {
		if(account.equals(this.account)&&password.equals(this.password)) {
			return true;
		}else {
			return false;
		}
	}
	
}
