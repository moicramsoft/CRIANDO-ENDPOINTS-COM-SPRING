package com.challenge.endpoints;

import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.accelerationService.findById(id));
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<?> findByCompanyId(@RequestParam Long companyId) {
        return ResponseEntity.ok(this.accelerationService.findByCompanyId(companyId));
    }

}