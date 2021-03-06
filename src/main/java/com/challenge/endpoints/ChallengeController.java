package com.challenge.endpoints;

import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping(params = {"accelerationId", "userId"})
    public ResponseEntity<?> findByAccelerationIdAndUserId(@RequestParam Long accelerationId, @RequestParam Long userId) {
        return ResponseEntity.ok(this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId));
    }

}