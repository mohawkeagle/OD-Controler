package br.com.urcontroler.system;

import br.com.gmp.utils.annotations.Intercept;
import br.com.gmp.utils.interceptors.InterceptorModule;
import br.com.gmp.utils.system.SystemProperties;
import br.com.urcontroler.main.MainScreen;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteGlassLookAndFeel;

/**
 * Classe de inicialização da aplicação
 *
 * @author Kaciano Ghelere
 */
public class SystemManager {

    /**
     * Acesso estático aos logs
     */
    public static final Logger LOGGER = Logger.getLogger(SystemManager.class.getName());
    private static final String prop = "/br/com/urcontroler/properties/od-properties.properties";
    private static final String persistence = "Ultimate-RPG-Controler-PU";
    private final Injector injector;
    private final EntityManagerFactory emf;

    /**
     * Cria nova instancia de SystemControl
     */
    public SystemManager() {
        System.out.println("-------------------------------------------------"
                + "\nOS: " + SystemProperties.OS_NAME.toUpperCase()
                + " - " + SystemProperties.OS_ARCH
                + "\nVersão do Java: " + SystemProperties.JAVA_VERSION
                + "\nUsuário: " + SystemProperties.USER_NAME.toUpperCase()
                + "\nPasta principal: " + SystemProperties.USER_HOME
                + "\n-------------------------------------------------\n");
        this.injector = Guice.createInjector(new InterceptorModule());
        this.emf = Persistence.createEntityManagerFactory(persistence);
        File dir = new File("logs");
        if (!dir.exists()) {
            dir.mkdir();
            LOGGER.log(Level.INFO, "Diretorio de logs criado em {0}", dir.getPath());
        }
    }

    /**
     * Carrega a tela principal
     *
     * @return {@code SystemManager} Controle do sistema
     */
    @Intercept
    public SystemManager loadScreen() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceGraphiteGlassLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                MainScreen instance = injector.getInstance(MainScreen.class);
                instance.setVisible(true);
            }
        });
        return this;
    }

    /**
     * Retorna o arquivo de propriedades do sistema
     *
     * @return {@code Properties} Propriedades do sistema
     * @throws java.io.IOException Exceção propagada
     */
    public static Properties properties() throws IOException {
        String path = "/br/com/urcontroler/properties/od-properties.properties";
        Properties properties = new Properties();
        properties.load(SystemManager.class.getResourceAsStream(path));
        return properties;
    }

    /**
     * Retorna a propriedade do sistema com base na chave recebida
     *
     * @param property {@code String} Chave da propriedade
     * @return {@code String} Propriedade
     */
    public static String getProperty(String property) {
        try {
            return properties().getProperty(property);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, prop, ex);
            return null;
        }
    }

    /**
     * Retorna instancia de fabrica de gerenciador de entidades
     *
     * @return {@code EntityManagerFactory} Fabrica de gerenciador de entidades
     */
    public EntityManagerFactory getEmf() {
        return this.emf;
    }

    /**
     * Método de inicialização principal
     *
     * @param args {@code String[]} Argumentos
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SystemManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Injector injector = Guice.createInjector(new InterceptorModule());
        SystemManager controls = injector.getInstance(SystemManager.class);
        controls.loadScreen();
    }
}
