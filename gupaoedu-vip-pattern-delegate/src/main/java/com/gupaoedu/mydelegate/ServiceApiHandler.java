package com.gupaoedu.mydelegate;

import com.gupaoedu.mydelegate.dto.BaseRespDto;
import com.gupaoedu.mydelegate.dto.RoleService;
import com.gupaoedu.mydelegate.dto.UserService;

import java.util.HashMap;
import java.util.Map;

public class ServiceApiHandler implements ServiceApi {
    private Map<String, ServiceApi> targets = new HashMap<String,ServiceApi>();

    public ServiceApiHandler() {
        targets.put("userService",new UserService());
        targets.put("roleService",new RoleService());
    }
    @Override
    public BaseRespDto<?> handler(ServiceDto serviceDto) {
        return targets.get(serviceDto.getServiceName()).handler(serviceDto);
    }

}
