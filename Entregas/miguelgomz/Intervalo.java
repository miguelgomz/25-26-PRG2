import java.util.Scanner;

class Intervalo {
    private double medio, lon;

    public Intervalo(double medio, double lon) { 
        this.medio = medio; 
        this.lon = lon; 
    }
    public Intervalo(double lon) { this(0, lon); }
    public Intervalo() { this(0, 0); }
    public Intervalo(Intervalo i) { this(i.medio, i.lon); }

    public double getInf() { return medio - lon / 2; }
    public double getSup() { return medio + lon / 2; }

    public boolean incluye(double p) { 
        return p >= getInf() && p <= getSup(); 
    }

    public boolean incluye(Intervalo i) {
        return incluye(i.getInf()) && incluye(i.getSup());
    }

    public boolean intersecta(Intervalo i) {
        return incluye(i.getInf()) || incluye(i.getSup()) || i.incluye(this);
    }

    public Intervalo interseccion(Intervalo i) {
        assert intersecta(i);
        double inf = Math.max(getInf(), i.getInf());
        double sup = Math.min(getSup(), i.getSup());
        return new Intervalo((inf + sup) / 2, sup - inf);
    }

    public void desplazar(double d) { medio += d; }
    public void doblar() { lon *= 2; }
    public void oponer() { medio = -medio; }

    public void mostrar() {
        System.out.println("[" + getInf() + ", " + getSup() + "]");
    }

    public void recoger() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Punto medio y longitud (>0): ");
            medio = sc.nextDouble();
            lon = sc.nextDouble();
        } while (lon <= 0);
    }

    public Intervalo[] trocear(int n) {
        assert n > 1;
        Intervalo[] trozos = new Intervalo[n];
        double nuevaLon = lon / n;
        double inicio = getInf() + nuevaLon / 2;
        for (int i = 0; i < n; i++) {
            trozos[i] = new Intervalo(inicio + (i * nuevaLon), nuevaLon);
        }
        return trozos;
    }

    public Intervalo union(Intervalo i) {
        assert intersecta(i);
        double inf = Math.min(getInf(), i.getInf());
        double sup = Math.max(getSup(), i.getSup());
        return new Intervalo((inf + sup) / 2, sup - inf);
    }
}