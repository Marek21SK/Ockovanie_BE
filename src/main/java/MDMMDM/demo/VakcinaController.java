package MDMMDM.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VakcinaController {
    private VakcinaService vakcinaService;


    public VakcinaController(VakcinaService vakcinaService) {
        this.vakcinaService = vakcinaService;

    }

    //Create vakcina
    @PostMapping("/api/vakcína")
    public Long vytvorenieVakciny(@RequestBody VakcinaDto vakcina) {
        return vakcinaService.vytvorenieVakciny(vakcina);
    }


    //List of vakcina
    @GetMapping("/api/vakcina")
    public List<VakcinaDto> vytvorenieVakciny(@RequestParam(required = false) String vakcinaNazov) {
        return vakcinaService.vytvorenieVakciny(vakcinaNazov);
    }
    //Get vakcina BY ID
    @GetMapping("/api/vakcina/{vakcinaId}")
    public VakcinaDto vytvorenieVakcinaId(@PathVariable Long vakcina, Long vakcinaId){

        return vakcinaService.vytvorenieVakcinaId(vakcinaId);
    }

    //Update vakcina
    @PutMapping("/api/vakcina/{vakcinaId}")
    public void putVakcina(@PathVariable Long vakcinaId, @RequestBody VakcinaDto vakcina) {
        vakcinaService.putVakcina(vakcinaId, vakcina);
    }

    //Delete vakcina
    @DeleteMapping("/api/osoby/{vakcínaId}")
    public void deleteVakcina(@PathVariable Long vakcinaId){
        vakcinaService.deleteVakcina(vakcinaId);
    }

}