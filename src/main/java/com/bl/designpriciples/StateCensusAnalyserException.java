package com.bl.designpriciples;

public class StateCensusAnalyserException extends Exception {
    enum ExceptionType{
        CENSUS_FILE_PROBLEM;
    }

    ExceptionType type;

    public StateCensusAnalyserException(String message, ExceptionType type){
        super(message);
        this.type = type;
    }
}
