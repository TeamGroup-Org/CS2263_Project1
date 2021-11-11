package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CorporationTrayTest {
    @Test
    public void testConstructor(){
        CorporationTray ct = new CorporationTray();
        assertNotNull(ct);
    }
}
