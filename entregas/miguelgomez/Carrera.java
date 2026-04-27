public class Carrera {
  private Caballo[] caballos;
    private Pista pista;

    public Carrera() {
        this.pista = new Pista(40);
        this.caballos = new Caballo[2];
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo(i + 1);
        }
    }
    public void jugar() {
        boolean carreraTerminada = false;

        while (!carreraTerminada) {
            pista.mostrarPista(caballos);

            for (Caballo caballo : caballos) {
                caballo.correr(pista.getLongitud());
                if (caballo.getAvance() >= pista.getLongitud() - 1) {
                    carreraTerminada = true;
                }
            }
        }

        pista.mostrarPista(caballos);
        mostrarResultadoFinal();
    }
    public void jugar() {
        boolean carreraTerminada = false;

        while (!carreraTerminada) {
            pista.mostrarPista(caballos);

            for (Caballo caballo : caballos) {
                caballo.correr(pista.getLongitud());
                if (caballo.getAvance() >= pista.getLongitud() - 1) {
                    carreraTerminada = true;
                }
            }
        }

        pista.mostrarPista(caballos);
        mostrarResultadoFinal();
    }
 
