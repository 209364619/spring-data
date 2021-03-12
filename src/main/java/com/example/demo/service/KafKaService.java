package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.StaticData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafKaService {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    public JSONObject sendJsonObject(String topic, JSONObject object){
        ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send(topic, object.toJSONString());
        return (JSONObject)JSONObject.toJSON(send);
    }

    /**
     * 获取队列中消息
     * return JSONObject
     */
    public JSONObject fetchMessageFromTopic(){
        JSONObject message = null;
        if (StaticData.messageLinkedList.size()>0){
            message = StaticData.messageLinkedList.pop();
        }
        return message;
    }
}
