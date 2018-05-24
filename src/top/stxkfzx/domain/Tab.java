package top.stxkfzx.domain;
/**
 * 账户信息表对应的javabean
 * @author fmy
 *
 */
public class Tab {

	private String tid;
	private String tstate;
	private double ttime;
	private double tspent;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTstate() {
		return tstate;
	}
	public void setTstate(String tstate) {
		this.tstate = tstate;
	}
	public double getTtime() {
		return ttime;
	}
	public void setTtime(double ttime) {
		this.ttime = ttime;
	}
	public double getTspent() {
		return tspent;
	}
	public void setTspent(double tspent) {
		this.tspent = tspent;
	}
	
	
}
