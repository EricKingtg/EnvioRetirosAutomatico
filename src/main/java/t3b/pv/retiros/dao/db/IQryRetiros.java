/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3b.pv.retiros.dao.db;

/**
 *
 * @author emm
 */
public interface IQryRetiros {

    public static String MCU_FN_CONSULTAUSUARIOS = "{CALL MCU_FN_CONSULTADATOUSERS()}";
    public static String CONSULTA_TIENDAS = "{CALL sp_obtiene_info_tienda()}";
    public static String CONSULTA_INFO_RETIROS = "{CALL sp_obtiene_info_retiro(?)}";
    public static String INSERTA_RETIROS = "{CALL SP_INSERTA_RETIROS(?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static String ACTUALIZA_INFO_RETIRO = "{CALL sp_actuliza_info_retiro(?,?,?)}";
    public static String CONSULTA_INFO_RETIROS_GRAL = "{ CALL sp_obtiene_info_retiro_gral() }";

}