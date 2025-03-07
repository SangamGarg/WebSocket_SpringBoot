package com.websocket.messaging_stomp_websocket.services;

import com.websocket.messaging_stomp_websocket.models.Message;
import com.websocket.messaging_stomp_websocket.models.Room;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomServices {
    public ResponseEntity<?> createRoom(String roomId);

    public ResponseEntity<?> getRoom(String roomId);

    public ResponseEntity<List<Message>> getMessages(String roomId, int page, int size);
}
