package com.roberto.labseq.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.NumberFormat;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class LabSeqService {

    private static final Map<Integer, BigInteger> cache;
    /**
     * Assignment of the first values ​​in the sequence
     */
    static {
        cache = new HashMap<>();
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

    /**
     * This method is the only entry to the service
     * Receives the index from the controller
     * @param index - index received to calculate the value of sequence
     * @return the value calculated from the sequence
     */
    public String getValueFromSequence(int index) {
        this.validateIndex(index);

        return calculateValue(index);
    }

    /**
     * This method is used to validate the index received
     * If index is negative, is thrown an exception
     * Otherwise, the process to calculate the value of sequence continues
     * @param index - index received to calculate the value of sequence
     */
    private void validateIndex(int index) {
        if (index < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Index should be a non-negative integer number.");
    }

    /**
     * This method calculate the value from the sequence
     * @param index - index received to calculate the value of sequence
     * @return string that has represented the number in scientific notation
     */
    private String calculateValue(int index) {
        if (cache.containsKey(index))
            return this.convertValueToString(cache.get(index));

        BigInteger value;
        for (int i = 4; i <= index; i++) {
            if (!cache.containsKey(i)) {
                value = cache.get(i - 4).add(cache.get(i - 3));
                cache.put(i, value);
            }
        }

        return this.convertValueToString(cache.get(index));
    }

    /**
     * This method converts the value to scientific notation
     * @param value - value to be converted
     * @return string that has represented the number in scientific notation
     */
    private String convertValueToString(BigInteger value) {
        NumberFormat formatter = new DecimalFormat("0.##E0");
        return formatter.format(value);
    }
}