
public class SimEngine { //przechowywanie danych układu
    private float masa;
    private float k;
    private float C;
    private float L0;
    private float pktzawx;
    private float pktzawy;
    private float x;
    private float xx;
    private float y;
    private float yy;
    private float g=(float)9.81;
    float KrokCzas;
    
        public float returnPrzyspZiem(){
            return g;
        }
    
        public float setMasa(float masa){ //akcesor, ustawia wartość masy, poniżej pozostałe akcesory z parametrem
        if(masa>0){    
        this.masa=masa; 
        }
        return this.masa;
        }
        
        public float returnMasa() //akcesor, zwraca wartość masy, poniżej pozostałe akcesory bez parametru
        {
        return this.masa;
        }
        
        public float setSprez(float k){ 
        if(k>0){    
        this.k=k; 
        }
        return this.k;
        }
        
        public float returnSprez()
        {
        return this.k;
        }
        
        public float setTlum(float C){
        if(C>0){    
        this.C=C; 
        }
        return this.C;
        }
        
        public float returnTlum()
        {
        return this.k;
        }
        
        public float setPolX(float x){
        if(x>0){    
        this.x=x; 
        }
        return this.x;
        }
        
        public float returnPolX() 
        {
        return this.x;
        }
        
        
        public float setPrPoczX(float xx){ 
           
        this.xx=xx; 
      
        return this.xx;
        }
        
        public float returnPrPoczX() 
        {
        return this.xx;
        }
        
        public float setPolY(float y){ 
        if(y>0){    
        this.y=y; 
        }
        return this.y;
        }
        
        public float returnPolY() 
        {
        return this.y;
        }
        
        
        public float setPrPoczY(float yy){ 
           
        this.yy=yy; 
        
        return this.yy;
        }
        
        public float returnPrPoczY() 
        {
        return this.yy;
        }
        
        public float setPktZawX(float pktzawx){ 
        if(pktzawx>0){    
        this.pktzawx=pktzawx; 
        }
        return this.pktzawx;
        }
        
        public float returnPunktZawX() 
        {
        return this.pktzawx;
        }
        
        public float setPktZawY(float pktzawy){ 
        if(pktzawy>0){    
        this.pktzawy=pktzawy; 
        }
        return this.pktzawy;
        }
        
        public float returnPunktZawY() 
        {
        return this.pktzawy;
        }
        
        
        public float setDlSprez(float L0){ 
        if(L0>0){    
        this.L0=L0; 
        }
        return this.L0;
        }
        
        public float returnDlSprez() 
        {
        return this.L0;
        }
    
    //konstruktor z parametrami - ustala wszystkie wartości    
    public SimEngine(float masa, float k, float C, float L0, float pktzawx, float pktzawy, float x, float y , float xx, float yy){
        this.masa=masa;
        this.k=k;
        this.C=C;
        this.L0=L0;
        this.pktzawx=pktzawx;
        this.pktzawy=pktzawy;
        this.x=x;
        this.y=y;
        this.xx=xx;
        this.yy=yy;
    }
    
    public void PrzebiegSym(float krokczas){ //metoda obliczająca przebieg symulacji
        this.KrokCzas=krokczas;
        Vector2D wektor1 = new Vector2D(this.x,this.y);
        Vector2D wektor2 = new Vector2D(this.xx,this.yy);
        Vector2D wektor3 = new Vector2D(this.x-this.pktzawx,this.y-this.pktzawy);
        Vector2D Fs = new Vector2D(-(this.x-this.pktzawx)*k,-(this.y-this.pktzawy)*k); //wektor siły sprężystości
        Vector2D Ft = new Vector2D(-this.xx*C,-this.yy*C); //wektor siły tłumienia
        Vector2D Fg= new Vector2D(0,this.masa*this.g); //wektro siły grawitacji
        Vector2D Fw = new Vector2D(Fs.x+Ft.x+Fg.x,Fs.y+Ft.y+Fg.y); //wektor siły wypadkowej
        Vector2D przysp = new Vector2D(Fw.x/this.masa,Fw.y/this.masa); //wektor przyspieszenia
        wektor2=wektor2.suma(przysp.iloczyn(KrokCzas)); //nowa szybkość 
        wektor1=wektor1.suma(wektor2.iloczyn(KrokCzas)); //nowe położenie
        this.x=wektor1.x;
        this.y=wektor1.y;
        this.xx=wektor2.x;
        this.yy=wektor2.y;
        }
        
    //metoda resetująca symulację
    public void Reset(){
        setPrPoczX(0);
        setPrPoczY(0);
    }
}
    

