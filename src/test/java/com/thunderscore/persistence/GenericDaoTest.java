package com.thunderscore.persistence;

import com.thunderscore.GenericDAOTestDepricated;
import com.thunderscore.entity.Brand;
import com.thunderscore.entity.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest extends GenericDAOTestDepricated {

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

    @Test
    void getById() {
        Brand brand = (Brand) dao.getById(1);
        String brandString = brand.toString();
        logger.debug(brandString);
        assertNotNull(brand);
        Country country = new Country(9, "United States");
        Brand expected = new Brand(1, "Ford", country);
        String expectedToString = expected.toString();
        assertEquals(expectedToString, brandString);
    }

    @Test
    void delete() {
    }

    @Test
    void insert() {
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void findByPropertyEqual() {
    }
}