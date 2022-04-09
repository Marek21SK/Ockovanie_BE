package MDMMDM.demo;

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

        Optional<OsobaEntity> o1 = osobaRepository.findById(vakcinaciaDto.getOsobaId());
        Optional<VakcinaciaEntity> v1 = vakcinaciaRepository.findById(vakcinaciaDto.getVakcinaId());
        OsobaEntity osobaEntity = o1.get();

        return vakcinacia.getId();
    }
    @Transactional
    public List<VakcinaciaDto> getVakcinacia(Long vakcinaciaId){
        List<VakcinaciaDto> vakcinacia = new LinkedList<>();
        for(VakcinaciaEntity o1 : vakcinaciaRepository.findAll()){
            VakcinaciaDto o2 = mapToVakcinaciaDto(o1);
            vakcinacia.add(o2);
        }
        return vakcinacia;
    }
    @Transactional
    public void deleteVakcinacia (Long vakcinaciaId){
        Optional<VakcinaciaEntity> byId = vakcinaciaRepository.findById(vakcinaciaId);
        if(byId.isPresent()){
            VakcinaciaEntity o1 = byId.get();
            o1.getVakcina().setVakcina(o1.getVakcina());
            vakcinaciaRepository.delete(byId.get());
        }
    }
}
