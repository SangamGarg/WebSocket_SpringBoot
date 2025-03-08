package com.websocket.messaging_stomp_websocket.controllers;


import com.websocket.messaging_stomp_websocket.appConstants.AppConstants;
import com.websocket.messaging_stomp_websocket.models.Message;
import com.websocket.messaging_stomp_websocket.models.MessageRequest;
import com.websocket.messaging_stomp_websocket.services.ChatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(AppConstants.APP_URL_FRONTEND)
public class ChatController {
    @Autowired
    private ChatServices chatServices;

    @MessageMapping("/sendMessage/{roomId}") // /app/sendMessage/roomId  ispr bhejega
    @SendTo("/topic/room/{roomId}") //ispr client subscribe krega
    public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest request) {
        return chatServices.sendMessage(roomId, request);
    }
}
