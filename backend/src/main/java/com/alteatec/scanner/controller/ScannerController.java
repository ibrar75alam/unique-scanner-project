package com.alteatec.scanner.controller;

import com.alteatec.scanner.dto.ScannerResponse;
import com.alteatec.scanner.service.ScannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scanners")
@CrossOrigin(origins = "http://localhost:5173")
public class ScannerController {

    private final ScannerService scannerService;

    public ScannerController(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    @PostMapping("/generate")
    public ResponseEntity<ScannerResponse> generateScanner() {

        ScannerResponse response = scannerService.generateUniqueScanner();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/validate/{scannerCode}")
    public ResponseEntity<String> validateScanner(
            @PathVariable String scannerCode) {

        String result = scannerService.validateScanner(scannerCode);

        return ResponseEntity.ok(result);
    }
}
