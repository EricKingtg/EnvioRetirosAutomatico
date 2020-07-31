/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales Cualquier error
 * sobre esta favor de mandar correo a: emm@tiendas3b.com Para: Tiendas 3B MX
 * Fecha: 9/10/2018
 *
 */
package t3b.pv.retiros.dao.impl;

import dnn.nominae.modulobdconexion.db.Consulta;
import dnn.nominae.modulobdconexion.dto.QryRespDTO;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import t3b.pv.retiros.dao.ConsultasSybase;
import t3b.pv.retiros.dao.db.IQryRetiros;
import t3b.pv.retiros.dto.RetirosDto;

@Service("consultasSybase")
public class ConsultasSybaseImpl implements ConsultasSybase {

	private static final Log log = LogFactory.getLog(ConsultasSybaseImpl.class);
    Connection conn = null;

	public void setConexion(Connection sybase) {
		conn = sybase;
	}


    public boolean insertaRetiros(String ip, RetirosDto in, String suc) {
        log.info("ConsultasSybaseImpl.insertaRetiros");
        boolean out = false;
        if (conn != null) {
            ArrayList<Object> paramsIn = new ArrayList<>();
            paramsIn.add(in.getTclave());
            paramsIn.add(in.getRt_clave());
            paramsIn.add(in.getRt_fecha());
            paramsIn.add(in.getRt_importe());
            paramsIn.add(in.getCaja());
            paramsIn.add(in.getUserid());
            paramsIn.add(in.getVe_clave());
            paramsIn.add(in.getFp_clave());
            paramsIn.add(in.getRt_fecha());
            paramsIn.add(in.getIdturno());
            ArrayList<Integer> paramsOut = new ArrayList<Integer>();
            paramsOut.add(java.sql.Types.INTEGER);
            paramsOut.add(java.sql.Types.VARCHAR);
            QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryRetiros.INSERTA_RETIROS, paramsIn, paramsOut);
            if (resp.getRes() == 1) {
                out = true;
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(1).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            } else {
                int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
                String msg = resp.getParamOut().get(0).getValor().toString();
                log.info("La salida: " + res + " -- " + msg);
            }
        }

        return out;
    }

}
