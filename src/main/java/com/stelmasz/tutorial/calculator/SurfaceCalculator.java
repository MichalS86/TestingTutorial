package com.stelmasz.tutorial.calculator;

import com.stelmasz.tutorial.model.Room;
import com.stelmasz.tutorial.model.Surface;

public class SurfaceCalculator {

    public Surface countRectangularPrismSurface(Room room) {
        float ceiling = room.getLength() * room.getWidth();
        float walls = 2 * room.getWidth() * room.getHeight() + 2 * room.getLength() * room.getHeight();
        return new Surface(walls, ceiling);
    }
}
