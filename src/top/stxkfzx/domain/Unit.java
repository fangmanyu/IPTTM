package top.stxkfzx.domain;

import java.util.Date;

/**
 * 账务信息表对应javabean
 * @author fmy
 *
 */
public class Unit {

	private String unid;
	private String unstate;
	private String unname;
	private double unspent;
	/**
	 * 登录时间
	 */
	private Date undengtime;
	/**
	 * 退出时间
	 */
	private Date untuitime;
	public String getUnid() {
		return unid;
	}
	public void setUnid(String unid) {
		this.unid = unid;
	}
	public String getUnstate() {
		return unstate;
	}
	public void setUnstate(String unstate) {
		this.unstate = unstate;
	}
	public String getUnname() {
		return unname;
	}
	public void setUnname(String unname) {
		this.unname = unname;
	}
	public double getUnspent() {
		return unspent;
	}
	public void setUnspent(double unspent) {
		this.unspent = unspent;
	}
	public Date getUndengtime() {
		return undengtime;
	}
	public void setUndengtime(Date undengtime) {
		this.undengtime = undengtime;
	}
	public Date getUntuitime() {
		return untuitime;
	}
	public void setUntuitime(Date untuitime) {
		this.untuitime = untuitime;
	}
	
	
	
}
