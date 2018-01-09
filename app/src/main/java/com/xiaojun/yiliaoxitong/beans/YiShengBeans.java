package com.xiaojun.yiliaoxitong.beans;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 */

public class YiShengBeans {


    /**
     * data : {"total":4,"rows":[{"id":4,"user_id":5,"phone_number":"13430072977","real_name":"tiger","gender":true,"nation":"hahah","birthday":"0001-01-01 12:00:00","practice_hospital":"1","department":"1","title":"123","outpatient_site":"1","clinical_expertise":"1","create_date":"2018-01-03 08:32:39"},{"id":3,"user_id":4,"phone_number":"13430072976","real_name":"test","gender":true,"nation":"1","birthday":"0001-01-01 12:00:00","practice_hospital":"1","department":"1","title":"1","outpatient_site":"1","clinical_expertise":"1","create_date":"2018-01-01 09:39:49"},{"id":2,"user_id":3,"phone_number":"13430072975","real_name":"李四","gender":true,"nation":"汉","birthday":"1991-01-01 12:00:00","practice_hospital":"测试1","department":"测试","title":"测试","outpatient_site":"测试","clinical_expertise":"测试1","create_date":"0001-01-01 12:00:00"},{"id":1,"user_id":2,"phone_number":"13430072974","real_name":"张三","gender":true,"nation":"汉族","birthday":"2010-01-03 04:00:00","practice_hospital":"火星医院","department":"心理科","title":"医生","outpatient_site":"广州","clinical_expertise":"xx","create_date":"2017-12-31 11:43:57"}]}
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
         * total : 4
         * rows : [{"id":4,"user_id":5,"phone_number":"13430072977","real_name":"tiger","gender":true,"nation":"hahah","birthday":"0001-01-01 12:00:00","practice_hospital":"1","department":"1","title":"123","outpatient_site":"1","clinical_expertise":"1","create_date":"2018-01-03 08:32:39"},{"id":3,"user_id":4,"phone_number":"13430072976","real_name":"test","gender":true,"nation":"1","birthday":"0001-01-01 12:00:00","practice_hospital":"1","department":"1","title":"1","outpatient_site":"1","clinical_expertise":"1","create_date":"2018-01-01 09:39:49"},{"id":2,"user_id":3,"phone_number":"13430072975","real_name":"李四","gender":true,"nation":"汉","birthday":"1991-01-01 12:00:00","practice_hospital":"测试1","department":"测试","title":"测试","outpatient_site":"测试","clinical_expertise":"测试1","create_date":"0001-01-01 12:00:00"},{"id":1,"user_id":2,"phone_number":"13430072974","real_name":"张三","gender":true,"nation":"汉族","birthday":"2010-01-03 04:00:00","practice_hospital":"火星医院","department":"心理科","title":"医生","outpatient_site":"广州","clinical_expertise":"xx","create_date":"2017-12-31 11:43:57"}]
         */

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 4
             * user_id : 5
             * phone_number : 13430072977
             * real_name : tiger
             * gender : true
             * nation : hahah
             * birthday : 0001-01-01 12:00:00
             * practice_hospital : 1
             * department : 1
             * title : 123
             * outpatient_site : 1
             * clinical_expertise : 1
             * create_date : 2018-01-03 08:32:39
             */

            private int id;
            private int user_id;
            private String phone_number;
            private String real_name;
            private boolean gender;
            private String nation;
            private String birthday;
            private String practice_hospital;
            private String department;
            private String title;
            private String head_url;
            private String outpatient_site;
            private String clinical_expertise;
            private String create_date;

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

            public String getPhone_number() {
                return phone_number;
            }

            public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
            }

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public boolean isGender() {
                return gender;
            }

            public void setGender(boolean gender) {
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

            public String getCreate_date() {
                return create_date;
            }

            public void setCreate_date(String create_date) {
                this.create_date = create_date;
            }
        }
    }
}
