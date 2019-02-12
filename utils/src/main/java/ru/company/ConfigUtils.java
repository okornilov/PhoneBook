package ru.company;

import org.apache.log4j.Logger;
import ru.company.type.TConfig;
import ru.company.type.TDataBase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConfigUtils {

    private final static Logger logger = Logger.getLogger(TConfig.class);
    private static TConfig INSTANCE;
    private static String hostUrl;


    static {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TConfig.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            INSTANCE = (TConfig) unmarshaller.unmarshal(new File("personws-config.xml"));

            if (INSTANCE.getHostUrl() != null){
                hostUrl = INSTANCE.getHostUrl();
            } else {
                hostUrl = "http://localhost:8080";
            }
        } catch (JAXBException e) {
            logger.error(e);
        }
    }

    private ConfigUtils(){
    }

    public static TDataBase getDataBase(){
        return INSTANCE.getDatabase();
    }

    public static String getHostUrl() {
        return hostUrl;
    }
}
