package com.stelmasz.tutorial.dao;

import com.stelmasz.tutorial.model.Painting;

public interface PaintingDao {

    int addPainting(Painting painting);

    Painting getPainting(int id);

    int deletePainting(int id);

}
