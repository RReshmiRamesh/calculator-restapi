package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.calculator.basic.BasicController;
import com.example.calculator.model.ApiResult;

import org.junit.jupiter.api.Test;

public class BasicControllerTests {

    private BasicController _basicController = new BasicController();

    @Test
    void calculusTest(){
        ApiResult apiResult = _basicController.calculus("NSooKDIrMSktKDgtNikrKDgvOCkp");
        assertFalse(apiResult.getError());
        assertEquals("10.0",apiResult.getResult());

    }

    @Test
    void calculusTestInvalidInput(){

        assertTrue(_basicController.calculus("testError").getError());
        assertTrue(_basicController.calculus("NSooKDIrMSktKDgtNikrKDgvMCk=").getError());

    }
    
    @Test

    void calculusTestForDivisionByZero(){
        assertTrue(_basicController.calculus("NSooKDIrMSktKDgtNikrKDgvMCkp").getError());

    }
    
}
