package com.websocket.messaging_stomp_websocket.services;

import com.websocket.messaging_stomp_websocket.models.Message;
import com.websocket.messaging_stomp_websocket.models.MessageRequest;

public interface ChatServices {
    public Message sendMessage(String roomId, MessageRequest request);
}
