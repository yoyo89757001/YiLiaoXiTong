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
    private String zhuji;
    private String username;
    private String password;
    private String token;
    private String zhuzhiyisheng;
    private String zhongduanmingcheng;
    @Generated(hash = 188629032)
    public DengLuBean(@NotNull Long id, String zhuji, String username,
            String password, String token, String zhuzhiyisheng,
            String zhongduanmingcheng) {
        this.id = id;
        this.zhuji = zhuji;
        this.username = username;
        this.password = password;
        this.token = token;
        this.zhuzhiyisheng = zhuzhiyisheng;
        this.zhongduanmingcheng = zhongduanmingcheng;
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
    public String getZhuji() {
        return this.zhuji;
    }
    public void setZhuji(String zhuji) {
        this.zhuji = zhuji;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getZhuzhiyisheng() {
        return this.zhuzhiyisheng;
    }
    public void setZhuzhiyisheng(String zhuzhiyisheng) {
        this.zhuzhiyisheng = zhuzhiyisheng;
    }
    public String getZhongduanmingcheng() {
        return this.zhongduanmingcheng;
    }
    public void setZhongduanmingcheng(String zhongduanmingcheng) {
        this.zhongduanmingcheng = zhongduanmingcheng;
    }


    
}
