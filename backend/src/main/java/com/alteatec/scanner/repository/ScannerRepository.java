package com.alteatec.scanner.repository;

import com.alteatec.scanner.entity.ScannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScannerRepository extends JpaRepository<ScannerEntity, Long> {

    boolean existsByScannerCode(String scannerCode);

    Optional<ScannerEntity> findByScannerCode(String scannerCode);
}
