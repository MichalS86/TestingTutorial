package com.stelmasz.tutorial;

import com.stelmasz.tutorial.calculator.Calculator;
import com.stelmasz.tutorial.dao.DbPaintingDao;
import com.stelmasz.tutorial.dao.PaintingDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    Calculator calculator;

    @BeforeAll
    public void before() {
        PaintingDao paintingDao = new DbPaintingDao(Conf.createDataSource());
        calculator = new Calculator(paintingDao);
    }

    @Test
    public void test01() {

    }

}
