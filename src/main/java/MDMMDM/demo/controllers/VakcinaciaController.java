package MDMMDM.demo.controllers;

import MDMMDM.demo.controllers.Dto.VakcinaciaDto;
import MDMMDM.demo.controllers.Dto.VakcinaciaListDto;
import MDMMDM.demo.exceptions.InvalidVaccinationException;
import MDMMDM.demo.service.VakcinaciaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
public class VakcinaciaController {
    private VakcinaciaService vakcinaciaService;

    public VakcinaciaController(VakcinaciaService vakcinaciaService){
        this.vakcinaciaService = vakcinaciaService;
    }

    @GetMapping("/api/vakcinacie")
    public List<VakcinaciaListDto> getVakciny(@RequestParam(required = false)Long vakcinaciaId){
        return  vakcinaciaService.getVakcinacie(vakcinaciaId);
    }

    @GetMapping("api/vakcinacie/{vakcinaciaId}")
    public VakcinaciaListDto getAllVakcinacie(@PathVariable Long vakcinaciaId){
        return vakcinaciaService.getVakcinacia(vakcinaciaId);
    }

    @PostMapping("/api/vakcinacie")
    public Long createVakcinacia(@RequestBody VakcinaciaDto vakcinaciaDto) throws HttpServerErrorException {
        try {
            return vakcinaciaService.createVakcinacia(vakcinaciaDto);
        } catch (InvalidVaccinationException e) {
            throw new HttpServerErrorException(HttpStatus.CONFLICT, "Invalid parameters");
        }
    }

    @DeleteMapping("/api/vakcinacie/{vakcinaciaId}")
    public void  deleteVakcinacia(@PathVariable Long vakcinaciaId){
        vakcinaciaService.deleteVakcinacia(vakcinaciaId);
    }
}
