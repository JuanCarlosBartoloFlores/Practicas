package Práctica1;
public class HabitacionDoble extends Habitacion{
    private int numeroCamas;

    public HabitacionDoble(int numero, double precioPorNoche, int numeroCamas){
        super(numero,precioPorNoche);
        this.numeroCamas=numeroCamas;
    }
    public int getNumeroCamas(){
        return numeroCamas;
    }
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Numero de camas: "+ numeroCamas );
    }
}