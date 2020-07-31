package t3b.pv.retiros.dao;

import java.sql.Connection;

import t3b.pv.retiros.dto.RetirosDto;

public interface ConsultasSybase {

	public abstract void setConexion(Connection sybase);
	public abstract boolean insertaRetiros(String ip, RetirosDto in, String suc);
	
}
