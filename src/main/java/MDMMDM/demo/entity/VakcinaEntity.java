package MDMMDM.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class VakcinaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nazov;
    private String vyrobca;
    private Integer pocetDavok;
    private Integer trvacnost;

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
    public Integer getPocet_davok(){
        return pocetDavok;
    }
    public void setPocet_davok(Integer pocetDavok){
        this.pocetDavok = pocetDavok;
    }
    public Integer getTrvacnost(){
        return trvacnost;
    }
    public void setTrvacnost(Integer trvacnost){
        this.trvacnost = trvacnost;
    }
    }