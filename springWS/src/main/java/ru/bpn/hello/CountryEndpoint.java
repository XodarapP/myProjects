package ru.bpn.hello;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicInteger;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private AtomicInteger integer = new AtomicInteger();

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        HttpSession session = Utils.session();
        String countryName = request.getName();
        session.setAttribute("countryName" + integer.incrementAndGet(), countryName);
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}
