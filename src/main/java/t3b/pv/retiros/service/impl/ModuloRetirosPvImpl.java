/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.retiros.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import t3b.pv.retiros.dao.ConsultasMySql;
import t3b.pv.retiros.dao.ConsultasSybase;
import t3b.pv.retiros.dto.RetirosDto;
import t3b.pv.retiros.dto.TiendaDto;
import t3b.pv.retiros.service.ModuloRetirosPv;
import t3b.pv.retiros.utils.ConfiguraConexionSybase;
import t3b.pv.retiros.utils.Utilidades;

@Service("retirosPv")
public class ModuloRetirosPvImpl implements ModuloRetirosPv {

	private static final Log log = LogFactory.getLog(ModuloRetirosPvImpl.class);

	@Autowired
	@Qualifier("configuraConexionSybase")
	private ConfiguraConexionSybase conection;

	@Autowired
	@Qualifier("consultasSybase")
	private ConsultasSybase consulSB;

	@Autowired
	@Qualifier("consultasMySql")
	private ConsultasMySql consultas;

	@Autowired
	@Qualifier("utilidades")
	private Utilidades utilidades;

	List<TiendaDto> lista = null;
	List<RetirosDto> listRetiros = null;

	public void processRetiro() {

		consultas.setConexion(conection.getCnnUnicaMysql());
		log.info("Comienza Proceso paso 1: Obtener Numero de tienda");
		lista = consultas.getNumTienda();
		log.info("Tenemos el numero de tienda: " + lista.get(0).getTclave());

		log.info("Paso 2: Obtener la IP en base al numero de tienda");
		String ipBO = Utilidades.obtieneIp(lista.get(0).getTclave());

		consulSB.setConexion(conection.getCnnUnica(ipBO, lista.get(0).getTclave()));

		log.info("Paso 3: Obtenemos el retiro en base al ID recibido");
        listRetiros = consultas.obtieneRetirosGral();
        if (!listRetiros.isEmpty()) {
            log.info("Paso 4: vamos a insertarlo en SYBASE");
            for (RetirosDto dto : listRetiros) {
                if (consulSB.insertaRetiros(ipBO, dto, lista.get(0).getTclave())) {
                    log.info("Paso 5: Si se inserta en Sybase Se actualiza en MySql");
                    consultas.actualizaRetiro(dto.getId());
                } else {
                    log.info("Algo Ocurrio y no se inserto en SYBASE");
                }
            }
        } else {
            log.info("No hay registros en BD");
        }
	}
}
