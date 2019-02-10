package ru.company.services.personws;

import org.apache.log4j.Logger;
import ru.company.services.personws.domain.Config;
import ru.company.services.personws.domain.DataBase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConfigUtils {

    private final static Logger logger = Logger.getLogger(Config.class);
    private static Config INSTANCE;


    static {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            INSTANCE = (Config) unmarshaller.unmarshal(new File("personws-config.xml"));
        } catch (JAXBException e) {
            logger.error(e);
        }
    }

    private ConfigUtils(){
    }

    public static DataBase getDataBase(){
        return INSTANCE.getDatabase();
    }

}
