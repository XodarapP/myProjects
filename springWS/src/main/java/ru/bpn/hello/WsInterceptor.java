package ru.bpn.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;

import javax.servlet.http.HttpSession;

@Slf4j
public class WsInterceptor extends EndpointInterceptorAdapter {

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) {
        HttpSession session = Utils.session();
        String countryName = (String) session.getAttribute("countryName");
        if (countryName != null) {
            LOGGER.info("Country {}", countryName);
        }
    }
}
