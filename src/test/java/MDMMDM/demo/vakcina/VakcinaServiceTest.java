package MDMMDM.demo.vakcina;

import MDMMDM.demo.controllers.Dto.VakcinaDto;
import MDMMDM.demo.domain.repositories.VakcinaRepository;
import MDMMDM.demo.entity.VakcinaEntity;
import MDMMDM.demo.service.VakcinaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VakcinaServiceTest {

    @InjectMocks
    private VakcinaService vakcinaService;

    @Mock
    private VakcinaRepository vakcinaRepository;

    @Test
    public void vakcinaServiceCreateValid(){
        Long generatedId = 1L;

        VakcinaEntity fakeEntity = new VakcinaEntity().setId(generatedId)
                .setNazov("Pfizer")
                .setVyrobca("Nemecko")
                .setTrvacnost(180)
                .setPocetDavok(1);

        when(vakcinaRepository.save(any(VakcinaEntity.class)))
                .thenReturn(fakeEntity);

        VakcinaDto id =vakcinaService.vytvorenieVakcinaId(1L);

        assertEquals(generatedId, id);
        verify(vakcinaRepository, times(1)).save(any());
    }

    @Test
    public void vakcinaServiceDbFailedWrite(){
        when(vakcinaRepository.save(any(VakcinaEntity.class)))
                .thenThrow(RuntimeException.class);

        verify(vakcinaRepository, times(1)).save(any());
    }
}
