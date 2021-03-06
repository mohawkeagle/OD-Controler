package br.com.urcontroler.main.view.weapon;

import br.com.urcontroler.data.db.dao.WeaponDAO;
import br.com.urcontroler.data.entity.Weapon;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.weapon.WeaponView;
import br.com.urcontroler.main.view.weapon.sub.WeaponSubView;

/**
 * Bean de controle de WeaponView
 *
 * @author kaciano
 */
public class WeaponBean extends ViewBean<WeaponView> {

    private final WeaponDAO dao;
    private final TableUtil tableUtil;

    /**
     * Cria nova instancia de WeaponBean
     *
     * @param view {@code WeaponView} View do bean
     */
    public WeaponBean(WeaponView view) {
        super(view);
        this.dao = new WeaponDAO();
        this.tableUtil = new TableUtil(view);
        try {
            onLoad(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void onLoad(BeanEvent evt) throws Exception {
        getView().getModel().setData(dao.getList());
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        this.dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((Weapon) evt.getValue());
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            WeaponSubView subview;
            Weapon weapon = getView().getModel().getObject(row);
            subview = new WeaponSubView(getView(), weapon);
            getView().getMainScreen().getListener().insertView(subview);
            if (subview.getWeapon() != null) {
                getView().getModel().update(row, subview.getWeapon());
            }
        }
    }

    @Override
    public void update(Object object) throws Exception {
        Integer row = getView().getModel().getObjectRow(object);
        if (object != null) {
            getView().getModel().update(row, (Weapon) object);
        }
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    /**
     * Retorna o DAO das armas
     *
     * @return {@code Weapon} DAO das armas
     */
    public WeaponDAO getDao() {
        return this.dao;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Weapon type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }
}
