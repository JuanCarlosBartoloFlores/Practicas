package Práctica1;
public class Habitacion {
    private int numero;
    private double precioPorNoche;

    public Habitacion(int numero, double precioPorNoche){
        this.numero=numero;
        this.precioPorNoche=precioPorNoche;
    }
    public double calcularCostoTotal(int numNoches) {
        return precioPorNoche * numNoches;
    }
    public int getNumero() {
        return numero;
    }
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void mostrarInformacion(){
        System.out.println("Numero de Habitacion: "+ numero);
        System.out.println("Precio porNoche: " + precioPorNoche);
    }
}
