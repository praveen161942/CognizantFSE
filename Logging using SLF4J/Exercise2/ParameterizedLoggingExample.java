import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Praveen";
        int loginAttempts = 3;
        logger.info("User {} has attempted to login {} times", username, loginAttempts);
    }
}