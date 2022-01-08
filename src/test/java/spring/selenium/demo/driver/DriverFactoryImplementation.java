package spring.selenium.demo.driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactoryImplementation extends AbstractDriverFactory {


    private static final Logger LOG = LoggerFactory.getLogger(DriverFactoryImplementation.class);

    public static DriverFactoryImplementation getInstance(){
        LOG.trace("New DriverFactorySingelton instance initiated....  ***  " + Thread.currentThread().getId());
        if(driverFactorySingleton.get()==null){
            driverFactorySingleton.set(new DriverFactoryImplementation());
            setDriver();
        }
        return driverFactorySingleton.get();
    }

    @Override
    public WebDriver getDriver(){
        LOG.trace("getDriver() initialized...    ***  " + Thread.currentThread().getId());
        return webDriver.get();
    }

    @Override
    public void removeDriver(){
        LOG.trace("removeDriver() initialized...");
        webDriver.get().close();
        driverFactorySingleton.remove();
        webDriver.remove();
    }





}
