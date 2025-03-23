package com.firstparty.invite.juwon.api.v1.rsvp.controller;

import com.firstparty.invite.juwon.api.v1.guest.entity.GuestBookEntity;
import com.firstparty.invite.juwon.api.v1.guest.repository.GuestBookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rsvp")
public class RsvpController {

    private final GuestBookRepository guestBookRepository;

    public RsvpController(GuestBookRepository guestBookRepository) {
        this.guestBookRepository = guestBookRepository;
    }

    @PostMapping("/save-rsvp")
    public ResponseEntity<String> saveRsvp(@RequestBody GuestBookEntity rsvp) {
        guestBookRepository.save(rsvp);
        return ResponseEntity.ok("RSVP 저장 완료!");
    }

    @GetMapping("/all-rsvps")
    public List<GuestBookEntity> getAllRsvps() {
        return guestBookRepository.findAll();
    }
}
