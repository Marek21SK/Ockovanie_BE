package MDMMDM.demo.controllers.Dto;

public class VakcinaDto {
    private Long id;
    private String nazov;
    private String vyrobca;
    private String pocet_davok;
    private String trvacnost;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNazov(){
        return this.nazov;
    }
    public void setNazov(String nazov){
        this.nazov = nazov;
    }

    public String getVyrobca(){
        return this.vyrobca;
    }
    public void setVyrobca(String vyrobca){
        this.vyrobca = vyrobca;
    }
    public String getPocet_davok(){
        return this.pocet_davok;
    }
    public void setPocet_davok(String pocet_davok){
        this.pocet_davok = pocet_davok;
    }
    public String getTrvacnost(){
        return this.trvacnost;
    }
    public void setTrvacnost(String trvacnost){
        this.trvacnost = trvacnost;
    }
}
