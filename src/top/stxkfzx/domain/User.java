package top.stxkfzx.domain;

import java.util.Date;

/**
 * 管理用户信息表对应的javabean
 * @author fmy
 *
 */
public class User {

	private int uid;
	private String uname;
	private String usex;
	private String upassword;
	private String utelephone;
	private String uemail;
	private Date udate;
	/**
	 * 权限
	 */
	private String uauthority;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public String getUauthority() {
		return uauthority;
	}
	public void setUauthority(String uauthority) {
		this.uauthority = uauthority;
	}
	
	
}
