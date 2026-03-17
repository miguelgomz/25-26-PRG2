public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        if (denominador == 0) {
            this.denominador = 1;
        } else {
            this.denominador = denominador;
        }
        simplificar();
    }

    private int calcularMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    private void simplificar() {
        int mcd = calcularMCD(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    public void sumar(Fraccion otra) {
        this.numerador = (this.numerador * otra.denominador) + (otra.numerador * this.denominador);
        this.denominador = this.denominador * otra.denominador;
        simplificar();
    }

    public void restar(Fraccion otra) {
        this.numerador = (this.numerador * otra.denominador) - (otra.numerador * this.denominador);
        this.denominador = this.denominador * otra.denominador;
        simplificar();
    }

    public void multiplicar(Fraccion otra) {
        this.numerador *= otra.numerador;
        this.denominador *= otra.denominador;
        simplificar();
    }

    public void dividir(Fraccion otra) {
        this.numerador *= otra.denominador;
        this.denominador *= otra.numerador;
        simplificar();
    }

    public void potenciar(int exponente) {
        this.numerador = (int) Math.pow(this.numerador, exponente);
        this.denominador = (int) Math.pow(this.denominador, exponente);
        simplificar();
    }

    public void invertir() {
        if (numerador != 0) {
            int temp = numerador;
            numerador = denominador;
            denominador = temp;
            simplificar();
        }
    }

    public void oponer() {
        this.numerador = -this.numerador;
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    public Fraccion clonar() {
        return new Fraccion(this.numerador, this.denominador);
    }

    public boolean esMayor(Fraccion otra) {
        return (double) this.numerador / this.denominador > (double) otra.numerador / otra.denominador;
    }

    public boolean esMenor(Fraccion otra) {
        return (double) this.numerador / this.denominador < (double) otra.numerador / otra.denominador;
    }

    public boolean equals(Fraccion otra) {
        return this.numerador == otra.numerador && this.denominador == otra.denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}