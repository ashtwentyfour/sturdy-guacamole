package com.ashcorp.censusdataoperations.exception;

public class CensusNotFoundException extends RuntimeException {
    /**
    * Constructor.
    * @param exception Exception object
    */
    public CensusNotFoundException(final String exception) {
        super(exception);
    }
}
