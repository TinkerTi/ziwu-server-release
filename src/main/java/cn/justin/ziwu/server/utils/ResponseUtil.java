package cn.justin.ziwu.server.utils;

import cn.justin.ziwu.server.pojos.RestResult;

import javax.ws.rs.core.Response;


public class ResponseUtil {
    static public Response Ok(RestResult r) {
        return Response.ok(r).build();
    }
}
