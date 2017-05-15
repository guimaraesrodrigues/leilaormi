package servidor;
   
import servidor.Leilao;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import rmi.Lance;

public class TelaServidor extends javax.swing.JFrame {
    ServImpl servimpl;
  
    public TelaServidor(ServImpl servImpl) {
        this.servimpl = servImpl;
        initComponents();

        this.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jListLeiloes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonLances = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListLeiloes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListLeiloes.setToolTipText("");
        jScrollPane2.setViewportView(jListLeiloes);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Servidor TOP");

        jButtonAtualizar.setText("Leiloes");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonLances.setText("Lances");
        jButtonLances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLancesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)
                        .addGap(0, 132, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButtonAtualizar)
                                .addGap(46, 46, 46)
                                .addComponent(jButtonLances)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonLances))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        
        if(this.servimpl.lista_leiloes.isEmpty())
            JOptionPane.showMessageDialog(null, "A lista de leiloes esta vazia!");
        else{
            DefaultListModel dados = new DefaultListModel();        
            for(Leilao l : this.servimpl.lista_leiloes){
                dados.addElement("Produto: " + l.getNome());
            }
            jListLeiloes.setModel(dados);
        }
        
        
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonLancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLancesActionPerformed
        if(this.servimpl.lista_leiloes.isEmpty())
            JOptionPane.showMessageDialog(null, "A lista de leiloes esta vazia!");
        else{
            
            for(Leilao l : this.servimpl.lista_leiloes){
                for(Lance lance : l.lances)
                    System.out.println("Lance: " + lance.getLance());
                
            }
        }
    }//GEN-LAST:event_jButtonLancesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonLances;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListLeiloes;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
