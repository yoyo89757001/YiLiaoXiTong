package com.xiaojun.yiliaoxitong.beans;

import java.util.List;

/**
 * Created by Administrator on 2018/2/9.
 */

public class LiangBiaoBean {


    /**
     * data : {"guages":{"total":2,"rows":[{"id":1,"user_id":5,"guage_id":"A001","inventory_name":"贝克焦虑量表(BAI)","create_time":"2018/1/30 17:56:37"},{"id":2,"user_id":5,"guage_id":"A001","inventory_name":"贝克焦虑量表(BAI)","create_time":"2018/1/30 17:56:37"}]}}
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
         * guages : {"total":2,"rows":[{"id":1,"user_id":5,"guage_id":"A001","inventory_name":"贝克焦虑量表(BAI)","create_time":"2018/1/30 17:56:37"},{"id":2,"user_id":5,"guage_id":"A001","inventory_name":"贝克焦虑量表(BAI)","create_time":"2018/1/30 17:56:37"}]}
         */

        private GuagesBean guages;

        public GuagesBean getGuages() {
            return guages;
        }

        public void setGuages(GuagesBean guages) {
            this.guages = guages;
        }

        public static class GuagesBean {
            /**
             * total : 2
             * rows : [{"id":1,"user_id":5,"guage_id":"A001","inventory_name":"贝克焦虑量表(BAI)","create_time":"2018/1/30 17:56:37"},{"id":2,"user_id":5,"guage_id":"A001","inventory_name":"贝克焦虑量表(BAI)","create_time":"2018/1/30 17:56:37"}]
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
                 * id : 1
                 * user_id : 5
                 * guage_id : A001
                 * inventory_name : 贝克焦虑量表(BAI)
                 * create_time : 2018/1/30 17:56:37
                 */

                private int id;
                private int user_id;
                private String guage_id;
                private String inventory_name;
                private String create_time;
                private int status;

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
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

                public String getGuage_id() {
                    return guage_id;
                }

                public void setGuage_id(String guage_id) {
                    this.guage_id = guage_id;
                }

                public String getInventory_name() {
                    return inventory_name;
                }

                public void setInventory_name(String inventory_name) {
                    this.inventory_name = inventory_name;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }
            }
        }
    }
}
