package Práctica1;
public class HabitacionSuite extends Habitacion{
    private boolean tieneJacuzzi;
    public HabitacionSuite(int numero, double precioPorNoche, boolean tieneJacuzzi) {
        super(numero, precioPorNoche);
        this.tieneJacuzzi = tieneJacuzzi;
    }
    public boolean isTieneJacuzzi() {
        return tieneJacuzzi;
    }
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tiene jacuzzi: " + (tieneJacuzzi ? "Si" : "No"));
    }
}