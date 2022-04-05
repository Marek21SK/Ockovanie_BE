package MDMMDM.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VakcinaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nazov;
    private String vyrobca;
    private String pocet_davok;
    private String trvacnost;

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNazov(){
        return nazov;
    }
    public void setNazov(String nazov){
        this.nazov = nazov;
    }

    public String getVyrobca(){
        return vyrobca;
    }
    public void setVyrobca(String vyrobca){
        this.vyrobca = vyrobca;
    }
    public String getPocet_davok(){
        return pocet_davok;
    }
    public void setPocet_davok(String nazov){
        this.pocet_davok = pocet_davok;
    }
    public String getTrvacnost(){
        return trvacnost;
    }
    public void setTrvacnost(String nazov){
        this.trvacnost = trvacnost;
    }

    }