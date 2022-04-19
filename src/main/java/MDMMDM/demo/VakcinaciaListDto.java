package MDMMDM.demo;

public class VakcinaciaListDto {
    private Long id;
    private Long vakcinaId;
    private Long osobaId;

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
}
