package br.com.urcontroler.main.view.dialog;

import br.com.gmp.comps.dialog.GDialog;
import br.com.urcontroler.main.view.View;

/**
 * Tela para descrição de funções de Views
 *
 * @author kaciano
 */
public class DescriptionDialog extends GDialog {

    private String description;

    /**
     * Cria nova instancia de DescriptionDialog
     *
     * @param view {@code View} View à ser descrita
     * @param description {@code String} Descrição
     */
    public DescriptionDialog(View view, String description) {
        super(view.getMainScreen(), true);
        initialize(description);
    }

    /**
     * Método de inicialização
     */
    private void initialize(String description) {
        initComponents();
        setSize(500, 360);
        setDescription(description);
        setVisible(true);
    }

    /**
     * Modifica a descrição
     *
     * @param description {@code String} Descrição
     */
    public void setDescription(String description) {
        this.description = description;
        this.jLDescription.setText(this.description);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLDescription = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jBExit = new javax.swing.JButton();

        setTitle("Descrição");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 360));

        jLDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBExit.setText("Sair");
        jBExit.setFocusable(false);
        jBExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });
        jToolBar1.add(jBExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExit;
    private javax.swing.JLabel jLDescription;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
