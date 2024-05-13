package com.github.macgarcia.ide.auditoria.configuration;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author macgarcia
 */
public class FactoryScreen {
    
    private static final Logger LOGGER = FactoryLog.getLog();

    public static <C extends JInternalFrame> C createScreen(Class<C> classe, JDesktopPane desktop) {
        try {
            final C tela = classe.getDeclaredConstructor().newInstance();
            desktop.add(tela);
            Configuration.setPosicaoInternalFrame(desktop, tela);
            tela.setVisible(true);
            return tela;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            LOGGER.severe(String.format("Erro para abrir a tela.: [%s], Erro[%s]", classe, ex.getMessage()));
        }
        return null;
    }
    
}
