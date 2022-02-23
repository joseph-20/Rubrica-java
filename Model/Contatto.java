package Model;

public class Contatto {
    //POSSIBILE SOLUZIONE 1

    //Dichiarazione variabili
    private String nome;
    private String cognome;
    private boolean security;
    private String imagePath;

    //Costruttore
    public Contatto(String n,String c,boolean sec,String im){
        nome = n;
        cognome = c;
        security=sec;
        imagePath=im;
    }

    //Getter
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public boolean getSecurity(){
        return security;
    }
    public String getImagePath(){
        return imagePath;
    }

}
