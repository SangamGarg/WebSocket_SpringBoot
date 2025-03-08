package com.websocket.messaging_stomp_websocket.ServiceImpl;

import com.websocket.messaging_stomp_websocket.models.Message;
import com.websocket.messaging_stomp_websocket.models.Room;
import com.websocket.messaging_stomp_websocket.models.MessageRequest;
import com.websocket.messaging_stomp_websocket.repositories.RoomRepository;
import com.websocket.messaging_stomp_websocket.services.ChatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatServiceImpl implements ChatServices {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Message sendMessage(String roomId, MessageRequest request) {
        Room room = roomRepository.findByRoomId(request.getRoomId());
        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if (room != null) {
            room.getMessages().add(message);
            roomRepository.save(room);
        } else {
            throw new RuntimeException("Room not found!!");
        }
        return message;
    }
}
