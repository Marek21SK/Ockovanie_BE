package MDMMDM.demo.vakcina;

import MDMMDM.demo.controllers.Dto.VakcinaDto;
import MDMMDM.demo.controllers.VakcinaController;
import MDMMDM.demo.entity.VakcinaEntity;
import MDMMDM.demo.service.VakcinaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(VakcinaController.class)
class VakcinaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VakcinaService vakcinaService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    @SneakyThrows
    public void saveVakcina(){
        when(vakcinaService.vytvorenieVakcinaId(any())).thenReturn(new VakcinaDto());

        VakcinaDto dto = new VakcinaDto()
                .setNazov("Pfizer")
                .setVyrobca("Nemecko")
                .setTrvacnost(180)
                .setPocetDavok(1);
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(
                post("/api/vakcina")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Matchers.equalTo(1)));

        verify(vakcinaService, times(1)).vytvorenieVakcinaId(any());
    }
}
