package com.example.chucknorrisapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void returnRandomJoke() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        RestTemplate restTemplate = new RestTemplate();
        Joke joke = restTemplate.getForObject("http://api.icndb.com/jokes/random", Joke.class);
        log.info(joke.toString());
    }
}
