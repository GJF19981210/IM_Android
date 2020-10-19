package com.sk.weichat.bean.event;

public class EventObject {

    public int type;
    public Object obj;

    public EventObject(int type) {
        this.type = type;
    }

    public EventObject(int type, Object obj) {
        this.type = type;
        this.obj = obj;
    }
}
