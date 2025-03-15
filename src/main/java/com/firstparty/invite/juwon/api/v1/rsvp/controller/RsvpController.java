package com.firstparty.invite.juwon.api.v1.rsvp.controller;

import com.firstparty.invite.juwon.api.v1.rsvp.entity.RsvpEntity;
import com.firstparty.invite.juwon.api.v1.rsvp.repository.RsvpRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rsvp")
public class RsvpController {

    private final RsvpRepository rsvpRepository;

    public RsvpController(RsvpRepository rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    @PostMapping("/save-rsvp")
    public ResponseEntity<String> saveRsvp(@RequestBody RsvpEntity rsvp) {
        rsvpRepository.save(rsvp);
        return ResponseEntity.ok("RSVP 저장 완료!");
    }

    @GetMapping("/all-rsvps")
    public List<RsvpEntity> getAllRsvps() {
        return rsvpRepository.findAll();
    }
}
