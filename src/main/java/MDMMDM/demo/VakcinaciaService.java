package MDMMDM.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VakcinaciaService {

    private VakcinaRepository vakcinaRepository;
    private OsobaRepository osobaRepository;
    private VakcinaciaRepository vakcinaciaRepository;

    private static VakcinaciaListDto mapToVakcinaciaDto(VakcinaciaEntity vakcinaciaEntity){
        VakcinaciaListDto vakcinaciaListDto = new VakcinaciaListDto();

        vakcinaciaListDto.setId(vakcinaciaEntity.getId());
        vakcinaciaListDto.setOsobaId(vakcinaciaEntity.getOsoba().getId());
        vakcinaciaListDto.setVakcinaId(vakcinaciaEntity.getVakcina().getId());
        vakcinaciaListDto.setMeno(vakcinaciaEntity.getOsoba().getMeno());
        vakcinaciaListDto.setPriezvisko(vakcinaciaEntity.getOsoba().getPriezvisko());
        vakcinaciaListDto.setNazov(vakcinaciaEntity.getVakcina().getNazov());

        return vakcinaciaListDto;
    }
    public VakcinaciaService(VakcinaciaRepository vakcinaciaRepository, OsobaRepository osobaRepository, VakcinaRepository vakcinaRepository){
        this.vakcinaciaRepository = vakcinaciaRepository;
        this.vakcinaRepository = vakcinaRepository;
        this.osobaRepository = osobaRepository;

    }
    @Transactional
    public Long createVakcinacia(VakcinaciaDto vakcinaciaDto) {
        VakcinaciaEntity vakcinacia = new VakcinaciaEntity();

        Optional<VakcinaEntity> v1 = vakcinaRepository.findById(vakcinaciaDto.getVakcinaId());
        Optional<OsobaEntity> o1 = osobaRepository.findById(vakcinaciaDto.getOsobaId());
        VakcinaEntity vakcinaEntity = v1.get();

        return vakcinacia.getId();
    }
    @Transactional
    public VakcinaciaListDto getVakcinacia(Long vakcinaciaId) {
        Optional<VakcinaciaEntity> byId = vakcinaciaRepository.findById(vakcinaciaId);
        if (byId.isPresent()) {
            return mapToVakcinaciaDto(byId.get());
        }
        return null;
    }
    @Transactional
    public List<VakcinaciaListDto> getVakcinacie (Long vakcinaciaId){
        List<VakcinaciaListDto> vakcinacie = new LinkedList<>();
        for(VakcinaciaEntity v1 : vakcinaciaRepository.findAll()){
            VakcinaciaListDto v2 = mapToVakcinaciaDto(v1);
            vakcinacie.add(v2);
        }
        return vakcinacie;
    }

    @Transactional
    public void deleteVakcinacia (Long vakcinaciaId){
        Optional<VakcinaciaEntity> byId = vakcinaciaRepository.findById(vakcinaciaId);
        if(byId.isPresent()){
            vakcinaciaRepository.delete(byId.get());
        }
    }
}
