package org.mypro.entity;

public class Chat {
    private Integer id;

    private Integer senderid;

    private String senderidentity;

    private String sendername;

    private Integer receiverid;

    private String receiveridentity;

    private String receivername;

    private String sendtime;

    private String message;

    private String isread;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public String getSenderidentity() {
        return senderidentity;
    }

    public void setSenderidentity(String senderidentity) {
        this.senderidentity = senderidentity == null ? null : senderidentity.trim();
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public String getReceiveridentity() {
        return receiveridentity;
    }

    public void setReceiveridentity(String receiveridentity) {
        this.receiveridentity = receiveridentity == null ? null : receiveridentity.trim();
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime == null ? null : sendtime.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread == null ? null : isread.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}