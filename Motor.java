package clasep2102025;

public class Motor {

    private String tipo;
    private String Gaso;
    private int caballos;
    private int cantidadCarburante;

    public Motor(String tipo, String Gaso, int caballos, int cantidadCarburante) {
        this.tipo = tipo;
        this.Gaso = Gaso;
        this.caballos = caballos;
        this.cantidadCarburante = cantidadCarburante;
    }

    // Método original (Inyección simple, consume 1L)
    public void inyectarCarburante() {
        inyectarCarburante("Normal"); // Redirige a la versión sobrecargada con modo por defecto
    }

    // MÉTODO SOBRECARGADO: Inyección con Modo de Conducción
    public void inyectarCarburante(String modo) {
        int consumo;

        switch (modo.toLowerCase()) {
            case "eco":
                consumo = 1; // Mínimo consumo
                break;
            case "sport":
                consumo = 3; // Máximo consumo
                break;
            case "normal":
            default:
                consumo = 2; // Consumo estándar
                break;
        }

        if (cantidadCarburante >= consumo) {
            System.out.println("Motor " + this.tipo + " con " + this.caballos + " Caballos de fuerza y esta Inyectando carburante " + this.Gaso + ".");
            System.out.println("🔥 [Modo " + modo.toUpperCase() + "] Consumo: " + consumo + "L.");
            
            this.cantidadCarburante -= consumo;
            
            System.out.println("Nivel de combustible restante: " + this.cantidadCarburante + "L");
        } else {
            System.out.println("El motor " + this.tipo + " está sin suficiente combustible (" + this.cantidadCarburante + "L) para el modo " + modo.toUpperCase() + " (requiere " + consumo + "L).");
        }
    }
}
