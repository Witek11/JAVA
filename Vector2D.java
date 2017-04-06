//package Cwiczenie2b;

public class Vector2D {
    float x;
    float y;
    float sumax;
    float sumay;
    float roznicax;
    float roznicay;
    float iloczynx;
    float iloczyny;
    float stala;
    float znormx;
    float znormy;
    
    
    public Vector2D(){ //konstruktor domyślny
        this.x=0;
        this.y=0;
    }
    
    public Vector2D(float x,float y){ //konstruktor z paremetrami
        this.x=x;
        this.y=y;
    }
    
    public Vector2D suma(Vector2D wek1){ //suma wektorów
        sumax=wek1.x+this.x;
        sumay=wek1.y+this.y;
        Vector2D wek2 = new Vector2D(sumax,sumay);
        return wek2;
    }
    
    public Vector2D roznica(Vector2D wek1){ //różnica wektorów
        roznicax=this.x-wek1.x;
        roznicay=this.y-wek1.y;
        Vector2D wek2 = new Vector2D(roznicax,roznicay);
        return wek2;
    }
    
    public Vector2D iloczyn(float stala){ //iloczyn wektora przez stałą
        this.stala=stala;
        iloczynx=this.x*stala;
        iloczyny=this.y*stala;
        Vector2D wek2 = new Vector2D(iloczynx,iloczyny);
        return wek2;
    }
    
    public float dlugosc(){ //długość wektora
        return (float)(Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2))); //coś z konwertowaniem
    }
    
    public Vector2D znormal(){ //wektor znormalizowany
        znormx=this.x/(float)dlugosc();
        znormy=this.y/(float)dlugosc();
        Vector2D wek3 = new Vector2D(znormx,znormy);
        return wek3;
    }
}
