package practica_01.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "suculenta")
public class Suculenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Integer idSuculenta;

    @Column(name = "nombre_comun")
    private String nombreComun;

    @Column(name = "nombre_cientifico")
    private String nombreCientifico;

    @Column(name = "familia")
    private String familia;

    @Column(name = "color_principal")
    private String colorPrincipal;

    @Column(name = "altura_cm")
    private BigDecimal alturaCm;

    @Column(name = "precio_estimado")
    private BigDecimal precioEstimado;

    @Column(name = "nivel_riego")
    private String nivelRiego;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    public Suculenta() {
    }

    public Integer getIdSuculenta() {
        return idSuculenta;
    }

    public void setIdSuculenta(Integer idSuculenta) {
        this.idSuculenta = idSuculenta;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public BigDecimal getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(BigDecimal alturaCm) {
        this.alturaCm = alturaCm;
    }

    public BigDecimal getPrecioEstimado() {
        return precioEstimado;
    }

    public void setPrecioEstimado(BigDecimal precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public String getNivelRiego() {
        return nivelRiego;
    }

    public void setNivelRiego(String nivelRiego) {
        this.nivelRiego = nivelRiego;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}