
package cwiczenie1;


public class Kula extends Punkt{
    
    
    private int promien;
        
    public int returnPromien() //akcesor, zwraca wartość promienia walca
    {
        return this.promien;
    }
    
    public int getPromien(int promien1){ //akcesor, ustala wartość promienia walca
            this.promien=promien1;
            return this.promien;
        }
    
    public Kula(){ //konstruktor domyślny
        super();
        this.promien=3;
    }
    
    public Kula(int masa1, int promien1){ //konstruktor z parametrem
        super(masa1); //wywołuje konstruktor klasy nadrzędnej
      
        if (promien1>0){
            this.promien=promien1;
        }
        else{
            System.out.println("Promien musi być większa od zera!");
        }  
    }
    
    @Override
    public int momInertia(){//obliczenie momentu bezwładności, przeciążenie metody
        return (int)(0.4*(double)(this.masa*this.promien*this.promien));
    }
    
    @Override
    public void Descript(){//wyświetlenie opisu, przeciążenie metody
         System.out.println("Nowa kula");
     }
}
