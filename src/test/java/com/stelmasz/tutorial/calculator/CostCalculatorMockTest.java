package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.dao.DbPaintingDao;
import com.stelmasz.tutorial.exception.WrongDataException;
import com.stelmasz.tutorial.model.Painting;
import com.stelmasz.tutorial.model.Room;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CostCalculatorMockTest {

    DbPaintingDao dbPaintingDaoMock = mock(DbPaintingDao.class);
    CostCalculator costCalculator = new CostCalculator(dbPaintingDaoMock);

    @BeforeEach
    public void beforeEach() {
        Painting painting1 = new Painting(1, "test1", 5, 10);
        Painting painting2 = new Painting(2, "test2", 10, 15);
        when(dbPaintingDaoMock.getPainting(1)).thenReturn(painting1);
        when(dbPaintingDaoMock.getPainting(2)).thenReturn(painting2);
    }

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
        Painting painting = new Painting(3, "test3", -5, 10);
        when(dbPaintingDaoMock.getPainting(3)).thenReturn(painting);

        Room testRoom = new Room(1, 1, 1);

        //then
        assertThrows(WrongDataException.class, () -> costCalculator.countRoomCost(testRoom, 3));
    }

    @Test
    public void shouldThrowExceptionWhenEfficiencyIsNegative() {
        //given
        Painting painting = new Painting(4, "test4", 10, -5);
        when(dbPaintingDaoMock.getPainting(4)).thenReturn(painting);

        Room testRoom = new Room(1, 1, 1);

        //then
        assertThrows(WrongDataException.class, () -> costCalculator.countRoomCost(testRoom, 4));
    }
}
