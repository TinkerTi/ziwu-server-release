package cn.justin.ziwu.server.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputLoginData {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;

}
