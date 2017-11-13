package com.springinaction.juggers;

import com.springinaction.juggers.instruments.Guitar;
import com.springinaction.juggers.performers.Instrumentalist;
import com.springinaction.juggers.performers.Jugger;
import com.springinaction.juggers.performers.Performer;
import com.springinaction.juggers.performers.PoeticJuggler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// для конфишурации бинов в коде джава необходимо в xml указать <context:component-scan base-package="com.springinaction.juggers"/>
//@Configuration  //указывает компилятору spring о том что этот класс является конфигурационным
public class SpringIdolConfig {
    // стандартный bean описанный в коде java имя объекта в контейнере spring - название методав
    @Bean
    public Performer duke() {
        return new Jugger();
    }

    @Bean
    public Performer duke15(){
        return new Jugger(15);
    }

    @Bean
    public Guitar guitar(){
        return new Guitar();
    }

    @Bean
    public Performer kenny(){
        Instrumentalist kenny = new Instrumentalist();
        kenny.setSong("Jingle Bells");
        kenny.setInstrument(guitar());
        return kenny;
    }

    @Bean
    public Poem sonet29(){
        return new Sonet29();
    }

    @Bean
    public Performer poeticDuke() {
        return new PoeticJuggler(sonet29());
    }

    @Bean
    public AnnotationAudience annotationAudience(){
        return new AnnotationAudience();
    }

}
