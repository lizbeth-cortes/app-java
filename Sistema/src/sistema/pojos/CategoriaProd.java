
package sistema.pojos;

public class CategoriaProd {
    private int idCategoriaProd;
    private String nomCategoriaProd;
    private String descCategoriaProd;

    public CategoriaProd(int idCategoriaProd, String nomCategoriaProd, String descCategoriaProd) {
        this.idCategoriaProd = idCategoriaProd;
        this.nomCategoriaProd = nomCategoriaProd;
        this.descCategoriaProd = descCategoriaProd;
    }

    public int getIdCategoriaProd() {
        return idCategoriaProd;
    }

    public void setIdCategoriaProd(int idCategoriaProd) {
        this.idCategoriaProd = idCategoriaProd;
    }

    public String getNomCategoriaProd() {
        return nomCategoriaProd;
    }

    public void setNomCategoriaProd(String nomCategoriaProd) {
        this.nomCategoriaProd = nomCategoriaProd;
    }

    public String getDescCategoriaProd() {
        return descCategoriaProd;
    }

    public void setDescCategoriaProd(String descCategoriaProd) {
        this.descCategoriaProd = descCategoriaProd;
    }

    @Override
    public String toString() {
        return this.nomCategoriaProd;
    }   
    
}
