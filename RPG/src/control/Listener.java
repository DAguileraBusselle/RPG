package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.RPG;
import view.VRPG;

public class Listener implements ActionListener{

	private VRPG vrpg;
	public static String ACTION = "";
	public Listener(VRPG vrpg) {
		this.vrpg = vrpg;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JButton) {
			if (ev.getActionCommand().equals(vrpg.BTN_ACTION)) {				
				ACTION = vrpg.textField.getText().trim();
				
				vrpg.textPane.setText(RPG.TEXTO_PANTALLA);
			}
		}
		
	}
}
