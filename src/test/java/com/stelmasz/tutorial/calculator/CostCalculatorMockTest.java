package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.dao.DbPaintingDao;
import com.stelmasz.tutorial.model.Painting;
import com.stelmasz.tutorial.model.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CostCalculatorMockTest {

    DbPaintingDao dbPaintingDaoMock = mock(DbPaintingDao.class);
    CostCalculator costCalculator = new CostCalculator(dbPaintingDaoMock);

    @Test
    public void shouldReturnCorrectSurface() {
        //given
        Painting painting = new Painting(1, "test", 5, 10);
        when(dbPaintingDaoMock.getPainting(1)).thenReturn(painting);

        Room testRoom = new Room(1,1,1);

        //when
        float paintingCost = costCalculator.countRoomCost(testRoom, 1);

        //then
        assertEquals(paintingCost, 250.0);
    }

    @Test
    public void shouldReturnCorrectSurface2() {
        //given
        Painting painting = new Painting(1, "test", 5, 10);
        when(dbPaintingDaoMock.getPainting(1)).thenReturn(painting);

        Room testRoom = new Room(1,1,1);

        //when
        float paintingCost = costCalculator.countRoomCost(testRoom, 1);

        //then
        assertEquals(paintingCost, 250.0);
    }
}
