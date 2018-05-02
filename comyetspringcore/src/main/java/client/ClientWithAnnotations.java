package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource("classpath:client.properties")
public class ClientWithAnnotations {
    private String id;
    private String fullName;
    private String greeting;

    @Bean(name = "client")
    ClientWithAnnotations client(){
        return new ClientWithAnnotations();
    }

    public String getId() {
        return id;
    }

    @Value("1")
    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    @Value("John Smith")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGreeting() {
        return greeting;
    }

    @Value("Hello John Smith")
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "ClientWithAnnotations{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", greeting='" + greeting + '\'' +
                '}';
    }
}
