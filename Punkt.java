package cwiczenie1;

public class Punkt {
    private int masa; //deklaracja masy
    
    public Punkt(){ //konstruktor domyślny
    this.masa=1;
    }
    
    public Punkt(int masa1){ //konstruktor z parametrem
        if (masa1>0){
            this.masa=masa1;
        }
        else{
            System.out.println("Masa musi być większa od zera!");
        }  
    }
    
    public int returnMasa() //akcesor, zwraca wartość masy
    {
        return this.masa;
    }
    
    public int changeMasa(int masa1){ //akcesor, zmienia wartość masy
            this.masa=masa1;
            return this.masa;
        }
     
     public void Descript(){
         System.out.println("Punkt materialny");
     }
     
     public int momInertia(){ //metoda licząca moment bezwładności
         return masa*0*0;
     }
     
     public int Steiner(int rad){ //metoda licząca moment bezwładności z tw. Steinera
         return momInertia()+masa*rad*rad;
     }
}
