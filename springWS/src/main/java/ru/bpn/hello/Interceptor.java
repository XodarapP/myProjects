package ru.bpn.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import javax.servlet.http.HttpSession;

@Slf4j
public class Interceptor implements EndpointInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object o) {
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object o) {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object o) {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) {
        HttpSession session = Utils.session();
        String countryName = (String) session.getAttribute("countryName");
        LOGGER.info("Country {}", countryName);
    }
}
