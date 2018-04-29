package cn.justin.ziwu.server.services;

import cn.justin.ziwu.server.pojos.InputLoginData;
import cn.justin.ziwu.server.pojos.InputRegisterData;
import cn.justin.ziwu.server.pojos.RestResult;

public interface UserService {

    RestResult register(InputRegisterData data);
    RestResult login(InputLoginData data);
}
