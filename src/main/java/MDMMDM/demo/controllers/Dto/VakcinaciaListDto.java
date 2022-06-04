package MDMMDM.demo.controllers.Dto;

public class VakcinaciaListDto {
    private Long id;
    private Long vakcinaId;
    private Long osobaId;
    private String osobaMeno;
    private String osobaPriezvisko;
    private String nazovVakcin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVakcinaId() {
        return vakcinaId;
    }

    public void setVakcinaId(Long vakcinaId) {
        this.vakcinaId = vakcinaId;
    }

    public Long getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(Long osobaId) {
        this.osobaId = osobaId;
    }

    public String getOsobaMeno() {
        return osobaMeno;
    }

    public void setOsobaMeno(String osobaMeno) {
        this.osobaMeno = osobaMeno;
    }

    public String getOsobaPriezvisko() {
        return osobaPriezvisko;
    }

    public void setOsobaPriezvisko(String osobaPriezvisko) {
        this.osobaPriezvisko = osobaPriezvisko;
    }

    public String getNazovVakcin() {
        return nazovVakcin;
    }

    public void setNazovVakcin(String nazovVakcin) {
        this.nazovVakcin = nazovVakcin;
    }
}
