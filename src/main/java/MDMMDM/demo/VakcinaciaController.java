package MDMMDM.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class VakcinaciaController {
    private VakcinaciaService vakcinaciaService;

    public VakcinaciaController(VakcinaciaService vakcinaciaService){
        this.vakcinaciaService = vakcinaciaService;

    }
    @GetMapping("/api/vakcinacia")
    public VakcinaciaListDto getVakcina(@RequestParam(required = false)Long vakcinaciaId){
        return  vakcinaciaService.getVakcinacia(vakcinaciaId);
    }
    @GetMapping("api/vakcinacia")
    public VakcinaciaListDto getAllVakcinacia(@PathVariable Long vakcinaciaId){
        return vakcinaciaService.getVakcinacia(vakcinaciaId);
    }
    @PostMapping("/api/vakcinacia")
    public Long createVakcinacia(@RequestBody VakcinaciaDto vakcinaciaDto){
        return vakcinaciaService.createVakcinacia(vakcinaciaDto);
    }
    @DeleteMapping("/api/vakcinacia/{vakcinaciaId}")
    public void  deleteVakcinacia(@PathVariable Long vakcinaciaId){
        vakcinaciaService.deleteVakcinacia(vakcinaciaId);
    }
}
