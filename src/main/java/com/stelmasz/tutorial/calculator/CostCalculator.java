package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.dao.PaintingDao;
import com.stelmasz.tutorial.model.Painting;
import com.stelmasz.tutorial.model.Room;
import com.stelmasz.tutorial.model.Surface;


public class CostCalculator {

    private PaintingDao paintingDao;
    private SurfaceCalculator calculator = new SurfaceCalculator();

    public CostCalculator(PaintingDao paintingDao) {
        this.paintingDao = paintingDao;
    }

    public float countRoomCost(Room room, int paintingId) {
        Surface surface = calculator.countRectangularPrismSurface(room);
        Painting painting = paintingDao.getPainting(paintingId);
        float liters = painting.getEfficiency() * surface.getSurface();
        return liters * painting.getPrice();
    }




}
