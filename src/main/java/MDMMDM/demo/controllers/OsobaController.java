package MDMMDM.demo.controllers;

import MDMMDM.demo.controllers.Dto.OsobaDto;
import MDMMDM.demo.service.OsobaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OsobaController {

    private OsobaService osobaService;

    public OsobaController(OsobaService osobaService){
        this.osobaService = osobaService;
    }

    //CREATE OSOBA
    @PostMapping("/api/osoby")
    public Long vytvorenieOsoby(@RequestBody OsobaDto osoba){
        return osobaService.vytvorenieOsoby(osoba);
    }

    //LIST OF OSÔB
    @GetMapping("/api/osoby")
    public List<OsobaDto> vytvorenieOsob(@RequestParam(required = false) String osobaPriezvisko){
        return osobaService.vytvorenieOsob(osobaPriezvisko);
    }

    //GET OSOBY BY ID
    @GetMapping("/api/osoby/{osobaId}")
    public OsobaDto vytvorenieOsobyId(@PathVariable Long osobaId){
        return osobaService.vytvorenieOsobyId(osobaId);
    }

    //UPDATE OSOBA
    @PutMapping("/api/osoby/{osobaId}")
    public void putOsoba(@PathVariable Long osobaId, @RequestBody OsobaDto osoba){
        osobaService.putOsoba(osobaId, osoba);
    }

    //DELETE OSOBA
    @DeleteMapping("/api/osoby/{osobaId}")
    public void deleteOsoba(@PathVariable Long osobaId){
        osobaService.deleteOsoba(osobaId);
    }
}
