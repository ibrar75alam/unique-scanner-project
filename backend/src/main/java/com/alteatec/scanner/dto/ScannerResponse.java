package com.alteatec.scanner.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScannerResponse {

    private Long id;
    private String scannerCode;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;


}
