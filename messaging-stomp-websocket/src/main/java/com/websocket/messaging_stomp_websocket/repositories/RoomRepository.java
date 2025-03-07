package com.websocket.messaging_stomp_websocket.repositories;

import com.websocket.messaging_stomp_websocket.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    //get Room using Room id
    Room findByRoomId(String roomId);
}
