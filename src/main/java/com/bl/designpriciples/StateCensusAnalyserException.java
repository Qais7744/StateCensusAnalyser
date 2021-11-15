package com.bl.designpriciples;

public class StateCensusAnalyserException extends Exception {

    public ExceptionType type;

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, CSV_FILE_INTERNAL_ISSUES;
    }

    public StateCensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
