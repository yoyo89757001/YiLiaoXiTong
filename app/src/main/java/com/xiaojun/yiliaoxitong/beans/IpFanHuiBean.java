package com.xiaojun.yiliaoxitong.beans;

/**
 * Created by Administrator on 2018/1/11.
 */

public class IpFanHuiBean {


    /**
     * data : {"id":7,"serial_number":"5bd7a17de172b4434e988bd4d43d2328","terminal_name":"pad111111","ip_address":"","server_ip_address":"192.192.192","status":1,"create_date":"2018-01-11 10:08:45"}
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
         * id : 7
         * serial_number : 5bd7a17de172b4434e988bd4d43d2328
         * terminal_name : pad111111
         * ip_address :
         * server_ip_address : 192.192.192
         * status : 1
         * create_date : 2018-01-11 10:08:45
         */

        private int id;
        private String serial_number;
        private String terminal_name;
        private String ip_address;
        private String server_ip_address;
        private int status;
        private String create_date;

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

        public String getTerminal_name() {
            return terminal_name;
        }

        public void setTerminal_name(String terminal_name) {
            this.terminal_name = terminal_name;
        }

        public String getIp_address() {
            return ip_address;
        }

        public void setIp_address(String ip_address) {
            this.ip_address = ip_address;
        }

        public String getServer_ip_address() {
            return server_ip_address;
        }

        public void setServer_ip_address(String server_ip_address) {
            this.server_ip_address = server_ip_address;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }
    }
}
