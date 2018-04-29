package cn.justin.ziwu.server.mybatis.mapper.extended;

import cn.justin.ziwu.server.mybatis.mapper.generated.TUserMapper;
import cn.justin.ziwu.server.mybatis.model.generated.TUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface ExtendedTUserMapper extends TUserMapper {

    TUser getUserByUsername(String username);
    TUser getUserByEmail(String email);
    TUser getUserByPhone(String phone);

}
