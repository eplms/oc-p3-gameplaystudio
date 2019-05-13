
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLog {

	// instance de classe avec la méthode getLogger
	private static final Logger LOG = LogManager.getLogger(MainLog.class);

	public static void main(String[] args) {
	    
		// message de log sur le format log.niveau("message")
	    LOG.debug("This Will Be Printed On Debug");
	    LOG.info("This Will Be Printed On Info");
	    LOG.warn("This Will Be Printed On Warn");
	    LOG.error("This Will Be Printed On Error");
	    LOG.fatal("This Will Be Printed On Fatal");
	    LOG.info("Appending string: {}.", "Hello, World");
	}

}
