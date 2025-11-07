package clasep2102025;

public class Coche {
    private String color;
    private int velocidad;
    private float tamaño;
    private Rueda[] ruedas;
    private Motor motor;
    private String modoConduccion; // NUEVO: Define el estilo de conducción

    public Coche(String color, int velocidad, 
                 float tamaño, Rueda[] ruedas, 
                 Motor motor, String modoConduccion) { // NUEVO PARÁMETRO
        this.color = color;
        this.velocidad = velocidad;
        this.tamaño = tamaño;
        this.ruedas = ruedas;
        this.motor = motor;
        this.modoConduccion = modoConduccion; // ASIGNACIÓN
    }

    public void avanzar() {
        System.out.println("\nEl coche " + this.color + " avanza en modo: **" + this.modoConduccion.toUpperCase() + "**");

        // Llama al método sobrecargado y le pasa el modo de conducción
        motor.inyectarCarburante(this.modoConduccion);

        for (int i = 0; i < ruedas.length; i++) {
            ruedas[i].girar();
        }
        
        System.out.println("--- COCHE: Avanzando a " + this.velocidad + " km/h\n");
    }

    public static void main(String[] args) {

        Rueda[] ruedas = {new Rueda(20, "Dunlop"),
                          new Rueda(20, "Dunlop"),
                          new Rueda(22, "Dunlop"),
                          new Rueda(22, "Dunlop")};

        // --- Escenario 1: Coche Diesel en modo SPORT (Alto Consumo) ---
        System.out.println("--- PRUEBA 1: MODO SPORT ---");
        Motor motorDiesel = new Motor("Diesel", "ACPM", 1000, 5); // 5L iniciales
        // Se establece el modo Sport
        Coche miCoche = new Coche("Color pollito", 80, 3.2f, ruedas, motorDiesel, "Sport");

        miCoche.avanzar(); // 5L - 3L = 2L restantes
        miCoche.avanzar(); // 2L - 3L = Insuficiente

        // --- Escenario 2: Coche Gasolina en modo ECO (Bajo Consumo) ---
        System.out.println("\n--- PRUEBA 2: MODO ECO ---");
        Motor motorGasolina = new Motor("Gasolina", "Premium", 500, 5); // 5L iniciales
        // Se establece el modo Eco
        Coche tuCoche = new Coche("Azul", 100, 4.0f, ruedas, motorGasolina, "Eco");
        
        tuCoche.avanzar(); // 5L - 1L = 4L restantes
        tuCoche.avanzar(); // 4L - 1L = 3L restantes
        tuCoche.avanzar(); // 3L - 1L = 2L restantes
        
        // --- Escenario 3: Coche Eléctrico en modo NORMAL ---
        System.out.println("\n--- PRUEBA 3: MODO NORMAL ---");
        Motor motorElectrico = new Motor("Electrico", "Batería", 400, 5); // 5L/Unidades iniciales
        // Se establece el modo Normal
        Coche suCoche = new Coche("Negro", 150, 4.5f, ruedas, motorElectrico, "Normal");
        
        suCoche.avanzar(); // 5L - 2L = 3L restantes
    }
}
