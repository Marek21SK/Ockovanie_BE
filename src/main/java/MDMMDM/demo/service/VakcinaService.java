package MDMMDM.demo.service;

import MDMMDM.demo.controllers.Dto.VakcinaDto;
import MDMMDM.demo.entity.VakcinaEntity;
import MDMMDM.demo.domain.repositories.VakcinaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class VakcinaService {

    private  final VakcinaRepository vakcinaRepository;


    public VakcinaService(VakcinaRepository vakcinaRepository) {
        this.vakcinaRepository = vakcinaRepository;
    }

    private static VakcinaDto mapVakcinaDto(VakcinaEntity vakcinaEntity){
        VakcinaDto vakcinaDto = new VakcinaDto();

        vakcinaDto.setId(vakcinaEntity.getId());
        vakcinaDto.setNazov(vakcinaEntity.getNazov());
        vakcinaDto.setVyrobca(vakcinaEntity.getVyrobca());
        vakcinaDto.setPocet_davok(vakcinaEntity.getPocet_davok());
        vakcinaDto.setTrvacnost(vakcinaEntity.getTrvacnost());
        return vakcinaDto;

    }
    //List of vakcina
    @Transactional
    public List<VakcinaDto> vytvorenieVakciny(String vakcinaNazov){
        List<VakcinaDto> ret = new LinkedList<>();
        for (VakcinaEntity v1 : vakcinaRepository.findAll()){
            VakcinaDto v2 = mapVakcinaDto(v1);
            ret.add(v2);
        }
        return ret;
    }
    // Create vakcina
    @Transactional
    public Long vytvorenieVakciny(VakcinaDto vakcinaDto){
        VakcinaEntity vakcinaEntity = new VakcinaEntity();

        vakcinaEntity.setVyrobca(vakcinaDto.getVyrobca());
        vakcinaEntity.setNazov(vakcinaDto.getNazov());
        vakcinaEntity.setPocet_davok(vakcinaDto.getPocet_davok());
        vakcinaEntity.setTrvacnost(vakcinaDto.getTrvacnost());

        this.vakcinaRepository.save(vakcinaEntity);
        return vakcinaEntity.getId();
    }
    //Get vakcina ID
    @Transactional
    public VakcinaDto vytvorenieVakcinaId(Long vakcinaId){
        for(VakcinaEntity v1 : vakcinaRepository.findAll()){
            if(v1.getId().equals(vakcinaId)){
                VakcinaDto v2 = mapVakcinaDto(v1);
                return v2;
            }
        }
        return null;
    }

    //Delete vakcia
    @Transactional
    public void deleteVakcina(Long vakcinaId){
        Optional<VakcinaEntity> byId = vakcinaRepository.findById(vakcinaId);
        if(byId.isPresent()){
            vakcinaRepository.delete(byId.get());
        }
    }
    //Update Vakcia
    @Transactional
    public void putVakcina(Long vakcinaId, VakcinaDto vakcinaDto){
        Optional<VakcinaEntity> byId = vakcinaRepository.findById(vakcinaId);
        if(byId.isPresent()){
            byId.get().setNazov(vakcinaDto.getNazov());
            byId.get().setVyrobca(vakcinaDto.getVyrobca());
            byId.get().setPocet_davok(vakcinaDto.getPocet_davok());
            byId.get().setTrvacnost(vakcinaDto.getTrvacnost());
            byId.get().setId(vakcinaDto.getId());
        }
    }
}