package com.thunderscore;
import com.thunderscore.entity.Brand;
import com.thunderscore.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class GenericDAOTest {
    GenericDao dao;

    @BeforeEach
    void setUp(){
        dao = new GenericDao(Brand.class);
    }

    //@Test
    void getAllSuccess(){
        List<Brand> brands = dao.getAll();
        assertEquals(0, brands.size());
    }
}
