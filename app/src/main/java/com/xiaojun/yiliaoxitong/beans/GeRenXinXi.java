package com.xiaojun.yiliaoxitong.beans;

/**
 * Created by Administrator on 2018/1/8.
 */

public class GeRenXinXi {

    /**
     * data : {"id":5,"case_number":"20171230113639564","real_name":"张三","gender":"男","nation":"汉族","birthday":"2018-01-08 10:27:12","vocation":"攻城狮","phone_number":"13488888888","education":"大专","password":"123","siblings":3,"raking":2,"marital_status":"否","age_of_onset":6,"email":"5258@qq.com","doctor":2,"diagnosed":"","blood_type":"o","type":"test","source":"test","province":"test","religion":"基督教","separate_beds_age":10,"father_education":"","monther_education":"","primary_rear_education":"","create_date":"2018-01-08 10:27:12"}
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
         * id : 5
         * case_number : 20171230113639564
         * real_name : 张三
         * gender : 男
         * nation : 汉族
         * birthday : 2018-01-08 10:27:12
         * vocation : 攻城狮
         * phone_number : 13488888888
         * education : 大专
         * password : 123
         * siblings : 3
         * raking : 2
         * marital_status : 否
         * age_of_onset : 6
         * email : 5258@qq.com
         * doctor : 2
         * diagnosed :
         * blood_type : o
         * type : test
         * source : test
         * province : test
         * religion : 基督教
         * separate_beds_age : 10
         * father_education :
         * monther_education :
         * primary_rear_education :
         * create_date : 2018-01-08 10:27:12
         */

        private int id;
        private String case_number;
        private String real_name;
        private String gender;
        private String nation;
        private String birthday;
        private String vocation;
        private String phone_number;
        private String education;
        private String password;
        private int siblings;
        private int raking;
        private String marital_status;
        private int age_of_onset;
        private String email;
        private int doctor;
        private String diagnosed;
        private String blood_type;
        private String type;
        private String source;
        private String province;
        private String religion;
        private int separate_beds_age;
        private String father_education;
        private String monther_education;
        private String primary_rear_education;
        private String create_date;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCase_number() {
            return case_number;
        }

        public void setCase_number(String case_number) {
            this.case_number = case_number;
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

        public String getVocation() {
            return vocation;
        }

        public void setVocation(String vocation) {
            this.vocation = vocation;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getSiblings() {
            return siblings;
        }

        public void setSiblings(int siblings) {
            this.siblings = siblings;
        }

        public int getRaking() {
            return raking;
        }

        public void setRaking(int raking) {
            this.raking = raking;
        }

        public String getMarital_status() {
            return marital_status;
        }

        public void setMarital_status(String marital_status) {
            this.marital_status = marital_status;
        }

        public int getAge_of_onset() {
            return age_of_onset;
        }

        public void setAge_of_onset(int age_of_onset) {
            this.age_of_onset = age_of_onset;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getDoctor() {
            return doctor;
        }

        public void setDoctor(int doctor) {
            this.doctor = doctor;
        }

        public String getDiagnosed() {
            return diagnosed;
        }

        public void setDiagnosed(String diagnosed) {
            this.diagnosed = diagnosed;
        }

        public String getBlood_type() {
            return blood_type;
        }

        public void setBlood_type(String blood_type) {
            this.blood_type = blood_type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public int getSeparate_beds_age() {
            return separate_beds_age;
        }

        public void setSeparate_beds_age(int separate_beds_age) {
            this.separate_beds_age = separate_beds_age;
        }

        public String getFather_education() {
            return father_education;
        }

        public void setFather_education(String father_education) {
            this.father_education = father_education;
        }

        public String getMonther_education() {
            return monther_education;
        }

        public void setMonther_education(String monther_education) {
            this.monther_education = monther_education;
        }

        public String getPrimary_rear_education() {
            return primary_rear_education;
        }

        public void setPrimary_rear_education(String primary_rear_education) {
            this.primary_rear_education = primary_rear_education;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }
    }
}
