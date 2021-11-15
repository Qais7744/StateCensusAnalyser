package com.bl.designpriciples;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadIndiaCensusData(String csvFilepath) throws StateCensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
            CsvToBean<CensusUser> csvToBean = new CsvToBeanBuilder(reader).withType(CensusUser.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CensusUser> censusCsvIterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (censusCsvIterator.hasNext()) {
                numOfEntries++;
                CensusUser censusData = censusCsvIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            throw new StateCensusAnalyserException(e.getMessage(), StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

}

