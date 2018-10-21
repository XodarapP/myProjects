package ru.bpn.hello;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.support.MarshallingUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws IOException {
        HttpSession session = Utils.session();
        String countryName = (String) session.getAttribute("countryName");
        if (countryName != null) {
            LOGGER.info("Country {}", countryName);
        }
        SoapMessage soapMessage = (SoapMessage) messageContext.getRequest();
        SoapBody body = soapMessage.getSoapBody();
        Document document = soapMessage.getDocument();
        NodeList country = document.getElementsByTagName("name");
        LOGGER.info("Country {}", countryName);

        SaajSoapMessage saajSoapMessage = (SaajSoapMessage) messageContext.getResponse();

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();

        SoapBody requestBody = saajSoapMessage.getSoapBody();
        Object obj = jaxb2Marshaller.unmarshal(requestBody.getPayloadSource());

        GetCountryResponse cor = (GetCountryResponse) obj;
        SaajSoapMessageFactory mf = new SaajSoapMessageFactory();
        //String orderId = String.valueOf(cor.getName());
        SaajSoapMessage message = mf.createWebServiceMessage();
        messageContext.setResponse(message);
        MarshallingUtils.marshal(jaxb2Marshaller, cor, message);

        LOGGER.info("ok");
    }
}
