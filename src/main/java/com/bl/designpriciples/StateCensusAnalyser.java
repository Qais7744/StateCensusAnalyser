package com.bl.designpriciples;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadIndiaCensusData(String csvFilepath) throws StateCensusAnalyserException, IOException {
        try {
            Reader reader = null;
            CsvToBean<CensusUser> csvToBean = new CsvToBeanBuilder(reader).withType(CensusUser.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CensusUser> censusCsvIterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (censusCsvIterator.hasNext()) {
                numOfEntries++;
                CensusUser censusData = censusCsvIterator.next();
            }
            return numOfEntries;
        } catch(RuntimeException e){
            throw new StateCensusAnalyserException(e.getMessage(), StateCensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
    }
}

