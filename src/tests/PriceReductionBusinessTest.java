package tests;

import business.PriceReductionBusiness;
import exception.ConnectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceReductionBusinessTest {

    private PriceReductionBusiness business;

    @BeforeEach
    void setUp() throws ConnectionException {
        business = new PriceReductionBusiness(1);
    }

    @Test
    void secondReduction() {
        assertEquals(100, business.secondReduction(120, 20));
    }

    @Test
    void calculateReduction() {
        assertEquals(40, business.calculateReduction(4, 10));
    }
}