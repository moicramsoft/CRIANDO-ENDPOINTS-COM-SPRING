package com.challenge.endpoints;

import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<?> findById(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {
        return ResponseEntity.ok(this.candidateMapper.map(this.candidateService.findById(userId, companyId, accelerationId).orElse(null)));
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<?> findByCompanyId(@RequestParam Long companyId) {
        return ResponseEntity.ok(this.candidateMapper.map(this.candidateService.findByCompanyId(companyId)));
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<?> findByAccelerationId(@RequestParam Long accelerationId) {
        return ResponseEntity.ok(this.candidateMapper.map(this.candidateService.findByAccelerationId(accelerationId)));
    }

}