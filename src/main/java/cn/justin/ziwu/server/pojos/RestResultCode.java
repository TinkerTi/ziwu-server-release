package cn.justin.ziwu.server.pojos;

public enum  RestResultCode {
    CODE_EMPTY_EMAIL(1,"empty email"),
    CODE_INVALID_PASSWORD(2,"invalid password");

    private int code;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private String message;
    RestResultCode(int code,String message){
        this.code=code;
        this.message=message;
    }

}
