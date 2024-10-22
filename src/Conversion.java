import java.time.LocalDateTime;

public class Conversion {
    private String monedaBase;
    private String monedaObjetivo;
    private Double cantidadACambiar;
    private Double cantidadCambiada;
    private LocalDateTime tiempo;


    public Conversion(String monedaBase, String monedaObjetivo, double cantidadACambiar, double cantidadCambiada) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.cantidadACambiar = cantidadACambiar;
        this.cantidadCambiada = cantidadCambiada;
        this.tiempo = LocalDateTime.now();
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public Double getCantidadACambiar() {
        return cantidadACambiar;
    }

    public void setCantidadACambiar(Double cantidadACambiar) {
        this.cantidadACambiar = cantidadACambiar;
    }

    public Double getCantidadCambiada() {
        return cantidadCambiada;
    }

    public void setCantidadCambiada(Double cantidadCambiada) {
        this.cantidadCambiada = cantidadCambiada;
    }

    public LocalDateTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalDateTime tiempo) {
        this.tiempo = tiempo;
    }
}
