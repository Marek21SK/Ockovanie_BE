package MDMMDM.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OsobaService {
    private final OsobaRepository osobaRepository;

    public OsobaService(OsobaRepository osobaRepository){
        this.osobaRepository = osobaRepository;
    }

    private static OsobaDto mapOsobaDto(OsobaEntity osobaEntity){
        OsobaDto osobaDto = new OsobaDto();

        osobaDto.setId(osobaEntity.getId());
        osobaDto.setMeno(osobaEntity.getMeno());
        osobaDto.setPriezvisko(osobaEntity.getPriezvisko());
        osobaDto.setEmail(osobaEntity.getEmail());
        osobaDto.setRodne_cislo(osobaEntity.getRodne_cislo());
        osobaDto.setKontakt(osobaEntity.getKontakt());
        osobaDto.setPohlavie(osobaEntity.getPohlavie());
        osobaDto.setBydlisko(osobaEntity.getBydlisko());
        osobaDto.setNazov(osobaEntity.getNazov());
        return osobaDto;
    }

    //LIST OF OSÔB
    @Transactional
    public List<OsobaDto> vytvorenieOsob(String osobaPriezvisko){
        List<OsobaDto> ret = new LinkedList<>();
        for (OsobaEntity o1 : osobaRepository.findAll()){
            OsobaDto o2 = mapOsobaDto(o1);
            ret.add(o2);
        }
        return ret;
    }

    //CREATE OSOBA
    @Transactional
    public Long vytvorenieOsoby(OsobaDto osobaDto){
        OsobaEntity osobaEntity = new OsobaEntity();

        osobaEntity.setMeno(osobaDto.getMeno());
        osobaEntity.setPriezvisko(osobaDto.getPriezvisko());
        osobaEntity.setEmail(osobaDto.getEmail());
        osobaEntity.setRodne_cislo(osobaDto.getRodne_cislo());
        osobaEntity.setKontakt(osobaDto.getKontakt());
        osobaEntity.setPohlavie(osobaDto.getPohlavie());
        osobaEntity.setBydlisko(osobaDto.getBydlisko());
        osobaEntity.setNazov(osobaDto.getNazov());

        this.osobaRepository.save(osobaEntity);
        return osobaEntity.getId();
    }
    //GET OSOBA BY ID
    @Transactional
    public OsobaDto vytvorenieOsobyId(Long osobaId){
        for (OsobaEntity o1 : osobaRepository.findAll()){
            if (o1.getId().equals(osobaId)){
                OsobaDto o2 = mapOsobaDto(o1);
                return o2;
            }
        }
        return null;
    }

    //DELETE OSOBA
    @Transactional
    public void deleteOsoba(Long osobaId){
        Optional<OsobaEntity> byId = osobaRepository.findById(osobaId);
        if (byId.isPresent()){
            osobaRepository.delete(byId.get());
        }
    }

    //UPDATE OSOBA
    @Transactional
    public void putOsoba(Long osobaId, OsobaDto osobaDto){
        Optional<OsobaEntity> byId = osobaRepository.findById(osobaId);
        if (byId.isPresent()){
            byId.get().setMeno(osobaDto.getMeno());
            byId.get().setPriezvisko(osobaDto.getPriezvisko());
            byId.get().setEmail(osobaDto.getEmail());
            byId.get().setRodne_cislo(osobaDto.getRodne_cislo());
            byId.get().setKontakt(osobaDto.getKontakt());
            byId.get().setPohlavie(osobaDto.getPohlavie());
            byId.get().setBydlisko(osobaDto.getBydlisko());
            byId.get().setNazov(osobaDto.getNazov());
            byId.get().setId(osobaDto.getId());
        }
    }
}
