package MDMMDM.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Duration;
import java.time.LocalDate;

public class OsobaDto {
    private Long id;
    private String meno;
    private String priezvisko;
    private String email;
    private String rodneCislo;
    private String kontakt;
    private String pohlavie;
    private String bydlisko;
    private String nazovVakciny;
    private Integer pocetDavok;

    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate zaockovanostDo;

    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate zaockovanostOd;

    long thirty = Duration.between(zaockovanostOd, zaockovanostDo).toDays();

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
        return rodneCislo;
    }

    public void setRodne_cislo(String rodneCislo) {
        this.rodneCislo = rodneCislo;
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

    public String getNazovVakciny() {
        return nazovVakciny;
    }

    public void setNazovVakciny(String nazovVakciny) {
        this.nazovVakciny = nazovVakciny;
    }

    public Integer getPocet_davok(){
        return this.pocetDavok;
    }

    public void setPocet_davok(Integer pocetDavok){
        this.pocetDavok = pocetDavok;
    }

    public LocalDate getZaockovanostDo() {
        return zaockovanostDo;
    }

    public void setZaockovanostDo(LocalDate zaockovanostDo) {
        this.zaockovanostDo = zaockovanostDo;
    }

    public LocalDate getZaockovanostOd() {
        return zaockovanostOd;
    }

    public void setZaockovanostOd(LocalDate zaockovanostOd) {
        this.zaockovanostOd = zaockovanostOd;
    }



    }

