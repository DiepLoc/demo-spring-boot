package com.example.demo.system;

import lombok.Getter;
import lombok.Setter;

public class ResponseObj {
    @Getter @Setter private String message;
    @Getter @Setter private String status;

    public ResponseObj(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
