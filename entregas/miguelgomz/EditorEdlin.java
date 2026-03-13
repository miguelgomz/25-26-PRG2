import java.util.Scanner;

public class EditorEdlin {

    private static String[] documento = new String[10];
    private static int filaSeleccionada = 0; 

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String entradaUsuario = "";

        for (int i = 0; i < documento.length; i++) {
            documento[i] = "";
        }

        while (!entradaUsuario.equalsIgnoreCase("S")) {
            renderizarInterfaz();
            System.out.print("Ingrese comando: ");
            entradaUsuario = lector.nextLine().toUpperCase();

            if (entradaUsuario.equals("L")) {
                System.out.print("Número de fila a activar: ");
                filaSeleccionada = Integer.parseInt(lector.nextLine());
            } else if (entradaUsuario.equals("E")) {
                System.out.print("Escriba el contenido: ");
                documento[filaSeleccionada] = lector.nextLine();
            } else if (entradaUsuario.equals("B")) {
                documento[filaSeleccionada] = "";
            } else if (entradaUsuario.equals("I")) {
                System.out.print("Intercambiar con la posición: ");
                int destino = Integer.parseInt(lector.nextLine());
                String temporal = documento[filaSeleccionada];
                documento[filaSeleccionada] = documento[destino];
                documento[destino] = temporal;
            }
        }
        System.out.println("Cerrando el editor...");
        lector.close();
    }

    public static void renderizarInterfaz() {
        System.out.println("==================================================");
        for (int n = 0; n < documento.length; n++) {
            String puntero = (n == filaSeleccionada) ? "*" : " ";
            System.out.printf("%d:%s| %s%n", n, puntero, documento[n]);
        }
        System.out.println("==================================================");
        System.out.println("Opciones: [L]ínea | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }
}