package MDMMDM.demo;

import org.springframework.stereotype.Service;



import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VakcinaciaService {

    private VakcinaciaRepository vakcinaciaRepository;
    private OsobaRepository osobaRepository;
    private VakcinaRepository vakcinaRepository;

    private static VakcinaciaDto mapToVakcinaciaDto(VakcinaciaEntity vakcinaciaEntity){
        VakcinaciaDto vakcinaciaDto = new VakcinaciaDto();

        vakcinaciaDto.setId(vakcinaciaEntity.getId());
        vakcinaciaDto.setOsobaId(vakcinaciaEntity.getOsoba().getId());
        vakcinaciaDto.setVakcinaId(vakcinaciaEntity.getVakcina().getId());
        vakcinaciaDto.setMenoOsoba(vakcinaciaEntity.getOsoba().getMeno()+ " " +VakcinaciaEntity.getOsoba().getPriezvisko());
        vakcinaciaDto.setNazovVakciny(vakcinaciaEntity.getVakcina().getNazov());

        return vakcinaciaDto;
    }
    public VakcinaciaService(VakcinaciaRepository vakcinaciaRepository, OsobaRepository osobaRepository, VakcinaRepository vakcinaRepository){
        this.vakcinaRepository = vakcinaRepository;
        this.osobaRepository = osobaRepository;
        this.vakcinaciaRepository = vakcinaciaRepository;

    }
    @Transactional
    public Long createVakcinacia(VakcinaciaDto vakcinaciaDto) {
        VakcinaciaEntity vakcinacia = new VakcinaciaEntity();

        Optional<VakcinaciaEntity> v1 = vakcinaciaRepository.findById(vakcinaciaDto.getVakcinaId());
        Optional<OsobaEntity> o1 = osobaRepository.findById(vakcinaciaDto.getOsobaId());
        VakcinaEntity vakcinaEntity = v1.get();

        return vakcinacia.getId();
    }
    @Transactional
    public VakcinaciaListDto getVakcinacia(Long vakcinaciaId) {
        VakcinaciaDto result = null;
        Optional<VakcinaciaEntity> byId = vakcinaciaRepository.findById(vakcinaciaId);
        if (byId.isPresent()) {
            return;  = mapToVakcinaciaDto(byId.get());
        }
        return null;
    }
    @Transactional
    public List<VakcinaciaListDto> getVakcinacia(Long vakcinaciaId){
        List<VakcinaciaListDto> vakcinacia = new LinkedList<>();
        for(VakcinaciaEntity k1 : vakcinaciaRepository.findAll()){
            VakcinaciaDto k2 = mapToVakcinaciaDto(k1);
            vakcinacia.add(k2);
        }
        return vakcinacia;
    }
    @Transactional
    public void deleteVakcinacia (Long vakcinaciaId){
        Optional<VakcinaciaEntity> byId = vakcinaciaRepository.findById(vakcinaciaId);
        if(byId.isPresent()){
            VakcinaciaEntity k1 = byId.get();
            k1.getVakcina().setVakcina(k1.getVakcina());
            vakcinaciaRepository.delete(byId.get());
        }
    }
}
