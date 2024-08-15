package com.menumaster.menumaster.exception.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDescription {

    private int statusCode;
    private String message;
    private String details;

}