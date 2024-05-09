package com.roberto.labseq.controller;

import com.roberto.labseq.service.LabSeqService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class LabSeqControllerTest {

    @Test
    public void testGetValueFromSequence() {
        LabSeqController labSeqController = new LabSeqController(new LabSeqService());

        ResponseEntity<?> responseEntity = labSeqController.getValueFromSequence(5);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1L, responseEntity.getBody());
    }

    @Test
    public void testNegativeInput() {
        LabSeqController labSeqController = new LabSeqController(new LabSeqService());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            labSeqController.getValueFromSequence(-1);
        });

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertEquals("Index should be a non-negative integer number.", exception.getReason());
    }
}
