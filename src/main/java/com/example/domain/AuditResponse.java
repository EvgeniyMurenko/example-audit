package com.example.domain;

import java.io.Serializable;
import java.util.List;

public class AuditResponse<T> implements Serializable {
    public T data;
    public Meta meta;
    public Pagination pagination;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public static class Meta implements Serializable{
        public int code;
    }

    public static class Pagination implements Serializable{
        public int total;
        public int returned;
        public String next_url;
        public String first_url;
        public String last_url;
    }
}
