package MDMMDM.demo;

public class VakcinaDto {
    private Long id;
    private String nazov;
    private String vyrobca;
    private Integer pocetDavok;
    private Integer trvacnost;

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
    public Integer getPocet_davok(){
        return this.pocetDavok;
    }
    public void setPocet_davok(Integer pocetDavok){
        this.pocetDavok = pocetDavok;
    }
    public Integer getTrvacnost(){
        return this.trvacnost;
    }
    public void setTrvacnost(Integer trvacnost){
        this.trvacnost = trvacnost;
    }
}
