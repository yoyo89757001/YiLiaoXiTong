package com.xiaojun.yiliaoxitong.beans;

import java.util.List;

/**
 * Created by Administrator on 2018/2/24.
 */

public class DeFenBean {


    /**
     * data : {"total":1,"rows":[{"id":20,"user_id":5,"phone_number":"13488888888","real_name":"张三","report_name":"贝克焦虑量表(BAI)","start_time":"2018-02-09 10:10:14","consume_time":0,"report_url":"http://guangzhou.psychicspet.com/index.php/User/Report/scoreReport/recordId/15/user_id/5","report_out":null}]}
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
         * total : 1
         * rows : [{"id":20,"user_id":5,"phone_number":"13488888888","real_name":"张三","report_name":"贝克焦虑量表(BAI)","start_time":"2018-02-09 10:10:14","consume_time":0,"report_url":"http://guangzhou.psychicspet.com/index.php/User/Report/scoreReport/recordId/15/user_id/5","report_out":null}]
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
             * id : 20
             * user_id : 5
             * phone_number : 13488888888
             * real_name : 张三
             * report_name : 贝克焦虑量表(BAI)
             * start_time : 2018-02-09 10:10:14
             * consume_time : 0
             * report_url : http://guangzhou.psychicspet.com/index.php/User/Report/scoreReport/recordId/15/user_id/5
             * report_out : null
             */

            private int id;
            private int user_id;
            private String phone_number;
            private String real_name;
            private String report_name;
            private String start_time;
            private int consume_time;
            private String report_url;
            private Object report_out;

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

            public String getReport_name() {
                return report_name;
            }

            public void setReport_name(String report_name) {
                this.report_name = report_name;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public int getConsume_time() {
                return consume_time;
            }

            public void setConsume_time(int consume_time) {
                this.consume_time = consume_time;
            }

            public String getReport_url() {
                return report_url;
            }

            public void setReport_url(String report_url) {
                this.report_url = report_url;
            }

            public Object getReport_out() {
                return report_out;
            }

            public void setReport_out(Object report_out) {
                this.report_out = report_out;
            }
        }
    }
}
