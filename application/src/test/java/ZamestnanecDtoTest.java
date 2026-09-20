import com.kodat.skladovysystem.Dto.ZamestnanecDto;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

public class ZamestnanecDtoTest {

    static void main() {
        ObjectMapper mapper = new ObjectMapper();
        ZamestnanecDto dto = new ZamestnanecDto();
        dto.setId(20);
        dto.setEmail("email@zkouska.cz");
        dto.setJmeno("Ondra");
        dto.setPrijmeni("Kodat");
        mapper.writeValue(new File("zamestnanecDto.json"), dto);
        System.out.println("Zapis probehl");
    }

}
