package MDMMDM.demo;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

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

    @Column(name = "datum", columnDefinition = "DATE")
    private LocalDate datum;

    long five = Duration.between(osoba.getZaockovanostOd(), osoba.getZaockovanostOd()).toDays();

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

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}

