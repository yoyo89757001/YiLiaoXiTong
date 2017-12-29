package com.xiaojun.yiliaoxitong.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Administrator on 2017/10/27.
 */
@Entity
public class DengLuBean {


    /**
     * account : admin
     * admin_id : 1
     * cardNum :
     * certificate :
     * companyId : 0
     * createTime : 1505187770000
     * dtoResult : 0
     * email :
     * id : 2
     * memberNum :
     * modifyTime : 1505187770000
     * name : 管理员
     * pageNum : 0
     * pageSize : 0
     * phone : 18899994444
     * platType : 0
     * pwd :
     * remark :
     * role_id : 10000003
     * sex : 0
     * status : 1
     */
    @Id
    @NotNull
    private Long id;
    private Long userId;
    private String zhuji;
    private String account;
    private int admin_id;
    private String cardNum;
    private String certificate;
    private int companyId;
    private long createTime;
    private int dtoResult;
    private String email;
    private String memberNum;
    private long modifyTime;
    private String name;
    private int pageNum;
    private int pageSize;
    private String phone;
    private int platType;
    private String pwd;
    private String remark;
    private int role_id;
    private int sex;
    private int status;
    private String qqTime;
    private String mima;
    private String company;
    @Generated(hash = 828277090)
    public DengLuBean(@NotNull Long id, Long userId, String zhuji, String account,
                      int admin_id, String cardNum, String certificate, int companyId,
                      long createTime, int dtoResult, String email, String memberNum,
                      long modifyTime, String name, int pageNum, int pageSize, String phone,
                      int platType, String pwd, String remark, int role_id, int sex,
                      int status, String qqTime, String mima, String company) {
        this.id = id;
        this.userId = userId;
        this.zhuji = zhuji;
        this.account = account;
        this.admin_id = admin_id;
        this.cardNum = cardNum;
        this.certificate = certificate;
        this.companyId = companyId;
        this.createTime = createTime;
        this.dtoResult = dtoResult;
        this.email = email;
        this.memberNum = memberNum;
        this.modifyTime = modifyTime;
        this.name = name;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.phone = phone;
        this.platType = platType;
        this.pwd = pwd;
        this.remark = remark;
        this.role_id = role_id;
        this.sex = sex;
        this.status = status;
        this.qqTime = qqTime;
        this.mima = mima;
        this.company = company;
    }
    @Generated(hash = 715002548)
    public DengLuBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getZhuji() {
        return this.zhuji;
    }
    public void setZhuji(String zhuji) {
        this.zhuji = zhuji;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public int getAdmin_id() {
        return this.admin_id;
    }
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
    public String getCardNum() {
        return this.cardNum;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public String getCertificate() {
        return this.certificate;
    }
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    public int getCompanyId() {
        return this.companyId;
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    public long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
    public int getDtoResult() {
        return this.dtoResult;
    }
    public void setDtoResult(int dtoResult) {
        this.dtoResult = dtoResult;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemberNum() {
        return this.memberNum;
    }
    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }
    public long getModifyTime() {
        return this.modifyTime;
    }
    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPageNum() {
        return this.pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return this.pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getPlatType() {
        return this.platType;
    }
    public void setPlatType(int platType) {
        this.platType = platType;
    }
    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public int getRole_id() {
        return this.role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    public int getSex() {
        return this.sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getQqTime() {
        return this.qqTime;
    }
    public void setQqTime(String qqTime) {
        this.qqTime = qqTime;
    }
    public String getMima() {
        return this.mima;
    }
    public void setMima(String mima) {
        this.mima = mima;
    }
    public String getCompany() {
        return this.company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    
}
