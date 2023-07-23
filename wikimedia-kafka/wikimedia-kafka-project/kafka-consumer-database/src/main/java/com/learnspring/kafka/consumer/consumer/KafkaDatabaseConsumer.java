package com.learnspring.kafka.consumer.consumer;

import com.learnspring.kafka.consumer.entity.Wikimedia;
import com.learnspring.kafka.consumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @Autowired
    private WikimediaRepository wikimediaRepository;

    @KafkaListener(topics = "${kafka.topic1.name}", groupId = "myGroup")
    public void consume(String eventMessage) {
        this.logger.info(String.format("Event message received -> %s", eventMessage));
        Wikimedia wikimedia = Wikimedia.builder()
                .wikiEventData(eventMessage)
                .build();
        this.wikimediaRepository.save(wikimedia);
    }
}
