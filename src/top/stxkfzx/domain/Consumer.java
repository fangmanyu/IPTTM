package top.stxkfzx.domain;

import java.util.Date;

/**
 * 顾客用户表对应的javabean
 *
 * @author fmy
 */
public class Consumer {

    /**
     * 用户名
     */
    private String cid;
    private String cpassword;
    private String cname;
    /**
     * 付款方式
     */
    private String cmethod;
    private String cjob;
    private String ccompany;
    private String cprovince;
    private String ctelephone;
    private String cmail;
    /**
     * 公司邮箱
     */
    private String cmail2;
    private String cpost;
    private String cstate;
    private String csex;
    private Date cdate;


    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCmethod() {
        return cmethod;
    }

    public void setCmethod(String cmethod) {
        this.cmethod = cmethod;
    }

    public String getCjob() {
        return cjob;
    }

    public void setCjob(String cjob) {
        this.cjob = cjob;
    }

    public String getCcompany() {
        return ccompany;
    }

    public void setCcompany(String ccompany) {
        this.ccompany = ccompany;
    }

    public String getCprovince() {
        return cprovince;
    }

    public void setCprovince(String cprovince) {
        this.cprovince = cprovince;
    }

    public String getCtelephone() {
        return ctelephone;
    }

    public void setCtelephone(String ctelephone) {
        this.ctelephone = ctelephone;
    }

    public String getCmail() {
        return cmail;
    }

    public void setCmail(String cmail) {
        this.cmail = cmail;
    }

    public String getCmail2() {
        return cmail2;
    }

    public void setCmail2(String cmail2) {
        this.cmail2 = cmail2;
    }

    public String getCpost() {
        return cpost;
    }

    public void setCpost(String cpost) {
        this.cpost = cpost;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "cid='" + cid + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", cname='" + cname + '\'' +
                ", cmethod='" + cmethod + '\'' +
                ", cjob='" + cjob + '\'' +
                ", ccompany='" + ccompany + '\'' +
                ", cprovince='" + cprovince + '\'' +
                ", ctelephone='" + ctelephone + '\'' +
                ", cmail='" + cmail + '\'' +
                ", cmail2='" + cmail2 + '\'' +
                ", cpost='" + cpost + '\'' +
                ", cstate='" + cstate + '\'' +
                ", csex='" + csex + '\'' +
                ", cdate=" + cdate +
                '}';
    }
}
