package cn.flyaudio.otasdk.data;

public class BaseResp<T> {
    /**
     * 业务消息
     */
    private String msg ;
    /**
     * 业务数据
     */
    private T data;
    /**
     * 业务编码
     */
    private int code;

    public BaseResp(String msg, T data, int code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseResp{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }
}
