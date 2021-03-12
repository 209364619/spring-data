package com.example.demo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class KafKaConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean(name = "kafkaMessageLinkedList")
    public List<JSONObject> kafkaMessageLinkedList(){
        List<JSONObject> messageLinkedList = new LinkedList<>();
        return messageLinkedList;
    }

    @KafkaListener(id = "myId", topics = "topic1")
    public void listen(String data) {
        System.out.println(data);
        JSONObject message = new JSONObject();
        message.put("topic", "topic1");
        message.put("data", JSON.parse(data));
        StaticData.messageLinkedList.add(message);
    }

}
