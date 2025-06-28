package org.example.bookManager.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BadRequest {

    private String field;
    private String message;
}
