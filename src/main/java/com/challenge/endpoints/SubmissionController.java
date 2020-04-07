package com.challenge.endpoints;

import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping(params = {"challengeId", "accelerationId"})
    public ResponseEntity<?> findByChallengeIdAndAccelerationId(@RequestParam Long challengeId, @RequestParam Long accelerationId) {
        return ResponseEntity.ok(this.submissionMapper.map(this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId)));
    }

}