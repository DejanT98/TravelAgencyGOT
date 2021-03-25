package got.backend.controllers;

import got.backend.model.Reservation;
import got.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("id")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Integer id) {
        if(!reservationRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Reservation reservation = reservationRepository.getOne(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("id")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Integer id,
                                                         @RequestBody Reservation reservation) {
        if(!reservationRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        reservation.setId(id);
        reservationRepository.save(reservation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
