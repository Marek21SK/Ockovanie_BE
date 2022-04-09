package MDMMDM.demo;

import javax.persistence.*;

@Entity
public class VakcinaciaEntity {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "osoba_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private static OsobaEntity osoba;

    @JoinColumn(name = "vakcina_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private VakcinaciaEntity vakcina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static OsobaEntity getOsoba() {
        return osoba;
    }

    public void setOsoba(OsobaEntity osoba) {
        this.osoba = osoba;
    }

    public VakcinaciaEntity getVakcina() {
        return vakcina;
    }

    public void setVakcina(VakcinaciaEntity vakcina) {
        this.vakcina = vakcina;
    }

    public String getNazov() {
        return String.valueOf(vakcina);
    }

    public void setnazov(VakcinaciaEntity nazov) {
        this.vakcina= nazov;
    }



}

