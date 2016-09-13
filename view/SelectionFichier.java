package view;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Permet de selectionner un fichier.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class SelectionFichier extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8973770583385801721L;
	static private final String newline = "\n";
	JButton openButton, exitButton;
	JTextArea log;
	JFileChooser fc;
	JFrame jframe;

	/**
	 * Permet de construire le panneau de selection de fichier.
	 */
	public SelectionFichier() {
		super(new BorderLayout());
		this.setLog(new JTextArea(10, 40));
		this.getLog().setMargin(new Insets(5, 5, 5, 5));
		this.getLog().setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(this.getLog());
		this.setFc(new JFileChooser());
		this.getFc().setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		this.setOpenButton(new JButton("Ouvrir un fichier"));
		this.getOpenButton().addActionListener(this);
		this.setExitButton(new JButton("Quitter"));
		this.getExitButton().addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(this.getOpenButton());
		buttonPanel.add(this.getExitButton());
		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);
	}

	/**
	 * Permet de construire le panneau de selection de fichier.
	 * 
	 * @param jframe
	 *            La JFrame du panneau.
	 */
	public SelectionFichier(JFrame jframe) {
		this();
		this.jframe = jframe;
	}

	/**
	 * Accesseur en lecture sur le bouton d'ouverture.
	 * 
	 * @return Le bouton d'ouverture.
	 */
	public JButton getOpenButton() {
		return openButton;
	}

	/**
	 * Accesseur en lecture sur le bouton d'ouverture.
	 * 
	 * @param openButton
	 *            Le nouveau bouton d'ouverture.
	 */
	public void setOpenButton(JButton openButton) {
		this.openButton = openButton;
	}

	/**
	 * Accesseur en lecture sur le bouton de sortie.
	 * 
	 * @return Le bouton de sortie.
	 */
	public JButton getExitButton() {
		return exitButton;
	}

	/**
	 * Accesseur en lecture sur le bouton de sortie.
	 * 
	 * @param exitButton
	 *            Le nouveau bouton de sortie.
	 */
	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	/**
	 * Accesseur en lecture sur la zone de texte.
	 * 
	 * @return La zone de texte.
	 */
	public JTextArea getLog() {
		return log;
	}

	/**
	 * Accesseur en lecture sur la zone de texte.
	 * 
	 * @param log
	 *            La nouvelle zone de texte.
	 */
	public void setLog(JTextArea log) {
		this.log = log;
	}

	/**
	 * Accesseur en lecture sur le file chooser.
	 * 
	 * @return Le file chooser.
	 */
	public JFileChooser getFc() {
		return fc;
	}

	/**
	 * Accesseur en lecture sur le file chooser.
	 * 
	 * @param fc
	 *            Le nouveau file chooser.
	 */
	public void setFc(JFileChooser fc) {
		this.fc = fc;
	}

	/**
	 * Accesseur en lecture sur la zone de la jframe.
	 * 
	 * @return La jframe.
	 */
	public JFrame getJframe() {
		return jframe;
	}

	/**
	 * Accesseur en ecriture sur la JFrame.
	 * 
	 * @param jframe
	 *            La nouvelle jframe.
	 */
	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
	}

	/**
	 * Accesseur en lecture sur la nouvelle ligne.
	 * 
	 * @return La nouvelle ligne.
	 */
	public static String getNewline() {
		return newline;
	}

	/**
	 * Les actions a effectuer lors d'un evenement.
	 * 
	 * @param e
	 *            L'evenement a traiter.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getOpenButton()) {
			int returnVal = this.getFc().showOpenDialog(SelectionFichier.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = this.getFc().getSelectedFile();
				this.getLog().append("Ouverture de : " + file.getAbsolutePath() + "." + getNewline());
				LancerEditeurDeTexte.lancer(file.getAbsolutePath());
			} else {
				this.getLog().append("Vous avez annulé l'ouverture d'un fichier." + newline);
			}
			this.getLog().setCaretPosition(log.getDocument().getLength());
		} else if (e.getSource() == this.getExitButton()) {
			this.getJframe().dispose();
		}
	}

}