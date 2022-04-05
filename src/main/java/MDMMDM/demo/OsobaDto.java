package MDMMDM.demo;

import java.util.Date;

public class OsobaDto {
    private Long id;
    private String meno;
    private String priezvisko;
    private String email;
    private String rodne_cislo;
    private String kontakt;
    private String pohlavie;
    private String bydlisko;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRodne_cislo() {
        return rodne_cislo;
    }

    public void setRodne_cislo(String rodne_cislo) {
        this.rodne_cislo = rodne_cislo;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(String pohlavie) {
        this.pohlavie = pohlavie;
    }

    public String getBydlisko() {
        return bydlisko;
    }

    public void setBydlisko(String bydlisko) {
        this.bydlisko = bydlisko;
    }
}
