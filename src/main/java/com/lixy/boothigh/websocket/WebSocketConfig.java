package com.lixy.boothigh.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * websocketConfig配置，单元测试时，需要将@Bean注释掉，否则单元测试不能通过
 * @Author: MR LIS
 * @Description:ServerEndpointExporter
 * @Date: Create in 14:31 2018/6/19
 * @Modified By:
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}