package br.com.odcontroler.main.actions;

import br.com.odcontroler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para limpar os dados, tecla F4
 *
 * @author kaciano
 */
public class ClearAction extends FrameAction {

    /**
     * Cria nova instancia de ClearAction
     *
     * @param view <code>View</code> da ação
     */
    public ClearAction(View view) {
        super("clear", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().getMainScreen().clear(e);
    }

}