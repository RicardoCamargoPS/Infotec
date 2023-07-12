package com.infotec.telas;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.infotec.db.ConexaoDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class Infotec_login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	
	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	
	public void logar(){
		String sql= "select * from tbusuarios where login=? and senha = ?";
		try {           
			pst = conexao.prepareStatement(sql);
			pst.setString(1, txtUsuario.getText());

			String senha = new String(txtPassword.getPassword());
			pst.setString(2, senha);

			rs = pst.executeQuery();

			if(rs.next()){
				
				String perfil = rs.getString(6);
				
				Principal principal = new Principal();    
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				if(perfil.equals("super") || perfil.equals("admin") ) {
					Principal.miCad_Usuario.setEnabled(true);
					Principal.mnRelatorio.setEnabled(true);
					Principal.lblLoginUsuario.setForeground(Color.red);
				}
				Principal.lblLoginUsuario.setText(rs.getString(2));
				this.dispose();
				conexao.close();
			}
			else{
				JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}
	}
	public Infotec_login() {
		setForeground(new Color(0, 128, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/com/infotec/icons/Infotec Logo - Original - 5000x5000 (1).png")));
		conexao = ConexaoDB.conector();
		
		setTitle("Infotec Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		JLabel lblPassword = new JLabel("Senha:");
		
		JLabel lblIconStatusDB = new JLabel("dbStatusIcon");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblIconStatusDB)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLogin))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario)
								.addComponent(lblPassword))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPassword)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogin)
						.addComponent(lblIconStatusDB))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		if(conexao != null){      
			lblIconStatusDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("../icons/db_Conected.png")));
			lblIconStatusDB.setText("Conectado");
		}
		else{
			lblIconStatusDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("../icons/db_Notconected.png")));
			lblIconStatusDB.setText("Desconectado");
		}
	}
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
		logar();
	}
}
