package MDMMDM.demo;

import org.springframework.web.bind.annotation.*;

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
    public Long createVakcinacia(@RequestBody VakcinaciaDto vakcinaciaDto){
        return vakcinaciaService.createVakcinacia(vakcinaciaDto);
    }

    @DeleteMapping("/api/vakcinacie/{vakcinaciaId}")
    public void  deleteVakcinacia(@PathVariable Long vakcinaciaId){
        vakcinaciaService.deleteVakcinacia(vakcinaciaId);
    }
}
