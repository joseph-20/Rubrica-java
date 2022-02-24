package Model;

public class Contatto {
    private String nome;
    private String cognome;
    private String imgPath;
    private boolean security;


    public void setContatto(String name,String surname,String img,boolean sec){
        nome = name;
        cognome = surname;
        imgPath = img;
        security = sec;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
}
