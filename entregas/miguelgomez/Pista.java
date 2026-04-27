public class Pista {
    private int longitud;

    public Pista(int longitud) {
        this.longitud = longitud;
    }
    public void mostrarPista(Caballo[] caballos) {
        System.out.println("----------------------------------------------");
        for (Caballo caballo : caballos) {
            StringBuilder carril = new StringBuilder(); 
            for (int i = 0; i < longitud; i++) {
                if (i == caballo.getAvance()) {
                    carril.append(";-;'");
                } else {
                    carril.append(" ");
                }
            }
            System.out.println(carril.toString());
        }
        System.out.println("----------------------------------------------");
    }

    public int getLongitud() { 
        return this.longitud; 
    }
}

