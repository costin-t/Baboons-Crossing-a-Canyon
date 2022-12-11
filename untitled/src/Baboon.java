public class Baboon implements Runnable{
    //Variabile private
    private String nume;
    private Bridge bridge;
    public Baboon(Bridge bridge){
        this.bridge = bridge; //Se aseaza babuinul pe pod pentru transversare
    }

    //Functia care implementeaza deplasarea babuinul pe pod (stanga sau dreapta)
    public void run(){
        bridge.crossBridge(this);
    }
    //Metoda pentru afisearea numelui babuinului
    public String getNume(){
        return nume;
    }
    //Metoda pentru definirea numelui babuinului
    public void setNume(String nume){
        this.nume = nume;
    }
}
