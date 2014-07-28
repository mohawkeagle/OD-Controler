package br.com.odcontroler.main.view.bean;

import br.com.gmp.comps.cleaner.ComponentCleaner;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.interfaces.BeanListener;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 * Bean padrão para implementação de ViewBeans
 *
 * @author kaciano
 * @version 1.0
 * @param <T> Tipo da View
 */
public class ViewBean<T> implements BeanListener<T> {

    protected static final Logger LOGGER = Logger.getLogger(View.class.getName());
    private final T view;

    /**
     * Cria nova instancia de DefaultViewBean
     *
     * @param view {@code DefaultView} View do bean
     * @see br.com.odcontroler.main.view.View
     */
    public ViewBean(T view) {
        this.view = view;
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        System.out.println("Save not implemented yet.");
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        System.out.println("Process not implemented yet.");
    }

    @Override
    public void clear(BeanEvent evt) throws Exception {
        new ComponentCleaner(true).clean((JInternalFrame) view);
        System.out.println("(INFO) Dados removidos dos campos.");
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        System.out.println("Load not implemented yet.");
    }

    /**
     * Método para adição de conteúdos
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    public void add(BeanEvent evt) throws Exception {
        System.out.println("Add not implemented yet.");
    }

    /**
     * Método para edição de conteúdos
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    public void edit(BeanEvent evt) throws Exception {
        System.out.println("Edit not implemented yet.");
    }

    /**
     * Método para atualização de conteúdos
     *
     * @param object {@code Object} Valor à ser atualizado
     * @throws java.lang.Exception Propagação de exceção
     */
    public void update(Object object) throws Exception {
        System.out.println("Update not implemented yet.");
    }

    /**
     * Método para remoção de conteúdos
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    public void remove(BeanEvent evt) throws Exception {
        System.out.println("Remove not implemented yet.");
    }

    /**
     * Método para construção de conteúdos
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    public void build(BeanEvent evt) throws Exception {
        System.out.println("Build not implemented yet.");
    }

    @Override
    public T getView() {
        return view;
    }

}
