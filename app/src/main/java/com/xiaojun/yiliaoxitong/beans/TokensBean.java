package com.xiaojun.yiliaoxitong.beans;

/**
 * Created by Administrator on 2018/1/8.
 */

public class TokensBean {

    /**
     * access_token : ijMOW6C2EktKTMDLPDNSclRxxTbDuAkoMD5Mxj5bHjDxU7ettuO8rMr5frebfPrk-eZb1E-7SxDCJog1lMP-5E8DEYIQqW8bROHOOsCd30etIesQ3t_VOeTUa9wliZ0YXtGtiSOP6ALKT3VmYKzSicI2FOvVyYyAd5Tg_AHXGfN0uBxFbv-kGVBYO_f3ULmTeO0TkSLDfRPRYWrZL_iN3vgPNyhsYa3SmKp8OvkgoATUZebYZ0K8eqjzrM6-sToUh8Zo3XmLdnRrGVAUvB1YF-limK--873H9kJ956BI-Ow
     * token_type : bearer
     * expires_in : 86399
     */

    private String access_token;
    private String token_type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
