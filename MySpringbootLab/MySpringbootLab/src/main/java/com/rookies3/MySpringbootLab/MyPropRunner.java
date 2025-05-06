import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyPropRunner implements CommandLineRunner {

    private final MyPropProperties properties;
    private static final Logger logger = LoggerFactory.getLogger(MyPropRunner.class);

    public MyPropRunner(MyPropProperties properties) {
        this.properties = properties;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Username: " + properties.getUsername());
        logger.info("Port: " + properties.getPort());
    }
}