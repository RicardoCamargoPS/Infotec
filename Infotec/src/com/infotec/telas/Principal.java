package com.infotec.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 * 	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnCadastro, mnOpcoes, mnAjuda;
	public static  JMenu mnRelatorio;
	public static JMenuItem miCad_Usuario ;
	private JMenuItem miCad_Clientes, miCad_Os;
	private JMenuItem miRe_Servicos;
	private JMenuItem miAj_Sobre;
	private JMenuItem miOp_Exit;
	public static JLabel lblLoginUsuario;
	private JLabel lblData;
	private JDesktopPane desktopPane;
	
	/**
	 * Create the frame.
	 */
	public Principal() {		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/com/infotec/icons/Infotec Logo - Original - 5000x5000 (1).png")));
		setTitle("Infotec");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 737);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);
		
		miCad_Clientes = new JMenuItem("Clientes");
		miCad_Clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes cliente = new Clientes();
				cliente.setVisible(true);
				desktopPane.add(cliente);
			}
		});
		mnCadastro.add(miCad_Clientes);
		
		miCad_Os = new JMenuItem("OS");
		mnCadastro.add(miCad_Os);
		
		miCad_Usuario = new JMenuItem("Usuarios");
		miCad_Usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuario = new Usuarios();
				usuario.setVisible(true);
				desktopPane.add(usuario);
				
			}
		});
		miCad_Usuario.setEnabled(false);
		mnCadastro.add(miCad_Usuario);
		
		mnRelatorio = new JMenu("Relatorios");
		mnRelatorio.setEnabled(false);
		menuBar.add(mnRelatorio);
		
		miRe_Servicos = new JMenuItem("Serviços");
		mnRelatorio.add(miRe_Servicos);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		miAj_Sobre = new JMenuItem("Sobre");
		miAj_Sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		mnAjuda.add(miAj_Sobre);
		
		mnOpcoes = new JMenu("Opções");
		menuBar.add(mnOpcoes);
		
		miOp_Exit = new JMenuItem("Exit");
		miOp_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sair = JOptionPane.showConfirmDialog(null,  "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION);
				if(sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnOpcoes.add(miOp_Exit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		
		lblLoginUsuario = new JLabel("New label");
		lblLoginUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblData = new JLabel("New label");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				Date data = new Date();
				DateFormat dtformat = DateFormat.getDateInstance(DateFormat.SHORT);
				lblData.setText(dtformat.format(data));
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblLoginUsuario)
					.addPreferredGap(ComponentPlacement.RELATED, 983, Short.MAX_VALUE)
					.addComponent(lblData)
					.addGap(50))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLoginUsuario)
						.addComponent(lblData))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
