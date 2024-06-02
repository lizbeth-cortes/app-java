
package sistema.pojos;

import java.sql.Date;

/**
 *
 * @author Lyzz
 */
public class Venta {
    private int idVenta;
    private double montoFecha;
    private Date fecha;

    public Venta(int id_venta, double monto_fecha, Date fecha) {
        this.idVenta = id_venta;
        this.montoFecha = monto_fecha;
        this.fecha = fecha;
    }
    
    public Venta( double monto_fecha, Date fecha) {
        this.montoFecha = monto_fecha;
        this.fecha = fecha;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getMontoFecha() {
        return montoFecha;
    }

    public void setMontoFecha(double montoFecha) {
        this.montoFecha = montoFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
}
