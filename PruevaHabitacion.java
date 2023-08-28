package Práctica1;
public class PruebaHotel {
    public static void main(String[] args) {
        Habitacion habitacion1 = new HabitacionIndividual(101, 120, true);
        Habitacion habitacion2 = new HabitacionDoble(202, 180,2);
        Habitacion habitacion3 = new HabitacionFamiliar(303, 260,5);
        Habitacion habitacion4 = new HabitacionSuite(303, 500,true);

        int numNoches = 5;

        System.out.println("Informacion de la primera habitacion: ");
        habitacion1.mostrarInformacion();
        System.out.println("Costo total para " + numNoches + " noches: $" + habitacion1.calcularCostoTotal(numNoches));
        System.out.println();

        System.out.println("Informacion de la segunda habitacion: ");
        habitacion2.mostrarInformacion();
        System.out.println("Costo total para " + numNoches + " noches: $" + habitacion2.calcularCostoTotal(numNoches));
        System.out.println();

        System.out.println("Informacion de la tercera habitacion: ");
        habitacion3.mostrarInformacion();
        System.out.println("Costo total para " + numNoches + " noches: $" + habitacion3.calcularCostoTotal(numNoches));
        System.out.println();

        System.out.println("Informacion de la cuarta habitacion: ");
        habitacion4.mostrarInformacion();
        System.out.println("Costo total para " + numNoches + " noches: $" + habitacion4.calcularCostoTotal(numNoches));
    }
}
