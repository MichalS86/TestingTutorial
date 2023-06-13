package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.FakePaintingDao;
import com.stelmasz.tutorial.model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostCalculatorFakeTest {

    CostCalculator costCalculator = new CostCalculator(new FakePaintingDao());

    @Test
    public void shouldReturnCorrectSurface() {
        //given
        Room testRoom = new Room(1,1,1);

        //when
        float paintingCost = costCalculator.countRoomCost(testRoom, 1);

        //then
        assertEquals(paintingCost, 250.0);
    }


}
