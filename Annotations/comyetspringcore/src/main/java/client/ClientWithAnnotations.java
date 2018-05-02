package client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


//@ImportResource(value = "classpath:client.properties", reader = PropertiesBeanDefinitionReader.class)
//@Resource(name = "springPlaceHolder.xml")
@PropertySource("classpath:client.properties")
@Configuration
public class ClientWithAnnotations {
    @Value(value = "${id}")
    private String id;
    @Value("${name}")
    private String fullName;
    private String greeting;

    @Autowired
    private Environment environment;

    public void setGreeting(String greeting) {
        this.greeting = environment.getProperty("greeting");
    }

    @Bean(name = "client")
    public ClientWithAnnotations client(){
        return new ClientWithAnnotations();
    }

    @Bean(name = "configurer")
    public static PropertySourcesPlaceholderConfigurer configurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getId() {
        return id;
    }



    public String getFullName() {
        return fullName;
    }



    public String getGreeting() {
        return greeting;
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
