
package cwiczenie1;

public class BrylaSztywna {
    
    int totalMass=0;
    int xMass=0;
    int yMass=0;
    int zMass=0;
    
    int inertiaX=0;
    int inertiaY=0;
    int inertiaZ=0;
    
    int[] mass = {1,2,3,4,5};
    int[] wspx = {2,3,4,5,6};
    int[] wspy = {3,4,5,6,7};
    int[] wspz = {4,5,6,7,8};
    
    public void Infrom(){ //wyświetla nagłówek
        System.out.println("Moment bezwładności wzgl. osi przechodzącej przez środek masy: ");
        System.out.println();
    }
    
    public int totalMass(){ //liczy masę całkowitą
        for (int i=0; i<mass.length;i++){
            totalMass=totalMass+mass[i];
        }
            return totalMass;
        }
    
    public int xMass(){ //liczy sumę iloczynów wsp. x oraz masy punktów
        for (int i=0; i<wspx.length;i++){
            xMass=xMass+mass[i]*wspx[i];
        }
        return xMass;
    }
    
    public int yMass(){ //liczy sumę iloczynów wsp. y oraz masy punktów
        for (int i=0; i<wspy.length;i++){
            yMass=yMass+mass[i]*wspy[i];
        }
        return yMass;
    }
        
    public int zMass(){ //liczy sumę iloczynów wsp. z oraz masy punktów
        for (int i=0; i<wspz.length;i++){
            zMass=zMass+mass[i]*wspz[i];
        }
        return zMass;
    }
    
    public int xCentral(){ //liczy wsp. x środka masy
        return xMass()/totalMass();
    }
    
    public int yCentral(){ //liczy wsp. y środka masy
        return yMass()/totalMass();
    }
    
    public int zCentral(){ //liczy wsp. x środka masy
        return zMass()/totalMass();
    }
    
    public void massCenter(){
        System.out.println("Środek masy w punkcie: ("+xCentral()+","+yCentral()+","+zCentral()+").");
    }

    public int inertiaZ(){ //moment bezwł. wzgl. osi z
        for (int i=0;i<mass.length;i++){
            int a1=(wspx[i]-xCentral())*(wspx[i]-xCentral());
            int a2=(wspy[i]-yCentral())*(wspy[i]-yCentral());
            inertiaZ=inertiaZ+mass[i]*(a1+a2);
        }
        return inertiaZ;
    }
    
    public int inertiaY(){ //moment bezwł. wzgl. osi y
        for (int i=0;i<mass.length;i++){
            int a1=(wspx[i]-xCentral())*(wspx[i]-xCentral());
            int a2=(wspz[i]-zCentral())*(wspz[i]-zCentral());
            inertiaY=inertiaY+mass[i]*(a1+a2);
        }
        return inertiaY;
    }
        
    public int inertiaX(){ //moment bezwł. wzgl. osi x
        for (int i=0;i<mass.length;i++){
            int a1=(wspz[i]-zCentral())*(wspz[i]-zCentral());
            int a2=(wspy[i]-yCentral())*(wspy[i]-yCentral());
            inertiaX=inertiaX+mass[i]*(a1+a2);
        }
        return inertiaX;
    }
    
    public void inertiaX2(){ //wyświetla wartość mom. bezwł. wzgl. osi x
        System.out.println("Względem osi równoległej do osi x wynosi: "+inertiaX());
    }
    
    public void inertiaY2(){ //wyświetla wartość mom. bezwł. wzgl. osi y
        System.out.println("Względem osi równoległej do osi y wynosi: "+inertiaY());
    }
        
    public void inertiaZ2(){ //wyświetla wartość mom. bezwł. wzgl. osi z
        System.out.println("Względem osi równoległej do osi z wynosi: "+inertiaZ());
    }
    
}
