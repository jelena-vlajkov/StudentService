package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;

public class DodajStudentaNaPredmet extends JDialog {

	private static final long serialVersionUID = 465696571858238601L;
	public static JTextField bri;
	
	public DodajStudentaNaPredmet(JFrame parent) {
		super(parent, "Dodaj studenta", true);
		this.setSize(500, 150);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		
		JLabel labBri = new JLabel("*Broj indeksa studenta:");
		labBri.setToolTipText("Unesite broj indeksa");
		bri = new JTextField();
		
		JPanel up = new JPanel(new GridBagLayout());
		
		up.add(labBri, lbl(0, 0));
		up.add(bri, tf(1, 0));
		
		JButton ok = new JButton("Potvrda");
		JButton notOk = new JButton("Odustanak");
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(PredmetController.getInstance().dodajStudentaNaPredmet()) {
					dispose();
				}
			}
		});
		
		notOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		
		JPanel dugmici = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		dugmici.add(notOk);
		dugmici.add(ok);
		
		this.add(up, BorderLayout.CENTER);
		this.add(dugmici, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	
	private GridBagConstraints lbl(int x,int y) {
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 20, 5, 10);
		return gbc;
	}
	
	private GridBagConstraints tf(int x,int y) {
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 3;
		gbc.weightx = 100;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 0, 20);
		return gbc;
	}	
}
