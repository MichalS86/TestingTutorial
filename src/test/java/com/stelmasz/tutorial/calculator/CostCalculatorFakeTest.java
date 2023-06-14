package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.FakePaintingDao;
import com.stelmasz.tutorial.exception.WrongDataException;
import com.stelmasz.tutorial.model.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CostCalculatorFakeTest {

    CostCalculator costCalculator = new CostCalculator(new FakePaintingDao());

    @ParameterizedTest
    @CsvSource({"1,250", "2,750"})
    public void shouldReturnCorrectSurface(int paintingId, float expectedCost) {
        //given
        Room testRoom = new Room(1, 1, 1);

        //when
        float paintingCost = costCalculator.countRoomCost(testRoom, paintingId);

        //then
        assertEquals(paintingCost, expectedCost);
    }

    @Test
    public void shouldThrowExceptionWhenPriceIsNegative() {
        //given
        Room testRoom = new Room(1, 1, 1);

        //then
        assertThrows(WrongDataException.class, () -> costCalculator.countRoomCost(testRoom, 3));
    }

    @Test
    public void shouldThrowExceptionWhenEfficiencyIsNegative() {
        Room testRoom = new Room(1, 1, 1);

        //then
        assertThrows(WrongDataException.class, () -> costCalculator.countRoomCost(testRoom, 4));
    }
}
