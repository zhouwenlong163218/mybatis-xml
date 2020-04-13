package com.example.mybatisxmldemo.model;

public class Message4 {

    private Integer msgId;

    private String msgText;

    private String msgSummary;

    private static final long serialVersionUID = 1L;

    public Integer getMsgId() {
        return msgId;
    }


    public Message4 withMsgId(Integer msgId) {
        this.setMsgId(msgId);
        return this;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgText() {
        return msgText;
    }

    public Message4 withMsgText(String msgText) {
        this.setMsgText(msgText);
        return this;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText == null ? null : msgText.trim();
    }

    public String getMsgSummary() {
        return msgSummary;
    }

    public Message4 withMsgSummary(String msgSummary) {
        this.setMsgSummary(msgSummary);
        return this;
    }

    public void setMsgSummary(String msgSummary) {
        this.msgSummary = msgSummary == null ? null : msgSummary.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", msgId=").append(msgId);
        sb.append(", msgText=").append(msgText);
        sb.append(", msgSummary=").append(msgSummary);
        sb.append("]");
        return sb.toString();
    }
}
