package com.firstparty.invite.juwon.api.v1.guest.repository;

import com.firstparty.invite.juwon.api.v1.guest.entity.GuestBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository extends JpaRepository<GuestBookEntity, Long> {
}
