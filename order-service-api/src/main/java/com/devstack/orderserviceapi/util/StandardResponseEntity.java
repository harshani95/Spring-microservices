package com.devstack.orderserviceapi.util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponseEntity {
    private int code;
    private String message;
    private Object data;
}
