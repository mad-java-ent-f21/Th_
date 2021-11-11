package com.thunderscore.util;

import com.thunderscore.persistence.GenericDao;

public class DaoFactory {

    /**
     * Empty constructor
     */
    private DaoFactory() {
    }

    /**
     * Method that creates Dao for entities of project
     * @param type
     * @return
     */
    public static GenericDao createDao(Class type) {
        return new GenericDao(type);
    }

}
