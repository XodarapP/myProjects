package com.springinaction.juggers;

import com.springinaction.juggers.performers.Jugger;
import com.springinaction.juggers.performers.Performer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// для конфишурации бинов в коде джава необходимо в xml указать <context:component-scan base-package="com.springinaction.juggers"/>
@Configuration  //указывает компилятору spring о том что этот класс является конфигурационным
public class SpringIdolConfig {
    // стандартный bean описанный в коде java имя объекта в контейнере spring - название методав
    @Bean
    public Performer duke() {
        return new Jugger();
    }
}
