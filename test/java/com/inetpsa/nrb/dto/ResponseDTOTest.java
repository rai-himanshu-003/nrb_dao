/*
 * Creation : 20 Jan 2022
 */
package com.inetpsa.nrb.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * The Class ResponseDTOTest.
 */

@ContextConfiguration
class ResponseDTOTest {

    /** The response dto. */
    static ResponseDto responseDto;

    /**
     * Sets the data.
     */
    @BeforeAll
    static void setData() {
        responseDto = new ResponseDto();
        responseDto.setMessage("Success");
        responseDto.setMsg(true);
        responseDto.setId(Long.toString(2));
    }

    /**
     * Test response dto.
     */
    @Test
    void testResponseDto() {
        assertNotNull(responseDto.getMessage());
        assertEquals(true, responseDto.isMsg(), "equal");
        assertNotNull(responseDto.getId());

    }

}
