package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * Permet la creation du panneau d'authentification.
 * 
 * @author Romain Hamon
 * @author Valentin Pichavant
 */
public class AuthentificationPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1039014372473040398L;
	private Application application;
	private JTextField tfLogin;
	private JButton btnConnexion;
	private JPasswordField pfPassword;

	/**
	 * Accesseur en lecture sur l'application.
	 * 
	 * @return L'application.
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * Accesseur en ecriture sur l'application.
	 * 
	 * @param application
	 *            La nouvelle application.
	 */
	public void setApplication(final Application application) {
		this.application = application;
	}

	/**
	 * Cree le panneau.
	 */
	public AuthentificationPanel() {
		setLayout(
				new FormLayout(
						new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
								ColumnSpec.decode("75px"), FormFactory.RELATED_GAP_COLSPEC, ColumnSpec
										.decode("max(39dlu;default)"),
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("left:default:grow"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(43dlu;default):grow"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(67dlu;pref)"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
								FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("75px"), },
						new RowSpec[] { FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("max(27dlu;default)"),
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("max(5dlu;default)"),
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("max(10dlu;default)"),
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
								FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AjouterPersonnePanel.class.getResource("/resources/ESEO.png")));
		add(label, "2, 2");

		JLabel lblAuthentification = new JLabel("Authentification");
		lblAuthentification.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblAuthentification, "4, 2, 15, 1, center, default");

		JLabel lblEntrerLogin = new JLabel("Entrez votre Login et votre mot de passe SVP");
		add(lblEntrerLogin, "12, 8, 5, 1");

		JLabel lblLogin = new JLabel("Login :");
		add(lblLogin, "12, 12, right, default");

		tfLogin = new JTextField();
		add(tfLogin, "14, 12, fill, default");
		tfLogin.setColumns(10);

		JLabel lblPassword = new JLabel("Password :");
		add(lblPassword, "12, 14, right, default");

		pfPassword = new JPasswordField();
		add(pfPassword, "14, 14, fill, default");

		btnConnexion = new JButton("Connexion");
		add(btnConnexion, "14, 16, right, default");
		btnConnexion.addActionListener(this);
	}

	/**
	 * Construit la classe du panneau d'authentification dans uen application.
	 * 
	 * @param application
	 *            L'application.
	 */
	public AuthentificationPanel(final Application application) {
		this();
		this.setApplication(application);
	}

	/**
	 * Action a effectuer par le Listener lorsqu'une action est realisee.
	 * 
	 * @param arg0
	 *            L'action recuperee.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConnexion) {
			getApplication().getGestionnaireModele().getAuthentification().authentification(tfLogin.getText(),
					pfPassword.getText());
			if (getApplication().getGestionnaireModele().getNiveauAcces() == -1)
				JOptionPane.showMessageDialog(null, "Votre identifiant ou votre mot de passe est faux.",
						"Impossible de vous authentifier", JOptionPane.ERROR_MESSAGE);
			else {
				JOptionPane.showMessageDialog(null, "Vous etes connecte en tant que : " + tfLogin.getText(),
						"Information", JOptionPane.INFORMATION_MESSAGE);
				getApplication().changerPanel(new AccueilPanel(getApplication()));
			}
		}
	}
}
