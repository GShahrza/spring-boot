package com.company.usertask.controller;

import com.company.usertask.domain.Profile;
import com.company.usertask.repository.ProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/profiles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileController {

    private final ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<?> getAllProfiles(){
        List<Profile> profiles = profileRepository.findAllForNative();

        return ResponseEntity.ok(profiles);
    }

}
