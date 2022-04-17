package MDMMDM.demo;

import MDMMDM.demo.exceptions.InvalidVaccinationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
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

        return vakcinaciaListDto;
    }
    public VakcinaciaService(VakcinaciaRepository vakcinaciaRepository, OsobaRepository osobaRepository, VakcinaRepository vakcinaRepository){
        this.vakcinaciaRepository = vakcinaciaRepository;
        this.vakcinaRepository = vakcinaRepository;
        this.osobaRepository = osobaRepository;

    }
    @Transactional
    public Long createVakcinacia(VakcinaciaDto vakcinaciaDto) throws InvalidVaccinationException {

        Optional<VakcinaEntity> v1 = vakcinaRepository.findById(vakcinaciaDto.getVakcinaId());
        Optional<OsobaEntity> o1 = osobaRepository.findById(vakcinaciaDto.getOsobaId());

        if (v1.isEmpty() || o1.isEmpty()) {
            throw new InvalidVaccinationException();
        }

        OsobaEntity osoba = o1.get();
        VakcinaEntity vakcina = v1.get();

        // if(vakcina.equals(osoba.getVakcina()) { throw InvalidVaccineException() -> HTTP Status 409) }

        if (!osoba.isVaccinated()) {
            osoba.setPocet_davok(0);
            osoba.setVakcina(vakcina);
        }

        VakcinaciaEntity vakcinacia = new VakcinaciaEntity();

        vakcinacia.setOsoba(osoba);
        vakcinacia.setVakcina(vakcina);
        vakcinacia.setDatum(LocalDate.now());

        vakcinaciaRepository.save(vakcinacia);
        osoba.setPocet_davok(osoba.getPocet_davok()+ 1);
        if (osoba.getPocet_davok() >= vakcina.getPocet_davok()){
            osoba.setZaockovanostDo(LocalDate.now().plusDays(vakcina.getTrvacnost()));
        }

        osobaRepository.save(osoba);

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
