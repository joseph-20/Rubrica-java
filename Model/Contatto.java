package Model;

public class Contatto {
    private String nome;
    private String cognome;
    private String imgPath;
    private boolean security;

    // Metodo setter generale
    public void setContatto(String name, String surname, String img, boolean sec){
        nome = name;
        cognome = surname;
        imgPath = img;
        security = sec;
    }

    // Metodi setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public void setSecurity(boolean security) {
        this.security = security;
    }

    // Metodi getter
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getImgPath() {
        return imgPath;
    }
    public boolean getSecurity() {
        return security;
    }
}
