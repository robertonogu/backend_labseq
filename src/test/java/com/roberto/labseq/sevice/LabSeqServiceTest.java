package com.roberto.labseq.sevice;

import com.roberto.labseq.service.LabSeqService;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

public class LabSeqServiceTest {

    @Test
    public void testGetValueFromSequence() {
        LabSeqService labSeqService = new LabSeqService();

        // Test cases for known values
        assertEquals("0E0", labSeqService.getValueFromSequence(0));
        assertEquals("1E0", labSeqService.getValueFromSequence(1));
        assertEquals("0E0", labSeqService.getValueFromSequence(2));
        assertEquals("1E0", labSeqService.getValueFromSequence(3));
        assertEquals("1E0", labSeqService.getValueFromSequence(4));
        assertEquals("1E0", labSeqService.getValueFromSequence(5));
        assertEquals("1E0", labSeqService.getValueFromSequence(6));
        assertEquals("2E0", labSeqService.getValueFromSequence(7));
        assertEquals("2E0", labSeqService.getValueFromSequence(8));
        assertEquals("2E0", labSeqService.getValueFromSequence(9));
        assertEquals("3E0", labSeqService.getValueFromSequence(10));
    }

    @Test
    public void testNegativeIndex() {
        LabSeqService labSeqService = new LabSeqService();

        // Test case for negative input
        assertThrows(ResponseStatusException.class, () -> {
            labSeqService.getValueFromSequence(-1);
        });
    }
}