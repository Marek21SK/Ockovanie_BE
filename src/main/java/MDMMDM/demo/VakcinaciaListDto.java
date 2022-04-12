package MDMMDM.demo;

public class VakcinaciaListDto {
    private Long id;
    private Long vakcinaId;
    private Long osobaId;
    private String nazovVakciny;
    private String menoOsoba;
    private String priezviskoOsoba;

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

    public String getNazovVakciny() {
        return nazovVakciny;
    }

    public void setNazovVakciny(String nazovVakciny) {
        this.nazovVakciny = nazovVakciny;
    }

    public String getMenoOsoba() {
        return menoOsoba;
    }

    public void setMenoOsoba(String menoOsoba) {
        this.menoOsoba = menoOsoba;
    }

    public String getPriezviskoOsoba() {
        return priezviskoOsoba;
    }

    public void setPriezviskoOsoba(String priezviskoOsoba) {
        this.priezviskoOsoba = priezviskoOsoba;
    }
}
