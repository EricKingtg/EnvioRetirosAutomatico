package t3b.pv.retiros;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import t3b.pv.retiros.service.ModuloRetirosPv;

@SpringBootApplication
public class EnvioRetirosAutomaticoApplication implements ApplicationRunner {
	
	private static final Log log = LogFactory.getLog(EnvioRetirosAutomaticoApplication.class);
	
	@Autowired
	@Qualifier("retirosPv")
	private ModuloRetirosPv retirosPv;

	public static void main(String[] args) {
		SpringApplication.run(EnvioRetirosAutomaticoApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("****************************************");
		log.info("*   Desarrollo Hecho Para Tiendas 3B   *");
		log.info("*     JAR Impacta Retiros en BOT       *");
		log.info("****************************************");
		
		retirosPv.processRetiro();

	}
}