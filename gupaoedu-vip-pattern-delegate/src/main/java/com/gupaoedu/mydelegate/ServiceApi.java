package com.gupaoedu.mydelegate;

import com.gupaoedu.mydelegate.dto.BaseRespDto;

public interface ServiceApi {
    public BaseRespDto<?> handler(ServiceDto serviceDto);
}
