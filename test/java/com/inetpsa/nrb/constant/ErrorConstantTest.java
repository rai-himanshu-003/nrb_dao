/*
 * Creation : 21 Apr 2022
 */
package com.inetpsa.nrb.constant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ErrorConstantTest {

    @Test
    void testErrorConstant() {
        assertNotNull(ErrorConstant.ERROR_3.getConstValue().equalsIgnoreCase("ERR2-003"));
        assertNotNull(ErrorConstant.ERROR_4.getConstValue().equalsIgnoreCase("ERR2-004"));
        assertNotNull(ErrorConstant.ERROR_5.getConstValue().equalsIgnoreCase("ERR2-005"));
        assertNotNull(ErrorConstant.ERROR_6.getConstValue().equalsIgnoreCase("ERR2-006"));
        assertNotNull(ErrorConstant.ERROR_7.getConstValue().equalsIgnoreCase("ERR2-007"));
        assertNotNull(ErrorConstant.ERROR_8.getConstValue().equalsIgnoreCase("ERR2-008"));
        assertNotNull(ErrorConstant.ERROR_9.getConstValue().equalsIgnoreCase("ERR2-009"));
        assertNotNull(ErrorConstant.ERROR_10.getConstValue().equalsIgnoreCase("ERR2-010"));
        assertNotNull(ErrorConstant.ERROR_11.getConstValue().equalsIgnoreCase("ERR2-011"));
        assertNotNull(ErrorConstant.ERROR_13.getConstValue().equalsIgnoreCase("ERR2-013"));
        assertNotNull(ErrorConstant.ERROR_14.getConstValue().equalsIgnoreCase("ERR2-014"));
        assertNotNull(ErrorConstant.ERROR_15.getConstValue().equalsIgnoreCase("ERR2-015"));
        assertNotNull(ErrorConstant.ERROR_16.getConstValue().equalsIgnoreCase("ERR2-016"));
        assertNotNull(ErrorConstant.ERROR_17.getConstValue().equalsIgnoreCase("ERR2-017"));
        assertNotNull(ErrorConstant.ERROR_18.getConstValue().equalsIgnoreCase("ERR2-018"));
        assertNotNull(ErrorConstant.ERROR_19.getConstValue().equalsIgnoreCase("ERR2-019"));
        assertNotNull(ErrorConstant.ERROR_2.getConstValueInt());
    }

}
