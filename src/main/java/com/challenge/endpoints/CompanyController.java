package com.challenge.endpoints;

import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.companyService.findById(id));
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<?> findByAccelerationId(@RequestParam Long accelerationId) {
        return ResponseEntity.ok(this.companyService.findByAccelerationId(accelerationId));
    }

    @GetMapping(params = "userId")
    public ResponseEntity<?> findByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(this.companyService.findByUserId(userId));
    }

}