public class Buscaminas {
    private static final int ALTO = 5;
    private static final int ANCHO = 7;
    private static final char VACIO = '-';

    private char[][] malla;

    public static void main(String[] args) {
        new Buscaminas().ejecutar();
    }

    public void ejecutar() {
        prepararMalla();
        System.out.println("--- BUSCAMINAS v1.0 ---");
        dibujarMalla();
    }

    private void prepararMalla() {
        malla = new char[ALTO][ANCHO];
        for (int f = 0; f < ALTO; f++) {
            for (int c = 0; c < ANCHO; c++) {
                malla[f][c] = VACIO;
            }
        }
    }

    private void dibujarMalla() {
        System.out.println("=======================");
        for (int f = 0; f < ALTO; f++) {
            System.out.print((f + 1) + " | "); 
            for (int c = 0; c < ANCHO; c++) {
                System.out.print(malla[f][c] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
}