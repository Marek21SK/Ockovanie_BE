package MDMMDM.demo;

import javax.persistence.*;

@Entity
public class VakcinaciaEntity  {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "osoba_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OsobaEntity osoba;

    @JoinColumn(name = "vakcina_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private VakcinaEntity vakcina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  OsobaEntity getOsoba() {
        return osoba;
    }

    public void setOsoba(OsobaEntity osoba) {
        this.osoba = osoba;
    }

    public VakcinaEntity getVakcina() {
        return vakcina;
    }

    public void setVakcina(VakcinaEntity vakcina) {
        this.vakcina = vakcina;
    }

    public String getNazov() {
        return String.valueOf(vakcina);
    }

    public void setNazov(VakcinaEntity nazov) {
        this.vakcina= nazov;
    }



}

