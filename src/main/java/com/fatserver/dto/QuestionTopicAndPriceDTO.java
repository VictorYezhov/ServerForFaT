package com.fatserver.dto;

public class QuestionTopicAndPriceDTO {
    private String topic;
    private Integer price;

    public QuestionTopicAndPriceDTO(String topic, Integer price){
        this.topic = topic;
        this.price = price;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
