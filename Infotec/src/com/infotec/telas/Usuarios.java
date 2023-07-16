package com.infotec.telas;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


import java.sql.*;
import com.infotec.db.ConexaoDB;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JInternalFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtLogin;
	private JComboBox<String> cboPerfil = new JComboBox<>(new DefaultComboBoxModel<String>(new String[] {"super", "admin", "user"}));
	private JButton btnNovo, btnEditar, btnExcluir, btnPesquisar, btnSalvar;
	private JTextField txtSenha;

	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;


	public Usuarios() {

		conexao = ConexaoDB.conector();		

		initComponent();

	}

	public void initComponent() {

		setTitle("Cadastro de Usuario");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setBounds(100, 100, 640, 396);

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
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtFone, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(cboPerfil, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_3)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtLogin, 171, 171, 171)))
										.addGap(18)
										.addComponent(lblNewLabel_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtSenha)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(28))
				);
		cboPerfil.setSelectedIndex(-1);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
												.addComponent(cboPerfil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(32)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(219, Short.MAX_VALUE))
				);

		btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				consultar();
			}
		});
		btnPesquisar.setToolTipText("Pesquisar");
		btnPesquisar.setPreferredSize(new Dimension(70, 70));
		btnPesquisar.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/pesquisar.png")));

		btnNovo = new JButton("");
		btnNovo.setToolTipText("Novo");
		btnNovo.setPreferredSize(new Dimension(70, 70));
		btnNovo.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/novo.png")));

		btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar");
		btnEditar.setPreferredSize(new Dimension(70, 70));
		btnEditar.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/editar.png")));

		btnExcluir = new JButton("");
		btnExcluir.setToolTipText("Deletar");
		btnExcluir.setPreferredSize(new Dimension(70, 70));
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/excluir.png")));

		btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setPreferredSize(new Dimension(70, 70));
		btnSalvar.setIcon(new ImageIcon(Usuarios.class.getResource("/com/infotec/icons/48753_diskette_icon.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(7)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);	

	}

	private void consultar() {
		String sql = "select * from tbusuarios where id =?";		
		try {

			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtID.getText());

			rs = pst.executeQuery();

			if (rs.next()) {

				txtNome.setText(rs.getString(2));
				txtFone.setText(rs.getString(3));
				txtLogin.setText(rs.getString(4));
				txtSenha.setText(rs.getString(5));
				cboPerfil.setSelectedItem(rs.getObject(6));			

			} else {				
				JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
				txtNome.setText(null);
				txtFone.setText(null);
				txtLogin.setText(null);
				txtSenha.setText(null);
				cboPerfil.setSelectedItem(null);	

			}

	}
	catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}

}
}
