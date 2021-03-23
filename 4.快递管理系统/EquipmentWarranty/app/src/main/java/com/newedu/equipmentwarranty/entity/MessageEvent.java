package com.newedu.equipmentwarranty.entity;

import android.net.Uri;

public class MessageEvent {
    private String msg;
    private Object data;
    private Uri resultUri;

    public MessageEvent() {
    }

    public MessageEvent(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public MessageEvent(String msg, Object data, Uri resultUri) {
        this.msg = msg;
        this.data = data;
        this.resultUri = resultUri;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Uri getResultUri() {
        return resultUri;
    }

    public void setResultUri(Uri resultUri) {
        this.resultUri = resultUri;
    }
}
