package view.dijalozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import controller.DocumentListenerDodajStudenta;
import controller.StudentController;
import view.MainFrame;

public class DijalogStudent extends JDialog {
	
	private static final long serialVersionUID = 4321188677869799991L;
	
	public static JTextField imeS;
	public static JTextField przS;
	public static JTextField datRodj;
	public static JTextField adresa;
	public static JTextField brtel;
	public static JTextField briS;
	public static JTextField datumU;
	public static JTextField prosOc;
	public static JTextField email;
	public JButton notokBtn;
	public static JButton okBtn;
	@SuppressWarnings("rawtypes")
	public static JComboBox godStud;
	public static JRadioButton budzet;
	public static JRadioButton samofin;
	private DocumentListener documentListener = new DocumentListenerDodajStudenta();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DijalogStudent(JFrame parent) {
		super(parent, "Dodavanje studenta", true);
		this.setSize(MainFrame.width/3, MainFrame.height*8/10);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(parent);
		
		JPanel up = new JPanel(new GridBagLayout());
		JPanel down = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JLabel labIme = new JLabel("*Ime:");
		labIme.setToolTipText("Unesite ime");		        
	    imeS = new JTextField();
		      
		        // prezime
		JLabel labPrz = new JLabel("*Prezime:");
		labPrz.setToolTipText("Unesite prezime");
		przS = new JTextField();
		    
		        // datum
		JLabel labDat = new JLabel("*Datum rođenja:");
		labDat.setToolTipText("Unesite datum rođenja");	        
		datRodj = new JTextField();
        
		        // adresa
		JLabel labAdresa = new JLabel("*Adresa stanovanja:");
		labAdresa.setToolTipText("Unesite adresa stanovanja");	
		adresa = new JTextField();


		        // br telefona
		JLabel labBrTel = new JLabel("*Broj telefona:");
		//labBrTel.setPreferredSize(new Dimension(100, 50));
		labBrTel.setToolTipText("Unesite broj telefona");		
		brtel = new JTextField();

		        // broj indeksa
		        
		JLabel labBRI = new JLabel("*Broj indeksa:");
		labBRI.setToolTipText("Unesite broj indeksa");	        
		briS = new JTextField();
	
		JLabel labGodU = new JLabel("*Datum upisa:");
		labGodU.setToolTipText("Unesite datum upisa");
		datumU = new JTextField();
		 
		        // godina studija
		JLabel labGodinaStud = new JLabel("*Trenutna godina studija:");
		//labGodinaStud.setPreferredSize(new Dimension(100, 50));
		        
		JLabel prosecnaOc = new JLabel("*Prosečna ocena:");
		prosecnaOc.setToolTipText("Unesite prosečnu ocenu");
		prosOc = new JTextField();
		
		JLabel labEmail = new JLabel("*E-pošta: ");
		labEmail.setToolTipText("Unesite email adresu");
		email = new JTextField();
		
		String[] godine = { "I (prva)", "II (druga)", "III (treća)", "IV (četvrta)" };
		godStud = new JComboBox(godine);
		        
		// nacin finansiranja
		budzet = new JRadioButton("Budžet");
		samofin = new JRadioButton("Samofinansiranje");
		
		budzet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				proveriPopunjenost();	
			}
		});

		samofin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				proveriPopunjenost();	
			}
		});
		
		
		// grupa regulise da samo jedan RadioButton može biti čekiran
		ButtonGroup btnGroup1 = new ButtonGroup();
		btnGroup1.add(budzet);
		btnGroup1.add(samofin);
						
		okBtn = new JButton("Potvrda");
		okBtn.setBackground(Color.LIGHT_GRAY);
		notokBtn = new JButton("Odustanak");
		notokBtn.setBackground(Color.LIGHT_GRAY);
		
		up.add(labIme, lbl(0, 0));
		up.add(imeS, tf(1, 0));
		up.add(labPrz, lbl(0, 1));
		up.add(przS, tf(1, 1));
		up.add(labDat, lbl(0, 2));
		up.add(datRodj, tf(1, 2));
		up.add(labAdresa, lbl(0, 3));
		up.add(adresa, tf(1, 3));
		up.add(labBrTel, lbl(0, 4));
		up.add(brtel, tf(1, 4));
		up.add(labBRI, lbl(0, 5));
		up.add(briS, tf(1, 5));
		up.add(labGodU, lbl(0, 6));
		up.add(datumU, tf(1, 6));
		up.add(prosecnaOc, lbl(0, 7));
		up.add(prosOc, tf(1, 7));
		up.add(labGodinaStud, lbl(0, 8));
		up.add(godStud, tf(1, 8));
		up.add(labEmail, lbl(0, 9));
		up.add(email, tf(1, 9));
		up.add(budzet, lbl(0, 10));
		up.add(samofin, lbl(0, 11));
		
		imeS.getDocument().addDocumentListener(documentListener);
		przS.getDocument().addDocumentListener(documentListener);
		datRodj.getDocument().addDocumentListener(documentListener);
		adresa.getDocument().addDocumentListener(documentListener);
		brtel.getDocument().addDocumentListener(documentListener);
		briS.getDocument().addDocumentListener(documentListener);
		datumU.getDocument().addDocumentListener(documentListener);
		prosOc.getDocument().addDocumentListener(documentListener);
		email.getDocument().addDocumentListener(documentListener);
		
		okBtn.setEnabled(false);
		
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(StudentController.getInstance().dodajStudenta()) 
					dispose();
			}
		});
		
		notokBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();	
			}
			
		});
		down.add(notokBtn);
		down.add(okBtn);
		
		this.setResizable(false);
		this.add(up, BorderLayout.NORTH);
		this.add(down, BorderLayout.SOUTH);
		this.setVisible(true);
			
	}

	public static void proveriPopunjenost() {
		if (imeS.getText().trim().isEmpty() || przS.getText().trim().isEmpty() || briS.getText().trim().isEmpty() ||
				adresa.getText().trim().isEmpty() || brtel.getText().trim().isEmpty() || datumU.getText().trim().isEmpty() 
				|| datRodj.getText().trim().isEmpty() || prosOc.getText().trim().isEmpty() || (!budzet.isSelected() && !samofin.isSelected()))
			okBtn.setEnabled(false);
		else {
			okBtn.setEnabled(true);
		}
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
