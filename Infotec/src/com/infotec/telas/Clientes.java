package com.infotec.telas;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.sql.*;
import com.infotec.db.ConexaoDB;
import net.proteanit.sql.DbUtils;  

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Clientes extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNumCasa;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private JTextField txtUF;
	private JTextField txtEmail;
	private JTable tbClientes;
	private JTextField txtPesquisar;


	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField txtFone;
	private JLabel lblMenssagem;
	private JLabel lblFone;
	private JLabel lblNome;

	public Clientes() {

		conexao = ConexaoDB.conector();
		

		setTitle("Cadastro de Clientes");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setBounds(100, 100, 623, 562);

		JPanel panel = new JPanel();

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisar();
			}
		});
		txtPesquisar.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("");

		JLabel lblPesquisar = new JLabel("");
		lblPesquisar.setIcon(new ImageIcon(Clientes.class.getResource("/com/infotec/icons/3924902_search_searching_web_creanimasi_icon.png")));

		tbClientes = new JTable();
		tbClientes.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				setCampos();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
			
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_8)
												.addGap(42))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblPesquisar)
												.addContainerGap(88, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addGap(7)
												.addComponent(tbClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addContainerGap()))))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesquisar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_8)
								.addComponent(tbClientes, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGap(13)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(371))
				);

		JPanel panel_1 = new JPanel();

		lblNome = new JLabel("* Nome:");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JPanel panel_2 = new JPanel();

		JLabel lblNewLabel_6 = new JLabel("Endereço:");

		JLabel lblNewLabel_7 = new JLabel("email:");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		lblFone = new JLabel("* Telefone:");

		txtFone = new JTextField();
		txtFone.setColumns(10);

		lblMenssagem = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(164, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_6)
					.addContainerGap(529, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFone)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFone, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(299, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(258)
					.addComponent(lblMenssagem)
					.addContainerGap(330, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addComponent(lblMenssagem)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFone)
						.addComponent(txtFone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_7)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JLabel lblNewLabel_1 = new JLabel("Rua:");

		JLabel lblNewLabel_2 = new JLabel("Nº:");

		JLabel lblNewLabel_3 = new JLabel("CEP:");

		JLabel lblNewLabel_4 = new JLabel("Cidade:");

		JLabel lblNewLabel_5 = new JLabel("UF:");

		txtRua = new JTextField();
		txtRua.setColumns(10);

		txtNumCasa = new JTextField();
		txtNumCasa.setColumns(10);

		txtCEP = new JTextField();
		txtCEP.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);

		txtUF = new JTextField();
		txtUF.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(txtCidade))
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtNumCasa, 0, 0, Short.MAX_VALUE)
						.addComponent(txtUF, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtNumCasa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);

		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adicionar();
			}
		});
		btnNovo.setIcon(new ImageIcon(Clientes.class.getResource("/com/infotec/icons/novo.png")));

		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				alterar();
			}
		});
		btnEditar.setIcon(new ImageIcon(Clientes.class.getResource("/com/infotec/icons/editar.png")));

		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Clientes.class.getResource("/com/infotec/icons/excluir.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNovo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEditar)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExcluir)
						.addContainerGap(110, Short.MAX_VALUE))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap(18, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnExcluir)
								.addComponent(btnEditar)
								.addComponent(btnNovo))
						.addGap(25))
				);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	public void adicionar() {

		String sql = "insert into tbclientes(nome, fone, cep, cidade, estado, rua, nun_residencia, enail) values(?, ?, ?, ?, ?, ?, ?, ?)";		
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtFone.getText());
			pst.setString(3, txtCEP.getText());
			pst.setString(4, txtCidade.getText());
			pst.setString(5, txtUF.getText());
			pst.setString(6, txtRua.getText());
			pst.setString(7, txtNumCasa.getText());
			pst.setString(8, txtEmail.getText());

			if ((txtNome.getText().isEmpty()) || (txtFone.getText().isEmpty())) {				
				lblMenssagem.setText("Os campos em vermelho devem ser preenchidos");

			} else {
				lblNome.setForeground(Color.black);
				lblFone.setForeground(Color.black);

				int adicionado = pst.executeUpdate();

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
					pst = conexao.prepareStatement(sql);
					txtNome.setText(null);
					txtFone.setText(null);
					txtCEP.setText(null);
					txtCidade.setText(null);
					txtUF.setText(null);
					txtRua.setText(null);
					txtNumCasa.setText(null);
					txtEmail.setText(null);
				} 
			}

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void pesquisar() {
		String sql = "select * from tbclientes where nome like ?";
		
		try {
			
			pst = conexao.prepareStatement(sql);
			
			pst.setString(1, txtPesquisar.getText() + "%");
			rs = pst.executeQuery();
			
			tbClientes.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	public void setCampos(){

		int setar = tbClientes.getSelectedRow();

		txtNome.setText(tbClientes.getModel().getValueAt(setar, 1).toString());
		txtRua.setText(tbClientes.getModel().getValueAt(setar, 6).toString());
		txtNumCasa.setText(tbClientes.getModel().getValueAt(setar, 7).toString());
		txtCEP.setText(tbClientes.getModel().getValueAt(setar, 3).toString());
		txtCidade.setText(tbClientes.getModel().getValueAt(setar, 4).toString());
		txtUF.setText(tbClientes.getModel().getValueAt(setar, 5).toString());
		txtEmail.setText(tbClientes.getModel().getValueAt(setar, 8).toString());
		txtFone.setText(tbClientes.getModel().getValueAt(setar, 2).toString());

	}

	private void alterar() {
		String sql = "update tbclientes set nome = ?, fone = ?, cep =?, cidade = ?, estado = ?, rua = ?, nun_residencia = ?, enail =? where nome = ?";

		try {
			pst = conexao.prepareStatement(sql);

			pst.setString(1, txtNome.getText());
			pst.setString(2, txtFone.getText());
			pst.setString(3, txtCEP.getText());
			pst.setString(4, txtCidade.getText());
			pst.setString(5, txtUF.getText());
			pst.setString(6, txtRua.getText());
			pst.setString(7, txtNumCasa.getText());
			pst.setString(8, txtEmail.getText());
			pst.setString(9, txtNome.getText());

			if ((txtNome.getText().isEmpty())	|| (txtFone.getText().isEmpty())) {
				
				JOptionPane.showMessageDialog(null, "Preencha os dados obricatorios");

			} else {

				int adicionado = pst.executeUpdate();

				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Dados do cliente alterado com sucesso");
					txtNome.setText("");
					txtRua.setText("");
					txtNumCasa.setText("");
					txtCEP.setText("");
					txtCidade.setText("");
					txtUF.setText("");
					txtEmail.setText("");
					txtFone.setText("");

				} 
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
