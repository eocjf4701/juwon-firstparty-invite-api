package com.firstparty.invite.juwon.api.v1.rsvp.repository;

import com.firstparty.invite.juwon.api.v1.rsvp.entity.RsvpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsvpRepository extends JpaRepository<RsvpEntity, Long> {
}
