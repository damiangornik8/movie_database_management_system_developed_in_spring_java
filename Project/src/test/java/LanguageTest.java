import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})

public class LanguageTest {


    @Autowired
    ApplicationContext context;


    @Test
    public void testItalian() {

        String title = context.getMessage("add_new_director_before",null, Locale.ITALIAN);
        Assertions.assertEquals("Tutti i direttori prima di aggiungere nuovi direttori:", title);
    }
    @Test
    public void testSpanish() {

        String title = context.getMessage("add_new_director_before",null,"Default", Locale.FRENCH);
        Assertions.assertEquals("Tous les administrateurs avant d'ajouter de nouveaux administrateurs :", title);
    }



}
