package com.challenge.endpoints;

import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.userService.findById(id));
    }

    @GetMapping(params = "accelerationName")
    public ResponseEntity<?> findByAccelerationName(@RequestParam String accelerationName) {
        return ResponseEntity.ok(this.userService.findByAccelerationName(accelerationName));
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<?> findByCompanyId(@RequestParam Long companyId) {
        return ResponseEntity.ok(this.userService.findByCompanyId(companyId));
    }

}