package got.backend.controllers;

import got.backend.model.RoomType;
import got.backend.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room-type")
public class RoomTypeController {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @GetMapping
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable("id") Integer id) {
        if(!roomTypeRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        RoomType roomType = roomTypeRepository.getOne(id);
        return new ResponseEntity<>(roomType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType) {
        roomTypeRepository.save(roomType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable("id") Integer id,
                                                   @RequestBody RoomType roomType) {
        if(!roomTypeRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        roomType.setId(id);
        roomTypeRepository.save(roomType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
