package cn.justin.ziwu.server.pojos;

public enum  RestResultCode {
    CODE_SUCCESS(100000,"success"),
    CODE_INVALID_PARAM(100001,"invalid params"),
    CODE_EMPTY_EMAIL(11001,"empty email"),
    CODE_INVALID_PASSWORD(11002,"invalid password"),
    CODE_EMAIL_EXISTS(11003,"email exists"),
    CODE_USENAME_PASSWORD_NOT_MATCH(11004,"username and password don't match"),
    CODE_USER_NOT_FOUND(11005,"user not found");

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
