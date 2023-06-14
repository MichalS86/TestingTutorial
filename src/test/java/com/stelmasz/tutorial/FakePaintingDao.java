package com.stelmasz.tutorial;

import com.stelmasz.tutorial.dao.PaintingDao;
import com.stelmasz.tutorial.model.Painting;

import java.util.HashMap;
import java.util.Map;

public class FakePaintingDao implements PaintingDao {

    private static Map<Integer, Painting> paintingsDb = new HashMap<>();

    static {
        paintingsDb.put(1, new Painting(1, "test1", 5, 10));
        paintingsDb.put(2, new Painting(2, "test2", 10, 15));
        paintingsDb.put(3, new Painting(3, "test3", -5, 10));
        paintingsDb.put(4, new Painting(4, "test4", 10, -5));
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
