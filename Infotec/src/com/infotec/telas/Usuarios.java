package com.infotec.telas;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class Usuarios extends JInternalFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtLogin;
	private JComboBox cboPerfil;
	private JButton btnNovo, btnEditar, btnExcluir, btnPesquisar;
	private JTextField txtSenha;

	
	public Usuarios() {
		setBorder(null);
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		 
		setBounds(100, 100, 693, 501);
		
		JLabel lblNewLabel = new JLabel("ID:");
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		
		JLabel lblNewLabel_3 = new JLabel("Login:");
		
		JLabel lblNewLabel_4 = new JLabel("Senha:");
		
		txtID = new JTextField();
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Perfil:");
		
		cboPerfil = new JComboBox();
		cboPerfil.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User", ""}));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtFone, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_5)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(cboPerfil, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_3)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(txtLogin, 171, 171, 171)))
											.addGap(18)
											.addComponent(lblNewLabel_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)))
									.addGap(49)))
							.addGap(126))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtFone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(cboPerfil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btnNovo = new JButton("");
		btnNovo.setPreferredSize(new Dimension(80, 80));
		btnNovo.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/novo.png")));
		panel.add(btnNovo);
		
		btnEditar = new JButton("");
		btnEditar.setPreferredSize(new Dimension(80, 80));
		btnEditar.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/editar.png")));
		panel.add(btnEditar);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setPreferredSize(new Dimension(80, 80));
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/pesquisar.png")));
		panel.add(btnPesquisar);
		
		btnExcluir = new JButton("");
		btnExcluir.setPreferredSize(new Dimension(80, 80));
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/excluir.png")));
		panel.add(btnExcluir);
		getContentPane().setLayout(groupLayout);
		

	}
}
