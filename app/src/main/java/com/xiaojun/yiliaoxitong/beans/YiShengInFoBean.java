package com.xiaojun.yiliaoxitong.beans;

/**
 * Created by Administrator on 2018/1/9.
 */

public class YiShengInFoBean {

    /**
     * data : {"id":4,"user_id":5,"real_name":"tiger","gender":true,"nation":"hahah","birthday":"0001-01-01 12:00:00","practice_hospital":"1","department":"1","title":"123","outpatient_site":"1","clinical_expertise":"1"}
     * error_code : 0
     * error_msg : Sucess
     */

    private DataBean data;
    private int error_code;
    private String error_msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public static class DataBean {
        /**
         * id : 4
         * user_id : 5
         * real_name : tiger
         * gender : true
         * nation : hahah
         * birthday : 0001-01-01 12:00:00
         * practice_hospital : 1
         * department : 1
         * title : 123
         * outpatient_site : 1
         * clinical_expertise : 1
         */

        private int id;
        private int user_id;
        private String real_name;
        private String gender;
        private String head_url;
        private String nation;
        private String birthday;
        private String practice_hospital;
        private String department;
        private String title;
        private String outpatient_site;
        private String clinical_expertise;

        public String getHead_url() {
            return head_url;
        }

        public void setHead_url(String head_url) {
            this.head_url = head_url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPractice_hospital() {
            return practice_hospital;
        }

        public void setPractice_hospital(String practice_hospital) {
            this.practice_hospital = practice_hospital;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOutpatient_site() {
            return outpatient_site;
        }

        public void setOutpatient_site(String outpatient_site) {
            this.outpatient_site = outpatient_site;
        }

        public String getClinical_expertise() {
            return clinical_expertise;
        }

        public void setClinical_expertise(String clinical_expertise) {
            this.clinical_expertise = clinical_expertise;
        }
    }
}
