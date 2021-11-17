package com.thunderscore.persistence;

import com.thunderscore.GenericDAOTestDepricated;
import com.thunderscore.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GenericDaoTest extends GenericDAOTestDepricated {

    GenericDao<Brand> brandDao;
    GenericDao<Trim> trimDao;
    GenericDao<Model> modelDao;
    GenericDao<Engine> engineDao;
    GenericDao<DriveTrain> driveTrainDao;
    GenericDao<Transmission> transmissionDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp(){
        brandDao = new GenericDao(Brand.class);
        trimDao = new GenericDao(Trim.class);
        modelDao = new GenericDao(Model.class);
        engineDao = new GenericDao(Engine.class);
        driveTrainDao = new GenericDao(DriveTrain.class);
        transmissionDao = new GenericDao(Transmission.class);
        // The next chunk of code is intended to reset the tested DB to a state that will allow tests to be run against it.
        // DO NOT RUN AGAINST PRODUCTION.
        Database db = Database.getInstance();
        db.runSQL("sample.sql");
    }

    @Test
    void getAllSuccessTest(){
        List<Brand> brands = brandDao.getAll();
        assertEquals(2, brands.size());
    }

    @Test
    void getByIdTest() {
        Brand brand = brandDao.getById(1);
        String brandString = brand.toString();
        logger.debug(brandString);
        assertNotNull(brand);
        Country country = new Country(9, "United States");
        Brand expected = new Brand(1, "Ford", country);
        String expectedToString = expected.toString();
        logger.debug(expectedToString);
        assertEquals(expectedToString, brandString);
    }

    @Test
    void deleteTest() {
        //trim, because there are no dependencies.
        trimDao.delete(1);
        assertNull(trimDao.getById(1));
    }

    @Test
    void insertTest() {
        int oldLinesCt = trimDao.getAll().size();
        Trim trim = new Trim(modelDao.getById(1), "XLT", "Mid Sized Pickup Truck: Long Bed", 18, "NA", engineDao.getById(2), driveTrainDao.getById(3), transmissionDao.getById(1));
        trimDao.insert(trim);
        int newLineCt = trimDao.getAll().size();
        assertEquals(oldLinesCt, newLineCt);
    }

    @Test
    void saveOrUpdateTest() {
        String stringToUpdate = "4WD";
        driveTrainDao.getById(3).setType(stringToUpdate);
        DriveTrain driveTrain = new DriveTrain(3, stringToUpdate);
        driveTrainDao.saveOrUpdate(driveTrain);
        assertEquals(stringToUpdate, driveTrainDao.getById(3).getType());
    }

    @Test
    void findByPropertyEqualTest() {

    }
}