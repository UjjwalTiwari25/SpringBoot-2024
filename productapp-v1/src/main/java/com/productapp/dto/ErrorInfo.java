package com.productapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ErrorInfo {
     private LocalDateTime timestamp;
     private  String statusCode;
     private String errorMessage;
     private String toContact;
}
