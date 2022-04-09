package MDMMDM.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VakcinaciaController {
    private VakcinaciaService vakcinaciaService;

    public VakcinaciaController(VakcinaciaService vakcinaciaService){
        this.vakcinaciaService = vakcinaciaService;

    }
    @GetMapping("api/vakcinacia")
    public List<VakcinaciaDto> getVakcinacia(@RequestParam(required = false) Long vakcinaciaId){
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
