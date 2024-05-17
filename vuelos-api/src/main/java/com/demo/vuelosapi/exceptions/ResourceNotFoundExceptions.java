package com.demo.vuelosapi.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundExceptions extends IllegalArgumentException{

    private String resourceName;
    private String fieldName;
    private Long value;

    public ResourceNotFoundExceptions( String resourceName, String fieldName, Long value) {
        super(String.format("%s not found with: %s, '%s'", resourceName, fieldName, value));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
