package got.backend.controllers;

import got.backend.model.RoomType;
import got.backend.repository.RoomTypeRepository;
import got.backend.services.roomtype.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room-type")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping
    public Page<RoomType> getAllRoomTypes(Pageable pageable) {
        return roomTypeService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable("id") Integer id) {
        RoomType roomType = roomTypeService.findById(id);
        if(roomType == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(roomType, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType) {
        roomTypeService.save(roomType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable("id") Integer id,
                                                   @RequestBody RoomType roomType) {
        boolean success = roomTypeService.updateById(id, roomType);
        if(!success)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
