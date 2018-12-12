import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {

    @Test
    public void testaData() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime novaData = now.plusDays(10);
        System.out.println(novaData.format(DateTimeFormatter.ISO_DATE_TIME));
    }

}
