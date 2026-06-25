package designpatterns;

public class SingletonPattern {

    public static void main(String... args) {

        // Get the single Logger instance
        Logger logger = Logger.getLogger(SingletonPattern.class);

        // Verify that the same object is returned every time
        for(int i = 0; i <= 10; i++) {
            logger.info( "Hash Code is : " + Logger.getLogger(SingletonPattern.class).hashCode() );
        }
    }
}

class Logger {

    // Holds the single instance of Logger
    private static Logger log = null;

    // Stores the class name from which logging is happening
    private String className;

    // Private constructor prevents object creation using 'new'
    private Logger() {

    }

    // Global access point to obtain Logger instance
    public static Logger getLogger(Class<?> clazz) {

        // Create Logger only once
        if(log == null) {

            // First and only Logger object creation
            log = new Logger();

            // Save caller class name
            log.className = clazz.getSimpleName();
        }

        // Return the same Logger instance every time
        return log;
    }

    // Helper method to print INFO level logs
    public void info(String msg) {
        System.out.println("[INFO] "+ className+ " "+ msg);
    }
    
    // Helper method to print ERROR level logs
    public void error(String msg) {
        System.out.println("[ERROR] "+ className+ " "+ msg);
    }
    
    // Helper method to print WARN level logs
    public void warn(String msg) {
        System.out.println("[WARN] "+ className+ " "+ msg);
    }
}


