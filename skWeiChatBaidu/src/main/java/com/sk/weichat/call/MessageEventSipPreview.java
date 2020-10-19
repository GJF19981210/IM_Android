package com.sk.weichat.call;


import com.sk.weichat.bean.Friend;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class MessageEventSipPreview {
    public final int number;
    public final String userid;
    public final boolean isvoice;
    public final Friend friend;

    public MessageEventSipPreview(int number, String userid, boolean isvoice, Friend friend) {
        this.number = number;
        this.userid = userid;
        this.isvoice = isvoice;
        this.friend = friend;
    }
}