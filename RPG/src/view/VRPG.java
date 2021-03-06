package view;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import control.Listener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class VRPG extends JFrame {
	
	public JTextField textField;
	public JButton btnNewButton;
	public JTextPane textPane;
	public static String BTN_ACTION = "";
	
	static final int ANCHO = 550;
	static final int ALTO = 485;
	
	public VRPG() {
		getContentPane().setLayout(null);
		
		
		
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = new Dimension(ANCHO, ALTO);
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		
		
		textPane = new JTextPane();
		textPane.setBackground(new Color(51, 51, 51));
		textPane.setForeground(new Color(153, 102, 255));
		textPane.setBounds(10, 11, 514, 388);
		
		textField = new JTextField();
		textField.setBounds(10, 410, 411, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton(BTN_ACTION);
		btnNewButton.setBounds(431, 410, 93, 24);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 514, 388);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(textPane);
	}
	public void hacerVisible() {
		setVisible(true);
		
	}
	
	public void setListener(Listener listener) {
		btnNewButton.addActionListener(listener);
		
	}
}
