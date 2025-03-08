package com.websocket.messaging_stomp_websocket.controllers;

import com.websocket.messaging_stomp_websocket.appConstants.AppConstants;
import com.websocket.messaging_stomp_websocket.models.Message;
import com.websocket.messaging_stomp_websocket.models.Room;
import com.websocket.messaging_stomp_websocket.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin(AppConstants.APP_URL_FRONTEND)
public class RoomController {
    @Autowired
    private RoomServices roomServices;

    //createRoom
    @PostMapping
    public ResponseEntity<?> create(@RequestBody String roomId) {
        return roomServices.createRoom(roomId);
    }


    //getRoom
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        return roomServices.getRoom(roomId);
    }

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId, @RequestParam(value = "page", defaultValue = "0", required = false) int page, @RequestParam(value = "size", defaultValue = "20", required = false) int size) {
        return roomServices.getMessages(roomId, page, size);
    }

    //getMessagesOfTheRoom
}
