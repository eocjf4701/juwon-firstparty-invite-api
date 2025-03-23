package com.firstparty.invite.juwon.api.v1.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guestbook")
@CrossOrigin(origins = "*")
class GuestBookController {
    @Autowired
    private GuestbookRepository guestbookRepository;

    @PostMapping
    GuestbookEntry createEntry(
        @RequestParam("name") String name,
        @RequestParam("message") String message,
        @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            // 실제 경로에 저장하도록 설정
            String filename = UUID.randomUUID() + "_" + image.getOriginalFilename();
            Path filepath = Paths.get("uploads", filename);
            Files.createDirectories(filepath.getParent());
            Files.write(filepath, image.getBytes());
            imageUrl = "/uploads/" + filename;
        }

        GuestbookEntry entry = new GuestbookEntry();
        entry.setName(name);
        entry.setMessage(message);
        entry.setImageUrl(imageUrl);

        return guestbookRepository.save(entry);
    }

    @GetMapping
    List<GuestbookEntry> getAllEntries() {
        return guestbookRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }
}
