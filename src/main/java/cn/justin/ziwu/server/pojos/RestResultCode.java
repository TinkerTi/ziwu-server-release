package cn.justin.ziwu.server.pojos;

public enum  RestResultCode {
    CODE_SUCCESS(100000,"success"),
    CODE_EMPTY_EMAIL(11001,"empty email"),
    CODE_INVALID_PASSWORD(11002,"invalid password");

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
