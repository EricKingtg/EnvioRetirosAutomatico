/**
 *
 * Clase Java desarrollada por: Eric Bernardo Marin Morales
 * Cualquier error sobre esta favor de mandar correo a: emm@tiendas3b.com
 * Para:  Tiendas 3B MX
 * Fecha: 8/10/2018
 *
 */
package t3b.pv.retiros.dto;

public class RetirosDto {

    public String tclave;
    public String caja;
    public String rt_fecha;
    public int rt_clave;
    public int userid;
    public int ve_clave;
    public int fp_clave;
    public int id;
    public float rt_importe;
    public boolean status;
    public int idturno;

    @Override
    public String toString() {
        return "RetirosDto{" + "tclave=" + tclave + ", caja=" + caja + ", rt_fecha=" + rt_fecha + ", rt_clave=" + rt_clave + ", userid=" + userid + ", ve_clave=" + ve_clave + ", fp_clave=" + fp_clave + ", id=" + id + ", rt_importe=" + rt_importe + ", status=" + status + '}';
    }

    /**
     * @return the tclave
     */
    public String getTclave() {
        return tclave;
    }

    /**
     * @param tclave the tclave to set
     */
    public void setTclave(String tclave) {
        this.tclave = tclave;
    }

    /**
     * @return the caja
     */
    public String getCaja() {
        return caja;
    }

    /**
     * @param caja the caja to set
     */
    public void setCaja(String caja) {
        this.caja = caja;
    }

    /**
     * @return the rt_fecha
     */
    public String getRt_fecha() {
        return rt_fecha;
    }

    /**
     * @param rt_fecha the rt_fecha to set
     */
    public void setRt_fecha(String rt_fecha) {
        this.rt_fecha = rt_fecha;
    }

    /**
     * @return the rt_clave
     */
    public int getRt_clave() {
        return rt_clave;
    }

    /**
     * @param rt_clave the rt_clave to set
     */
    public void setRt_clave(int rt_clave) {
        this.rt_clave = rt_clave;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the ve_clave
     */
    public int getVe_clave() {
        return ve_clave;
    }

    /**
     * @param ve_clave the ve_clave to set
     */
    public void setVe_clave(int ve_clave) {
        this.ve_clave = ve_clave;
    }

    /**
     * @return the fp_clave
     */
    public int getFp_clave() {
        return fp_clave;
    }

    /**
     * @param fp_clave the fp_clave to set
     */
    public void setFp_clave(int fp_clave) {
        this.fp_clave = fp_clave;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the rt_importe
     */
    public float getRt_importe() {
        return rt_importe;
    }

    /**
     * @param rt_importe the rt_importe to set
     */
    public void setRt_importe(float rt_importe) {
        this.rt_importe = rt_importe;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the idturno
     */
    public int getIdturno() {
        return idturno;
    }

    /**
     * @param idturno the idturno to set
     */
    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

}
