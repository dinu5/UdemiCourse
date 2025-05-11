package com.test.project.Restfull.web.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessageFormat {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
