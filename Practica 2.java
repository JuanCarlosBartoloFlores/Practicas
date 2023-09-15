Class employee
package Practica2;
public abstract class Empleado {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) throws SalarioInvalidoException {
        if (salario <= 0) {
            throw new SalarioInvalidoException("El salario no puede ser negativo o igual a cero.");
        }
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public abstract double calcularSalario();
}

Class EmployeeHourly extends Employee
package Practica2;
public class EmpleadoPorHora extends Empleado {
    private double horasTrabajadas;
    private double valorPorHora;

    public EmpleadoPorHora(String nombre, double salario, double horasTrabajadas, double valorPorHora) throws SalarioInvalidoException {
        super(nombre, salario);
        this.horasTrabajadas = horasTrabajadas;
        this.valorPorHora = valorPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * valorPorHora;
    }
}

Class EmployeeSalaried extends Employee implements Bonusable
package Practica2;
public class EmpleadoAsalariado extends Empleado implements Bonificable{
    private int diasTrabajados;

    public EmpleadoAsalariado(String nombre, double salario, int diasTrabajados) throws SalarioInvalidoException {
        super(nombre, salario);
        this.diasTrabajados = diasTrabajados;
    }

    @Override
    public double calcularSalario() {
        return getSalario();
    }

    @Override
    public double calcularBonificacion() {
        // Implementa la lógica para calcular la bonificación aquí
        return 0.1 * getSalario(); // Ejemplo: 10% del salario como bonificación
    }
}

Class Salary Invalid Exception extends Exception
package Practica2;
public class SalarioInvalidoException extends Exception{
    public SalarioInvalidoException(String mensaje) {
        super(mensaje);
    }
}

Interface Bonusable
package Practica2;

public interface Bonificable {
    double calcularBonificacion();
}

Class Execute
package Practica2;

public class Ejecutar {
    public static void main(String[] args) {
        try {
            EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora("Juan", 0, 40, 20);
            EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Ana", 2500, 20);

            double salarioPorHora = empleadoPorHora.calcularSalario();
            double salarioAsalariado = empleadoAsalariado.calcularSalario();

            System.out.println("Nombre del empleado por hora: " + empleadoPorHora.getNombre());
            System.out.println("Salario por hora: " + salarioPorHora);

            System.out.println("Nombre del empleado asalariado: " + empleadoAsalariado.getNombre());
            System.out.println("Salario asalariado: " + salarioAsalariado);

            if (empleadoAsalariado instanceof Bonificable) {
                double bonificacion = ((Bonificable) empleadoAsalariado).calcularBonificacion();
                System.out.println("Bonificación: " + bonificacion);
            }
        } catch (SalarioInvalidoException e) {
            System.err.println("Error al crear empleado con salario negativo o igual a cero: " + e.getMessage());
        }
    }
}

