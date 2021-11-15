package com.bl.designprinciples;

import com.bl.designpriciples.StateCensusAnalyser;
import com.bl.designpriciples.StateCensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class StateAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILEPATH = "C:\\Users\\Altamash\\IdeaProjects\\StateCensusAnalyser\\src\\test\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenIndiaCensusCsvFile_ReturnsCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILEPATH);
            Assert.assertEquals(29, numOfRecords);
        }catch (StateCensusAnalyserException e){ }
    }
}
