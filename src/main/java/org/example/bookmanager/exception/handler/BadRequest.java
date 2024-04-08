package org.example.bookmanager.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequest {

    private String field;
    private String message;
}
