public class Caballo {
    private int numero;
    private int avance;

    public Caballo(int numero) {
        this.numero = numero;
        this.avance = 0;
    }
    public void correr(int longitudPista) {
        int pasos = (int) (Math.random() * 3);
        this.avance += pasos;
        if (this.avance >= longitudPista - 1) {
            this.avance = longitudPista - 1; 
        }
    }

    public int getAvance() { return this.avance; }
    public int getNumero() { return this.numero; }
}

 