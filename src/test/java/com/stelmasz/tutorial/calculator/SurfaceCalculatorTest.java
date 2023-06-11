package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceCalculatorTest {


    SurfaceCalculator calculator = new SurfaceCalculator();

    @Test
    public void shouldCountTraingularPrismSurface(){
        //given
        Room room = new Room(1,1,1);

        //when
        float surface = calculator.countTriangularPrismSurface();

        //then
        assertEquals(surface, 3.5);
    }
}
