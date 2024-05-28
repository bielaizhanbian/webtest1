package org.mypro.entity;

/**
 * 聊天消息实体类
 */
public class Chat {
    private Integer id; // 消息ID

    private Integer senderid; // 发送者ID

    private String senderidentity; // 发送者身份

    private String sendername; // 发送者名称

    private Integer receiverid; // 接收者ID

    private String receiveridentity; // 接收者身份

    private String receivername; // 接收者名称

    private String sendtime; // 发送时间

    private String message; // 消息内容

    private String isread; // 是否已读

    private String type; // 消息类型

    /**
     * 获取消息ID
     *
     * @return 消息ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置消息ID
     *
     * @param id 消息ID
     */
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