package cn.justin.ziwu.server.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestResult {

    @JsonProperty("code")
    private int code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("result")
    private Object result;

    private RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    private RestResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RestResult setResult(Object result) {
        this.result = result;
        return this;
    }

    public static RestResult generateResult(RestResultCode restResultCode) {
        return new RestResult().setCode(restResultCode.getCode()).setMsg(restResultCode.getMessage());
    }

    static public RestResult success() {
        return new RestResult().setCode(RestResultCode.CODE_SUCCESS.getCode());
    }

    public static RestResult success(Object o) {
        return new RestResult().setCode(RestResultCode.CODE_SUCCESS.getCode()).setResult(o);
    }
}
