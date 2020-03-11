package modelos;

public class Operaciones {

    private int a, b;

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int suma() {
        return this.a + this.b;
    }

    public int resta() {
        return this.a - this.b;
    }

    public double division() {
        return (double) this.a / this.b;
    }

    public int multiplicacion() {
        return this.a * this.b;
    }


}
