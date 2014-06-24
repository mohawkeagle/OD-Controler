package br.com.odcontroler.main.util;

import br.com.gmp.utils.annotations.Intercept;
import br.com.gmp.utils.reflection.ObjectInstance;
import br.com.gmp.utils.reflection.ReflectionUtil;
import br.com.odcontroler.data.db.dao.MenuDAO;
import br.com.odcontroler.data.db.dao.MenuItemDAO;
import br.com.odcontroler.data.entity.Menu;
import br.com.odcontroler.data.entity.MenuItem;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.view.View;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 * Classe utilitária para construção de menus e dos respectivos itens
 *
 * @author kaciano
 * @version 1.0
 * @see br.com.rpgruler.data.db.dao.MenuDAO
 * @see br.com.rpgruler.data.db.dao.MenuItemDAO
 * @see br.com.rpgruler.data.entity.Menu
 * @see br.com.rpgruler.data.entity.MenuItem
 */
public class MenuBuilder {

    private MainScreen mainScreen;
    private JMenu root;
    private MenuDAO menuDAO;
    private MenuItemDAO viewDAO;

    /**
     * Cria nova instancia de MenuBuilder
     */
    public MenuBuilder() {
        this.menuDAO = new MenuDAO();
        this.viewDAO = new MenuItemDAO();
    }

    /**
     * Cria nova instancia de MenuBuilder
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     * @param root <code>JMenu</code> Menu raiz
     */
    public MenuBuilder(MainScreen mainScreen, JMenu root) {
        this.mainScreen = mainScreen;
        this.root = root;
        this.menuDAO = new MenuDAO();
        this.viewDAO = new MenuItemDAO();
    }

    /**
     * Inicia a construção do menu
     *
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    @Intercept
    public void build() throws ClassNotFoundException, InstantiationException {
        List<Menu> menus = menuDAO.getList();
        List<MenuItem> views = viewDAO.getList();
        build(menus, views, true);
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de Menus
     * @param items <code>List(MenuItem)</code> Listas de MenuItems
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    @Intercept
    public void build(List<Menu> menus, List<MenuItem> items, boolean execute) throws ClassNotFoundException, InstantiationException {
        menus.removeAll(Collections.singleton(null));
        items.removeAll(Collections.singleton(null));
        Collections.sort(menus);
        Collections.sort(items);
        buildMenu(menus);
        buildItems(items, execute);
        SwingUtilities.updateComponentTreeUI(root);
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus <code>List(Menu)</code> Listas de menus
     */
    public void buildMenu(List<Menu> menus) {
        root.removeAll();
        Collections.sort(menus);
        for (Menu menu : menus) {
            if (menu.getParent() == 0) {
                insertMenu(root, menu);
            } else {
                recursiveMenus(root, menu);
            }
        }
        SwingUtilities.updateComponentTreeUI(root);
    }

    /**
     * Insere um novo menu no menu pai
     *
     * @param parent <code>JMenu</code> Menu pai
     * @param menu <code>Menu</code> Menu à ser inserido
     */
    private void insertMenu(JMenu parent, Menu menu) {
        JMenu jmenu = generateMenu(menu);
        parent.add(jmenu);
    }

    /**
     * Insere os menus recursivamente
     *
     * @param parent <code>JMenu</code> Menu pai
     * @param menu <code>Menu</code> Menu à ser inserido
     */
    private void recursiveMenus(JMenu parent, Menu menu) {
        for (Component comp : parent.getMenuComponents()) {
            JMenu jmenu = (JMenu) comp;
            String sub = jmenu.getText().split("-")[0].trim().substring(1);
            Long menuid = Long.parseLong(sub);
            if (menu.getParent().equals(menuid)) {
                System.out.println("(INFO) Inserindo em: " + jmenu.getText());
                insertMenu(jmenu, menu);
                break;
            } else {
                recursiveMenus(jmenu, menu);
            }
        }
    }

    /**
     * Constroi os itens nos menus
     *
     * @param items <code>List(MenuItem)</code> Listas de MenuItems
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    public void buildItems(List<MenuItem> items, boolean execute) throws ClassNotFoundException, InstantiationException {
        //Collections.sort(items);
        for (MenuItem item : items) {
            if (((long) 0) == item.getMenu()) {
                insertItem(root, item, execute);
            } else {
                recursiveItems(root, item, execute);
            }
        }
    }

    /**
     * Constroi os itens recursivamente nos menus
     *
     * @param jmenu <code>JMenu</code> Menu de base
     * @param item <code>MenuItem</code> Item a ser inserido
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    public void recursiveItems(JMenu jmenu, MenuItem item, boolean execute) throws ClassNotFoundException, InstantiationException {
        for (Component comp : jmenu.getMenuComponents()) {
            JMenu menu = (JMenu) comp;
            String prefix = menu.getText().split("-")[0].trim().substring(1);
            Long menuid = Long.parseLong(prefix);
            if (item.getMenu().equals(menuid)) {
                insertItem(menu, item, execute);
                break;
            } else {
                recursiveItems(menu, item, execute);
            }
        }
    }

    /**
     * Insere o item no Menu
     *
     * @param menu <code>JMenu</code> Menu de base
     * @param item <code>List(MenuView)</code> Lista de Views
     * @param execute <code>boolean</code> O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe não encontrada
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    private void insertItem(JMenu menu, MenuItem item, boolean execute) throws ClassNotFoundException, InstantiationException {
        JMenuItem jitem = generateItem(item, execute);
        menu.add(jitem);
    }

    /**
     * Retorna um JMenu construido a partir de um Menu
     *
     * @param menu <code>Menu</code> Objeto de Menu
     * @return <code>JMenu</code> JMenu gerado
     */
    public JMenu generateMenu(Menu menu) {
        JMenu jmenu = new JMenu();
        jmenu.setName(menu.toString());
        jmenu.setText(menu.toString());
        jmenu.setIcon(new ImageIcon(getClass().getResource(menu.getIcon())));
        return jmenu;
    }

    /**
     * Retorna um JMenuItem construido a partir de um MenuItem
     *
     * @param view <code>MenuItem</code> Objeto da View
     * @param execute <code>boolean</code> O item deve executar a função?
     * @return <code>JMenuItem</code> Item criado
     * @throws ClassNotFoundException Exceção de classe não encontrada
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    public JMenuItem generateItem(final MenuItem view, boolean execute) throws ClassNotFoundException, InstantiationException {
        JMenuItem item = new JMenuItem();
        item.setText(view.toString());
        item.setIcon(new ImageIcon(getClass().getResource(view.getIcon())));
        if (execute) {
            final ReflectionUtil reflect = new ReflectionUtil();
            Class<?> objClass = Class.forName(view.getViewClass());
            Class<?>[] argTypes = new Class[]{MainScreen.class};
            Object[] arguments = new Object[]{mainScreen};
            final ObjectInstance inst = new ObjectInstance(objClass, argTypes, arguments);
            Map<String, MenuItem> viewMap = mainScreen.getListener().getViewMap();
            viewMap.put(view.toString().split("-")[0].trim(), view);
            item.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        View newView = (View) reflect.newInstance(inst);
                        mainScreen.getListener().insertView(newView);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(MenuBuilder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        return item;
    }

    /**
     * Retorna a tela principal
     *
     * @return <code>MainScreen</code> Tela principal
     */
    public MainScreen getMainScreen() {
        return mainScreen;
    }

    /**
     * Modifica a tela principal
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    /**
     * Retorna o menu raiz
     *
     * @return <code>JMenu</code> Menu raiz
     */
    public JMenu getRoot() {
        return root;
    }

    /**
     * Modifica o menu raiz
     *
     * @param root <code>JMenu</code> Menu raiz
     */
    public void setRoot(JMenu root) {
        this.root = root;
    }

}