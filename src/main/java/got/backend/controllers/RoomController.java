package got.backend.controllers;

import got.backend.model.Room;
import got.backend.repository.RoomRepository;
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
    private RoomRepository roomRepository;

    @GetMapping
    private List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {
        if(!roomRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Room room = roomRepository.getOne(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Room> createRoom(@RequestBody Room room) {
        roomRepository.save(room);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Room> updateRoom(@PathVariable("id") Integer id,
                                            @RequestBody Room room) {
        if(!roomRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        room.setId(id);
        roomRepository.save(room);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
