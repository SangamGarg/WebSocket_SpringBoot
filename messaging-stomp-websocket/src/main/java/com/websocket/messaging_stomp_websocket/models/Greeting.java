package com.websocket.messaging_stomp_websocket.models;

import lombok.*;

@Setter
@Getter
public class Greeting {
    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
