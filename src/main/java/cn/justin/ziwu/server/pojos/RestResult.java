package cn.justin.ziwu.server.pojos;

public class RestResult {

    private int code;
    private String msg;
    private Object result;

    private RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    private RestResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public static RestResult generateResult(RestResultCode restResultCode) {
        return new RestResult().setCode(restResultCode.getCode()).setMsg(restResultCode.getMessage());
    }
}
