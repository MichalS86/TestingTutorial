package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.model.Room;
import com.stelmasz.tutorial.model.Surface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceCalculatorTest {


    SurfaceCalculator calculator = new SurfaceCalculator();

    @Test
    public void shouldCountTraingularPrismSurface(){
        //given
        Room room = new Room(1,1,1);

        //when
        Surface surface = calculator.countTriangularPrismSurface(room);

        //then
        assertEquals(surface.getWallsSurface(), 3);
        assertEquals(surface.getCeilingSurface(), 0.5);
    }
}
