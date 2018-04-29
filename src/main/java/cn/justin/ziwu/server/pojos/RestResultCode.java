package cn.justin.ziwu.server.pojos;

public enum  RestResultCode {
    CODE_SUCCESS(100000,"success"),
    CODE_EMPTY_EMAIL(10001,"empty email"),
    CODE_INVALID_PASSWORD(10002,"invalid password"),
    CODE_EMAIL_EXISTS(10003,"email exists");

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
