
package beans;

public class Rectangulo {
    private int base;
    private int altura;
    
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
    
    public int getArea(){
        return this.altura * this.base;
    }
    
        
    
}
