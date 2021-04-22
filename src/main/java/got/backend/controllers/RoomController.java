package got.backend.controllers;

import got.backend.model.Room;
import got.backend.repository.RoomRepository;
import got.backend.services.room.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @GetMapping
    private List<Room> getAllRooms() {
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {
        Room room = roomService.findById(id);
        if(room == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Room> createRoom(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Room> updateRoom(@PathVariable("id") Integer id,
                                            @RequestBody Room room) {
        boolean success = roomService.updateById(id, room);
        if(!success)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
