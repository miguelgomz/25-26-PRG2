import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final int TOTAL_MINAS = 5;
    private static final char CELDA_OCULTA = '-';

    private char[][] malla;
    private boolean[][] ubicacionMinas;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Buscaminas().ejecutar();
    }

  public void  ejecutar() {
        prepararMalla();
        sembrarMinas();
        System.out.println("--- BUSCAMINAS v1.1 ---");
        dibujarMalla();
        realizarJugada(); 
    }

    private void prepararMalla() {
        malla = new char[FILAS][COLUMNAS];
        ubicacionMinas = new boolean[FILAS][COLUMNAS];
        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {
                malla[f][c] = CELDA_OCULTA;
            }
        }
    }
    private void sembrarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < TOTAL_MINAS) {
            int f = random.nextInt(FILAS);
            int c = random.nextInt(COLUMNAS);
            if (!ubicacionMinas[f][c]) {
                ubicacionMinas[f][c] = true;
                minasColocadas++;
            }
        }
    }

    private void dibujarMalla() {
        System.out.println("=======================");
        for (int f = 0; f < Filas; f++) {
            System.out.print((f + 1) + " | "); 
            for (int c = 0; c < Columnas; c++) {
                System.out.print(malla[f][c] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
    private void realizarJugada() {
        int fila = leerNumero("Fila", FILAS);
        int col = leerNumero("Columna", COLUMNAS);
        procesarCelda(fila - 1, col - 1); 
    }

    private int leerNumero(String dato, int max) {
        int valor = -1;
        while (true) {
            System.out.print("Ingrese " + dato + " (1-" + max + "): ");
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= 1 && valor <= max) return valor;
            } else {
                scanner.next(); 
            }
            System.out.println("Error: Valor inválido.");
        }
    }

    private void procesarCelda(int f, int c) {
        if (ubicacionMinas[f][c]) {
            System.out.println("¡BOOM! Había una mina en [" + (f+1) + "," + (c+1) + "]");
        } else {
            System.out.println("Celda [" + (f+1) + "," + (c+1) + "] limpia. ¡Suerte!");
        }
    }
}
