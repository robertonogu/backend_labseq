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
        assertEquals(0L, labSeqService.getValueFromSequence(0));
        assertEquals(1L, labSeqService.getValueFromSequence(1));
        assertEquals(0L, labSeqService.getValueFromSequence(2));
        assertEquals(1L, labSeqService.getValueFromSequence(3));
        assertEquals(1L, labSeqService.getValueFromSequence(4));
        assertEquals(1L, labSeqService.getValueFromSequence(5));
        assertEquals(1L, labSeqService.getValueFromSequence(6));
        assertEquals(2L, labSeqService.getValueFromSequence(7));
        assertEquals(2L, labSeqService.getValueFromSequence(8));
        assertEquals(2L, labSeqService.getValueFromSequence(9));
        assertEquals(3L, labSeqService.getValueFromSequence(10));
    }

    @Test
    public void testNegativeInput() {
        LabSeqService labSeqService = new LabSeqService();

        // Test case for negative input
        assertThrows(ResponseStatusException.class, () -> {
            labSeqService.getValueFromSequence(-1);
        });
    }
}