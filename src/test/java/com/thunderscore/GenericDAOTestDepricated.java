package com.thunderscore;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.thunderscore.entity.Brand;
import com.thunderscore.persistence.GenericDao;

public class GenericDAOTestDepricated {

    GenericDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp(){
        dao = new GenericDao(Brand.class);
    }

    @Test
     void getAllSuccess(){
        List<Brand> brands = dao.getAll();
        assertEquals(2, brands.size());
    }
}
