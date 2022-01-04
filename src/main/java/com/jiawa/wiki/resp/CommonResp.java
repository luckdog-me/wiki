package com.jiawa.wiki.resp;

/**
 * @Auther: jie
 * @Date: 2022/1/4 09:12
 * @Description:
 */
public class CommonResp<T> {

    /*
    业务上的成功或失败
     */
    private boolean success = true;
    /*
    返回信息
     */
    private String message;
    /*
    返回泛型数据，自定义类型
     */
    private T content;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getContent() {
        return content;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonResp{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
