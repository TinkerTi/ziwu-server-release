package cn.justin.ziwu.server.resources;

import cn.justin.ziwu.server.pojos.InputLoginData;
import cn.justin.ziwu.server.pojos.InputRegisterData;
import cn.justin.ziwu.server.pojos.RestResult;
import cn.justin.ziwu.server.services.UserService;
import cn.justin.ziwu.server.utils.ResponseUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/user")
public class UserResource {

    @Resource
    UserService userService;


    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@RequestBody InputRegisterData data) {
        RestResult restResult = userService.register(data);
        return ResponseUtil.Ok(restResult);
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(InputLoginData data) {
        RestResult restResult = userService.login(data);
        return ResponseUtil.Ok(restResult);
    }

    @Path("/logout")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        RestResult restResult = userService.logout();
        return ResponseUtil.Ok(restResult);
    }
}
