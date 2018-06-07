package com.xiaojun.yiliaoxitong.beans;

/**
 * Created by Administrator on 2018/3/6.
 */

public class SheBeiBean {

    /**
     * data : {"id":3,"serial_number":"5bd7a17de172b4434e988bd4d43d2328","user_id":2,"action":"绑定","status":true,"create_time":"2018-02-03 03:16:38"}
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
         * id : 3
         * serial_number : 5bd7a17de172b4434e988bd4d43d2328
         * user_id : 2
         * action : 绑定
         * status : true
         * create_time : 2018-02-03 03:16:38
         */

        private int id;
        private String serial_number;
        private int user_id;
        private String action;
        private boolean status;
        private String create_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSerial_number() {
            return serial_number;
        }

        public void setSerial_number(String serial_number) {
            this.serial_number = serial_number;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }

    @Override
    public String toString() {
        return "SheBeiBean{" +
                "data=" + data +
                ", error_code=" + error_code +
                ", error_msg='" + error_msg + '\'' +
                '}';
    }
}
