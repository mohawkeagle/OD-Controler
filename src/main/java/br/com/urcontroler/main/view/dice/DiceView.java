package br.com.urcontroler.main.view.dice;

import br.com.gmp.utils.image.ImageUtil;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.util.DiceTool;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.interfaces.BeanListener;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Simulador de dados
 *
 * @author kaciano
 */
public class DiceView extends View {

    /**
     * Creates new form DiceView
     *
     * @param screen {@code MainScreen} Tela principal
     */
    public DiceView(MainScreen screen) {
        super(screen);
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        ImageIcon ic = new ImageIcon(getClass().getResource("/dices/d12-icon.png"));
        Image img = new ImageUtil().getScaledImage(ic.getImage(), 16, 16);
        setFrameIcon(new ImageIcon(img));
        setControls(new ViewParameter(false, false, false, true));
        setSize(496, 333);
        initComponents();
        for (Component c : jPDices.getComponents()) {
            if (c instanceof JButton) {
                final JButton bt = (JButton) c;
                bt.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        simulateDice(bt);
                    }
                });
            }
        }
    }

    @Override
    public void onLoad() {
        for (Component c : jPDices.getComponents()) {
            if (c instanceof JButton) {
                JButton bt = (JButton) c;
                bt.setText(bt.getName());
            }
        }
    }

    /**
     * Simula jogada de dados
     *
     * @param button JButton
     */
    private void simulateDice(JButton button) {
        switch (button.getName()) {
            case "D4":
                button.setText(throwDice(4));
                break;
            case "D6":
                button.setText(throwDice(6));
                break;
            case "D8":
                button.setText(throwDice(8));
                break;
            case "D10":
                button.setText(throwDice(10));
                break;
            case "D12":
                button.setText(throwDice(12));
                break;
            case "D20":
                button.setText(throwDice(20));
                break;
        }
    }

    /**
     * Metodo para simular a jogada de dados
     *
     * @param type {@code int} Tipo de dado
     * @return {@code String} Valor do dado
     */
    private String throwDice(int type) {
        return String.valueOf(DiceTool.throwDice(type));
    }

    @Override
    public BeanListener getBean() {
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPDices = new javax.swing.JPanel();
        D4 = new javax.swing.JButton();
        D6 = new javax.swing.JButton();
        D8 = new javax.swing.JButton();
        D10 = new javax.swing.JButton();
        D12 = new javax.swing.JButton();
        D20 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Simulador de dados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/dice.gif"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(496, 333));
        setMinimumSize(new java.awt.Dimension(496, 333));
        setVisible(true);

        jPDices.setLayout(new java.awt.GridLayout(2, 3));

        D4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        D4.setForeground(new java.awt.Color(153, 153, 153));
        D4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dices/d4-icon.png"))); // NOI18N
        D4.setText("D4");
        D4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        D4.setName("D4"); // NOI18N
        jPDices.add(D4);

        D6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        D6.setForeground(new java.awt.Color(204, 204, 204));
        D6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dices/d6-icon.png"))); // NOI18N
        D6.setText("D6");
        D6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        D6.setName("D6"); // NOI18N
        jPDices.add(D6);

        D8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        D8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dices/d8-icon.png"))); // NOI18N
        D8.setText("D8");
        D8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        D8.setName("D8"); // NOI18N
        jPDices.add(D8);

        D10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        D10.setForeground(new java.awt.Color(204, 204, 204));
        D10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dices/d10-icon.png"))); // NOI18N
        D10.setText("D10");
        D10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        D10.setName("D10"); // NOI18N
        jPDices.add(D10);

        D12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        D12.setForeground(new java.awt.Color(204, 204, 204));
        D12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dices/d12-icon.png"))); // NOI18N
        D12.setText("D12");
        D12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        D12.setName("D12"); // NOI18N
        jPDices.add(D12);

        D20.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        D20.setForeground(new java.awt.Color(204, 204, 204));
        D20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dices/d20-icon.png"))); // NOI18N
        D20.setText("D20");
        D20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        D20.setName("D20"); // NOI18N
        jPDices.add(D20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPDices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPDices, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton D10;
    private javax.swing.JButton D12;
    private javax.swing.JButton D20;
    private javax.swing.JButton D4;
    private javax.swing.JButton D6;
    private javax.swing.JButton D8;
    private javax.swing.JPanel jPDices;
    // End of variables declaration//GEN-END:variables
}
