package com.bl.designprinciples;

import com.bl.designpriciples.StateCensusAnalyser;
import com.bl.designpriciples.StateCensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILEPATH = "C:\\Users\\Altamash\\IdeaProjects\\StateCensusAnalyser\\src\\test\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";

    @Test
    public void givenIndiaCensusCsvFile_ReturnsCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILEPATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (StateCensusAnalyserException | IOException e) {
        }
    }

    @Test
    public void givenWrongIndiaCensusCsvFile_ReturnsException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(WRONG_FILE_PATH );
            Assert.assertEquals(29, numOfRecords);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
