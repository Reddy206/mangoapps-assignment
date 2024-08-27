package com.quickbook.MovieRush.Exception;


public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String resourceName;
    private Long resourceValue;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String resource) {
        super(resource);
        this.resource = resource;
    }

    public ResourceNotFoundException(String resource, String resourceName, Long resourceValue) {
        super(resource + " with " + resourceName +" "+ resourceValue + " Not Found! ");
        this.resource = resource;
        this.resourceName = resourceName;
        this.resourceValue = resourceValue;
    }
}
