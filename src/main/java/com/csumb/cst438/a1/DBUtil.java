package com.csumb.cst438.a1;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("persistence.xml");
    
    public static EntityManagerFactory getEmFactory() {
        return EMF;
    }
}