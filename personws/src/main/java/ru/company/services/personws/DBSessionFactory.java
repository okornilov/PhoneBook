package ru.company.services.personws;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.company.services.personws.domain.DataBase;
import ru.company.services.personws.domain.Person;

public class DBSessionFactory {

    private final static Logger logger = Logger.getLogger(DBSessionFactory.class);
    private static SessionFactory sessionFactory;

    static {
        init();
    }

    public static void init(){
        logger.debug("init session factory");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception x){
            System.err.println("No def postgresql Driver in classpath!");
        }


        DataBase database = ConfigUtils.getDataBase();

        if (database == null){
            logger.error("database params not found");
        }

        Configuration cfg = new Configuration()
                .addAnnotatedClass(Person.class);

        cfg.setProperty("hibernate.connection.url", database.getUrl());
        cfg.setProperty("hibernate.connection.username", database.getUser());
        cfg.setProperty("hibernate.connection.password", database.getPassword());
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());

        sessionFactory = cfg.buildSessionFactory(builder.build());
    }


    private DBSessionFactory(){
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

    public static void destroy(){
        sessionFactory.close();
    }
}
