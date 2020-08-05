package t3b.pv.retiros.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("configIp")
@PropertySource(value = "file:EnviaRetiros.properties") 
public class HostSybase {

	@Value("${hostSB}")
	String hostSB;

	public String getHostSB() {
		return hostSB;
	}

	public void setHostSB(String hostSB) {
		this.hostSB = hostSB;
	}	
}
