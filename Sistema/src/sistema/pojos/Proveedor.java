
package sistema.pojos;


public class Proveedor {
    private int id_proveedor;
    private String nomProveedor;
    private String dir_proveedor;
    private String telefonoProveedor;
    private String emailProveedor;
    private String contactoProveedor;

    public Proveedor(int id_proveedor, String nomProveedor, String dir_proveedor, String telefonoProveedor, String emailProveedor, String contactoProveedor) {
        this.id_proveedor = id_proveedor;
        this.nomProveedor = nomProveedor;
        this.dir_proveedor = dir_proveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.contactoProveedor = contactoProveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getDir_proveedor() {
        return dir_proveedor;
    }

    public void setDir_proveedor(String dir_proveedor) {
        this.dir_proveedor = dir_proveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }

    @Override
    public String toString() {
        return this.nomProveedor;
    }
    
    
    
    
}
