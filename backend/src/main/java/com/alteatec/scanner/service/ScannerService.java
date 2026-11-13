package com.alteatec.scanner.service;

import com.alteatec.scanner.dto.ScannerResponse;
import com.alteatec.scanner.entity.ScannerEntity;
import com.alteatec.scanner.repository.ScannerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ScannerService {

    private final ScannerRepository scannerRepository;

    public ScannerService(ScannerRepository scannerRepository) {
        this.scannerRepository = scannerRepository;
    }

    public ScannerResponse generateUniqueScanner() {

        String uniqueCode;

        do {
            uniqueCode = UUID.randomUUID().toString();
        } while (scannerRepository.existsByScannerCode(uniqueCode));

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime expiresAt = createdAt.plusMinutes(5);

        // Create empty object
        ScannerEntity scannerEntity = new ScannerEntity();

        // Set values
        scannerEntity.setScannerCode(uniqueCode);
        scannerEntity.setStatus("ACTIVE");
        scannerEntity.setCreatedAt(createdAt);
        scannerEntity.setExpiresAt(expiresAt);

        // Save into database
        ScannerEntity savedScanner = scannerRepository.save(scannerEntity);

        return new ScannerResponse(
                savedScanner.getId(),
                savedScanner.getScannerCode(),
                savedScanner.getStatus(),
                savedScanner.getCreatedAt(),
                savedScanner.getExpiresAt()
        );
    }



    public String validateScanner(String scannerCode) {

        ScannerEntity scanner = scannerRepository
                .findByScannerCode(scannerCode)
                .orElseThrow(() ->
                        new RuntimeException("Scanner not found"));

        // Check whether scanner has expired
        if (LocalDateTime.now().isAfter(scanner.getExpiresAt())) {

            scanner.setStatus("EXPIRED");

            scannerRepository.save(scanner);

            return "Scanner has expired";
        }

        return "Scanner is valid";
    }
}
