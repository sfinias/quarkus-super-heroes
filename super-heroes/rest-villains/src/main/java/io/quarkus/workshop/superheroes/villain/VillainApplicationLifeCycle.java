package io.quarkus.workshop.superheroes.villain;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ProfileManager;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.jboss.logging.Logger;

@ApplicationScoped
public class VillainApplicationLifeCycle {

    private static final Logger LOGGER = Logger.getLogger(VillainApplicationLifeCycle.class);

    void onStart(@Observes StartupEvent event) {
        LOGGER.info("\n"
            + "                                                                                                                                                                 \n"
            + "                                                                                                                                                                 \n"
            + "VVVVVVVV           VVVVVVVV iiii  lllllll lllllll                     iiii                                       AAA               PPPPPPPPPPPPPPPPP   IIIIIIIIII\n"
            + "V::::::V           V::::::Vi::::i l:::::l l:::::l                    i::::i                                     A:::A              P::::::::::::::::P  I::::::::I\n"
            + "V::::::V           V::::::V iiii  l:::::l l:::::l                     iiii                                     A:::::A             P::::::PPPPPP:::::P I::::::::I\n"
            + "V::::::V           V::::::V       l:::::l l:::::l                                                             A:::::::A            PP:::::P     P:::::PII::::::II\n"
            + " V:::::V           V:::::Viiiiiii  l::::l  l::::l   aaaaaaaaaaaaa   iiiiiiinnnn  nnnnnnnn                    A:::::::::A             P::::P     P:::::P  I::::I  \n"
            + "  V:::::V         V:::::V i:::::i  l::::l  l::::l   a::::::::::::a  i:::::in:::nn::::::::nn                 A:::::A:::::A            P::::P     P:::::P  I::::I  \n"
            + "   V:::::V       V:::::V   i::::i  l::::l  l::::l   aaaaaaaaa:::::a  i::::in::::::::::::::nn               A:::::A A:::::A           P::::PPPPPP:::::P   I::::I  \n"
            + "    V:::::V     V:::::V    i::::i  l::::l  l::::l            a::::a  i::::inn:::::::::::::::n             A:::::A   A:::::A          P:::::::::::::PP    I::::I  \n"
            + "     V:::::V   V:::::V     i::::i  l::::l  l::::l     aaaaaaa:::::a  i::::i  n:::::nnnn:::::n            A:::::A     A:::::A         P::::PPPPPPPPP      I::::I  \n"
            + "      V:::::V V:::::V      i::::i  l::::l  l::::l   aa::::::::::::a  i::::i  n::::n    n::::n           A:::::AAAAAAAAA:::::A        P::::P              I::::I  \n"
            + "       V:::::V:::::V       i::::i  l::::l  l::::l  a::::aaaa::::::a  i::::i  n::::n    n::::n          A:::::::::::::::::::::A       P::::P              I::::I  \n"
            + "        V:::::::::V        i::::i  l::::l  l::::l a::::a    a:::::a  i::::i  n::::n    n::::n         A:::::AAAAAAAAAAAAA:::::A      P::::P              I::::I  \n"
            + "         V:::::::V        i::::::il::::::ll::::::la::::a    a:::::a i::::::i n::::n    n::::n        A:::::A             A:::::A   PP::::::PP          II::::::II\n"
            + "          V:::::V         i::::::il::::::ll::::::la:::::aaaa::::::a i::::::i n::::n    n::::n       A:::::A               A:::::A  P::::::::P          I::::::::I\n"
            + "           V:::V          i::::::il::::::ll::::::l a::::::::::aa:::ai::::::i n::::n    n::::n      A:::::A                 A:::::A P::::::::P          I::::::::I\n"
            + "            VVV           iiiiiiiillllllllllllllll  aaaaaaaaaa  aaaaiiiiiiii nnnnnn    nnnnnn     AAAAAAA                   AAAAAAAPPPPPPPPPP          IIIIIIIIII\n"
            + "                                                                                                                                                                 \n"
            + "                                                                                                                                                                 \n"
            + "                                                                                                                                                                 \n"
            + "                                                                                                                                                                 \n"
            + "                                                                                                                                                                 \n"
            + "                                                                                                                                                                 \n"
            + "                                                                                                                                                                 \n");

        LOGGER.info("The application VILLAIN is starting with profile " + ProfileManager.getActiveProfile());
    }

    void onStop(@Observes ShutdownEvent event) {
        LOGGER.info("The application VILLAIN is stopping...");
    }
}
