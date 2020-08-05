/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales Cualquier error
 * sobre esta favor de mandar correo a: emm@tiendas3b.com Para: Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.retiros.dao.impl;

import t3b.pv.retiros.dao.ConsultasMySql;
import t3b.pv.retiros.dao.db.IQryRetiros;
import dnn.nominae.modulobdconexion.db.Consulta;
import dnn.nominae.modulobdconexion.dto.CampoDTO;
import dnn.nominae.modulobdconexion.dto.ColumnaDTO;
import dnn.nominae.modulobdconexion.dto.QryRespDTO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import t3b.pv.retiros.dto.RetirosDto;
import t3b.pv.retiros.dto.TiendaDto;

@Service("consultasMySql")
public class ConsultasMySqlImpl implements ConsultasMySql {

	private static final Log log = LogFactory.getLog(ConsultasMySqlImpl.class);
	Connection conn = null;

	public void setConexion(Connection mysql) {
		conn = mysql;
	}

	public List<TiendaDto> getNumTienda() {
		log.info("ConsultasMySqlImpl.getNumTienda");
		QryRespDTO resp = null;
		List<TiendaDto> listaTienda = new ArrayList<TiendaDto>();
		try {
			if (conn != null) {
				resp = new Consulta().ejecutaSelectSP(conn, IQryRetiros.CONSULTA_TIENDAS, null);
				if (resp.getRes() == 1) {
					ArrayList<ColumnaDTO> cols = resp.getColumnas();
					for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
						TiendaDto dato = new TiendaDto();
						for (ColumnaDTO col : cols) {
							switch (col.getIdTipo()) {
							case java.sql.Types.INTEGER:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString()
														.replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
								break;

							case java.sql.Types.DOUBLE:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Double.parseDouble(
														fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.FLOAT:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.DECIMAL:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.NUMERIC:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.VARCHAR:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? ""
												: fila.get(col.getEtiqueta()).getValor().toString());
								break;

							default:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? ""
												: fila.get(col.getEtiqueta()).getValor().toString());
								break;
							}
						}
						listaTienda.add(dato);
					}
				}
			}
		} catch (IllegalAccessException e) {
			log.info("Error durante la consulta a BD 1: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			log.info("Error durante la consulta a BD 2: " + e.getMessage());
		} catch (NoSuchFieldException e) {
			log.info("Error durante la consulta a BD 3: " + e.getMessage());
		} catch (SecurityException e) {
			log.info("Error durante la consulta a BD 4: " + e.getMessage());
		}
		return listaTienda;
	}

	public List<RetirosDto> obtieneRetirosGral() {
		QryRespDTO resp = null;
		List<RetirosDto> lista = new ArrayList<RetirosDto>();
		try {
			if (conn != null) {
				resp = new Consulta().ejecutaSelectSP(conn, IQryRetiros.CONSULTA_INFO_RETIROS_GRAL, null);
				if (resp.getRes() == 1) {
					ArrayList<ColumnaDTO> cols = resp.getColumnas();
					for (HashMap<String, CampoDTO> fila : resp.getDatosTabla()) {
						RetirosDto dato = new RetirosDto();
						for (ColumnaDTO col : cols) {
							switch (col.getIdTipo()) {
							case java.sql.Types.INTEGER:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString()
														.replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
								break;

							case java.sql.Types.DOUBLE:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Double.parseDouble(
														fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.FLOAT:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.DECIMAL:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.NUMERIC:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Float.parseFloat(fila.get(col.getEtiqueta()).getValor().toString()));
								break;

							case java.sql.Types.VARCHAR:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? ""
												: fila.get(col.getEtiqueta()).getValor().toString());
								break;

							case java.sql.Types.TINYINT:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? "0"
												: Integer.parseInt(fila.get(col.getEtiqueta()).getValor().toString()
														.replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
								break;

							case java.sql.Types.BIT:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? false
												: Boolean.parseBoolean(fila.get(col.getEtiqueta()).getValor().toString()
														.replaceAll(",", "").replaceAll("$", "").replaceAll(" ", "")));
								break;

							default:
								dato.getClass().getField(col.getEtiqueta()).set(dato,
										fila.get(col.getEtiqueta()).getValor() == null ? ""
												: fila.get(col.getEtiqueta()).getValor().toString());
								break;
							}
						}
						lista.add(dato);
					}
				}
			}
		} catch (IllegalAccessException e) {
			log.info("Error durante la consulta a BD 1: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			log.info("Error durante la consulta a BD 2: " + e.getMessage());
		} catch (NoSuchFieldException e) {
			log.info("Error durante la consulta a BD 3: " + e.getMessage());
		} catch (SecurityException e) {
			log.info("Error durante la consulta a BD 4: " + e.getMessage());
		}
		return lista;
	}

	public boolean actualizaRetiro(int idRegistro) {
		log.info("ConsultasMySqlImpl.actualizaRetiro");

		boolean salida = false;
		if (conn != null) {
			ArrayList<Object> paramsIn = new ArrayList<Object>();
			paramsIn.add(idRegistro);
			ArrayList<Integer> paramsOut = new ArrayList<Integer>();
			paramsOut.add(java.sql.Types.INTEGER);
			paramsOut.add(java.sql.Types.VARCHAR);
			QryRespDTO resp = new Consulta().ejecutaSP(conn, IQryRetiros.ACTUALIZA_INFO_RETIRO, paramsIn, paramsOut);
			if (resp.getRes() == 1) {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(1).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
				salida = true;
			} else {
				int res = Integer.parseInt(resp.getParamOut().get(0).getValor().toString());
				String msg = resp.getParamOut().get(0).getValor().toString();
				log.info("La salida: " + res + " -- " + msg);
			}
		}
		return salida;
	}
}
