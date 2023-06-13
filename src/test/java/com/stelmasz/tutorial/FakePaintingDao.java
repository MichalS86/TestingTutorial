package com.stelmasz.tutorial;

import com.stelmasz.tutorial.dao.PaintingDao;
import com.stelmasz.tutorial.model.Painting;

import java.util.HashMap;
import java.util.Map;

public class FakePaintingDao implements PaintingDao {

    private static Map<Integer, Painting> paintingsDb = new HashMap<>();

    static {
        paintingsDb.put(1, new Painting(1, "test", 5, 10));
        paintingsDb.put(2, new Painting(2, "test", -5, 20));
        paintingsDb.put(3, new Painting(3, "test", 15, -8));
    }

    @Override
    public int addPainting(Painting painting) {
        paintingsDb.put(painting.getId(), painting);
        return painting.getId();
    }

    @Override
    public Painting getPainting(int id) {
        return paintingsDb.get(id);
    }

    @Override
    public int deletePainting(int id) {
        paintingsDb.remove(id);
        return id;
    }
}
