package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import performers.Juggler;
import performers.Performer;

// для конфишурации бинов в коде джава необходимо в xml указать <context:component-scan base-package="com.springinaction.juggers"/>
@Configuration  //указывает компилятору spring о том что этот класс является конфигурационным
public class JavaAnnotationConfig {
    @Bean
    public Performer Duke(){
        return new Juggler();
    }
}
