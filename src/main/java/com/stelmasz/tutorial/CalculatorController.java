package com.stelmasz.tutorial;

import com.stelmasz.tutorial.calculator.CostCalculator;
import com.stelmasz.tutorial.dao.DbPaintingDao;
import com.stelmasz.tutorial.dao.PaintingDao;
import com.stelmasz.tutorial.model.Painting;
import com.stelmasz.tutorial.model.Request;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/")
public class CalculatorController {

    PaintingDao paintingDao = new DbPaintingDao(Conf.createDataSource());
    CostCalculator costCalculator = new CostCalculator(paintingDao);


    @PostMapping(value = "/count", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public float countPaintingCost(@RequestBody Request request) {
        return costCalculator.countRoomCost(request.getRoom(), request.getPaintingId());
    }

    @PostMapping(value = "/painting", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addPainting(@RequestBody Painting painting) {
        paintingDao.addPainting(painting);
    }

    @DeleteMapping(value = "/painting")
    public void deletePainting(@RequestParam int id) {
        paintingDao.deletePainting(id);
    }

    @GetMapping(value = "/painting")
    public Painting getPainting(@RequestParam int id) {
        return paintingDao.getPainting(id);
    }

}

