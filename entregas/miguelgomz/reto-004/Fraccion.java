class Fraccion {
    private final int numerador;
    private final int denominador;

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser cero.";
        
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = calcularMCD(numerador, denominador);
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
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

    public Fraccion sumar(Fraccion otra) {
        int numerador = (this.numerador * otra.denominador) + (otra.numerador * this.denominador);
        int denominador = this.denominador * otra.denominador;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion restar(Fraccion otra) {
        int numerador = (this.numerador * otra.denominador) - (otra.numerador * this.denominador);
        int denominador = this.denominador * otra.denominador;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion multiplicar(Fraccion otra) {
        int numerador = this.numerador * otra.numerador;
        int denominador = this.denominador * otra.denominador;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion dividir(Fraccion otra) {
        int numerador = this.numerador * otra.denominador;
        int denominador = this.denominador * otra.numerador;
        return new Fraccion(numerador, denominador);
    }

    public Fraccion inversa() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public double toDouble() {
        return (double) numerador / denominador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraccion)) return false;
        Fraccion otra = (Fraccion) obj;
        return this.numerador == otra.numerador && this.denominador == otra.denominador;
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}