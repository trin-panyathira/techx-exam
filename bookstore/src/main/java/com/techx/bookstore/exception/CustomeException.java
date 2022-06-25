package com.techx.bookstore.exception;

public class CustomeException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   
   public CustomeException(String message) {
       super(message);
   }
}