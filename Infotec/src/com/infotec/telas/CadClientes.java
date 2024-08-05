package com.infotec.telas;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class CadClientes extends JInternalFrame {

    private JTextField[] textFields;
    private JLabel[] labels;
	private JLabel endereco;
    private JTable tabelaCliente;
    private JButton jbtnLimpar, jbtnSalvar, jbtnExcluir, jbtnPesquisar;
    private String[] varNomes ={ "Nome", "Telefone", "Rua", "NumeroResidencial", "Cidade", "Cep", "Estado", "Email", "Pesquisar"};
	private JComboBox comboBox;

    public CadClientes(){

        super("Cadastro de Clientes", true, true, true, true);
		initComponentes();
		setLayout();
        
    }

    public void initComponentes(){

        for(int i = 0; i < 9; i++){
			System.out.println(varNomes.length);
            textFields[i] = new JTextField();
            textFields[i].setName("jtf" + varNomes[i]);

        }
        for(int i = 0; i <= varNomes.length; i++){
            labels[i] = new JLabel();
            labels[i].setText(varNomes[i]);
            labels[i].setName("jlb" + varNomes[i]);
        }

		endereco.setText("Endereço:");

        jbtnLimpar = new JButton("Limpar");
        jbtnSalvar = new JButton("Salvar");
        jbtnExcluir= new JButton("Excluir");
        jbtnPesquisar= new JButton("Pesquisar");

        tabelaCliente = new JTable();

		comboBox = new JComboBox<>();
		

    }

    public void setLayout(){

		
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panelPesquisar = new JPanel();

		GroupLayout gl_panel_1 = new GroupLayout(panelPesquisar);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(tabelaCliente, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textFields[0], GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jbtnPesquisar))
						.addComponent(labels[0]))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(labels[0])
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFields[8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jbtnPesquisar))
					.addGap(12)
					.addComponent(tabelaCliente, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addContainerGap())
		);

		JPanel panelFormulario = new JPanel();


		GroupLayout gl_panel = new GroupLayout(panelFormulario);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(endereco)
						.addComponent(labels[7])
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(labels[1])
									.addGap(18)
									.addComponent(textFields[1], GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
											.addComponent(labels[0])
											.addGap(18)
											.addComponent(textFields[0], GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(labels[6])
												.addComponent(labels[4]))
											.addGap(18)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(textFields[5], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(labels[7])
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
															.addComponent(jbtnSalvar)
															.addGap(18)
															.addComponent(jbtnExcluir))
														.addComponent(textFields[6], GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE))
												.addComponent(textFields[3])
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(18)
													.addComponent(textFields[7], GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(jbtnLimpar)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(labels[5])
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textFields[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(labels[8])
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))))
							.addGap(147))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labels[0])
						.addComponent(textFields[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labels[1])
						.addComponent(textFields[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labels[7])
						.addComponent(textFields[7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(endereco)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labels[4])
						.addComponent(textFields[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labels[5])
						.addComponent(textFields[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labels[6])
						.addComponent(textFields[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labels[7])
						.addComponent(textFields[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labels[8])
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbtnSalvar)
						.addComponent(jbtnExcluir)
						.addComponent(jbtnLimpar))
					.addContainerGap())
		);
		getContentPane().add(panelPesquisar);
		getContentPane().add(panelFormulario);

		panelPesquisar.setLayout(gl_panel_1);
		
		panelFormulario.setLayout(gl_panel);
		


	}

	

        
}
