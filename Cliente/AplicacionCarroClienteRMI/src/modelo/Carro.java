
package modelo;

import java.io.Serializable;

public class Carro implements Serializable{
    private String placa;
    private String modelo;
    private String color;

    public Carro(String placa, String modelo, String color) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Carro{" + "placa=" + placa + ", modelo=" + modelo + ", color=" + color + '}';
    }
}
