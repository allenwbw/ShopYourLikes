package com.ucla.shopyourlikes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * custom exception for Resource NOT_FOUND
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    /**
     *
     * @param resourceName
     * @param fieldName
     * @param fieldValue
     */
    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    /**
     *
     * @return resourceName
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     *
     * @return FieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     *
     * @return fieldValue
     */
    public Object getFieldValue() {
        return fieldValue;
    }
}