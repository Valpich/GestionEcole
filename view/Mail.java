package view;

import java.awt.Color;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JDialog;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Classe permettant d'envoyer des emails.
 * 
 * @author Romain Hamon.
 * @author Valentin Pichavant.
 */
public class Mail {

	private final static String DEFAULT_FROM = "projetjavaeseo@gmail.com";
	private final static String DEFAULT_USERNAME = "projetjavaeseo@gmail.com";
	private final static String DEFAULT_PASSWORD = "eseoeseo";
	private String from = "projetjavaeseo@gmail.com";
	private String username = "projetjavaeseo@gmail.com";
	private String password = "eseoeseo";
	private Properties propriete;
	private static JDialog notesDernierExamen;

	/**
	 * Instancie la classe Mail par defaut.
	 */
	public Mail() {
		this.setFrom(DEFAULT_FROM);
		this.setPassword(DEFAULT_PASSWORD);
		this.setUsername(DEFAULT_USERNAME);
		this.setPropriete(new Properties());
		this.getPropriete().put("mail.smtp.starttls.enable", true);
		this.getPropriete().put("mail.smtp.host", "smtp.gmail.com");
		this.getPropriete().put("mail.smtp.user", "username");
		this.getPropriete().put("mail.smtp.password", "password");
		this.getPropriete().put("mail.smtp.port", "587");
		this.getPropriete().put("mail.smtp.auth", true);
	}

	/**
	 * Accesseur en lecture de l'adresse de connexion.
	 * 
	 * @return L'adresse.
	 */
	public String getFrom() {
		return this.from;
	}

	/**
	 * Accesseur en lecture du nom d'utilisateur.
	 * 
	 * @return Le nom d'utilisateur.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Accesseur en lecture du mot de passe.
	 * 
	 * @return Le mot de passe.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Accesseur en ecriture de l'adresse de connexion.
	 * 
	 * @param value
	 *            La nouvelle adresse.
	 */
	public void setFrom(final String value) {
		this.from = value;
	}

	/**
	 * Accesseur en ecriture du nom d'utilisateur.
	 * 
	 * @param value
	 *            Le nouveau nom d'utilisateur.
	 */
	public void setUsername(final String value) {
		this.username = value;
	}

	/**
	 * Accesseur en ecriture du mot de passe.
	 * 
	 * @param value
	 *            Le nouveau mot de passe.
	 */
	public void setPassword(final String value) {
		this.password = value;
	}

	/**
	 * Accesseur en lecture sur la propriete de connexion.
	 * 
	 * @return La propriete de connexion.
	 */
	public Properties getPropriete() {
		return propriete;
	}

	/**
	 * Accesseur en ecriture sur la propriete de connexion.
	 * 
	 * @param propriete
	 *            La nouvelle propriete de connexion.
	 */
	public void setPropriete(final Properties propriete) {
		this.propriete = propriete;
	}

	/**
	 * Methode permettant d'envoyer un email à une liste de receveur en y
	 * incluant un graphique genere par la methode genererGraphique de la classe
	 * Mail.
	 * 
	 * @param receveurs
	 *            La liste des adresses mail des destinataires.
	 * @param matiere
	 *            Le nom de la matiere du devoir.
	 * @param notes
	 *            La liste des notes.
	 */
	public void mailAutomatique(String[] receveurs, String matiere, List<Integer> notes) {
		Session session = Session.getInstance(getPropriete(), new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(getUsername(), getPassword());
			}
		});
		genererGraphique(matiere, notes);
		for (String receveur : receveurs) {
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(this.getFrom()));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receveur));
				message.setSubject(new String("Resultats de l'epreuve de la matiere : " + matiere));
				MimeMultipart multipart = new MimeMultipart("related");
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setContent(
						new String(
								"Bonjour.<br>Veuillez-trouver ci-joint la repartition des notes obtenues lors du devoir, vos notes individuelles sont disponibles en ligne.<br>Cordialement.<img src=\"cid:image\">"),
						"text/html");
				multipart.addBodyPart(messageBodyPart);
				messageBodyPart = new MimeBodyPart();
				DataSource fds = new FileDataSource("graphique.jpg");
				messageBodyPart.setDataHandler(new DataHandler(fds));
				messageBodyPart.setHeader("Content-ID", "<image>");
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
				Transport.send(message);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Permet de generer un graphique en barre en fonction d'une liste d'entier
	 * et d'utiliser la matiere pour definir le titre.
	 * 
	 * @param matiere
	 *            La matiere du devoir a ajouter en titre du graphique.
	 * @param notes
	 *            La liste des notes a representer dans le graphique.
	 */
	public void genererGraphique(String matiere, List<Integer> notes) {
		notesDernierExamen = new JDialog();
		notesDernierExamen.setTitle("Nombre d'etudiants en fonction des notes " + matiere);
		final Map<Integer, Integer> repartition = new HashMap<Integer, Integer>();
		for (int i = 0; i <= 20; i++) {
			repartition.put(i, 0);
		}
		for (Integer noteEleve : notes) {
			Double note = (double) noteEleve.intValue();
			incrementNb(note, repartition);
		}
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i <= 20; i++) {
			dataset.addValue(repartition.get(i), "Notes des etudiants", new Integer(i));
		}
		final JFreeChart graphique = ChartFactory.createBarChart(new String("Repartition des notes du devoir"), "Note",
				"Nombre d'etudiant", dataset, PlotOrientation.VERTICAL, false, false, false);
		final CategoryPlot plot = graphique.getCategoryPlot();
		class RenduGraphique extends BarRenderer {

			private static final long serialVersionUID = 7952830250874704345L;
			private Paint[] colors;

			public RenduGraphique(final Paint[] colors) {
				this.colors = colors;
			}

			@Override
			public Paint getItemPaint(final int row, final int column) {
				return this.colors[column % this.colors.length];
			}
		}
		final CategoryItemRenderer renderer = new RenduGraphique(
				new Paint[] { Color.red, Color.red, Color.red, Color.red, Color.orange, Color.orange, Color.orange,
						Color.orange, Color.yellow, Color.yellow, Color.yellow, Color.yellow, Color.green, Color.green,
						Color.green, Color.green, Color.cyan, Color.cyan, Color.cyan, Color.cyan, Color.blue });
		plot.setRenderer(renderer);
		final ChartPanel cPanel = new ChartPanel(graphique);
		notesDernierExamen.getContentPane().add(cPanel);
		notesDernierExamen.pack();
		notesDernierExamen.setVisible(false);
		try {
			ChartUtilities.saveChartAsJPEG(new File("graphique.jpg"), graphique, 1000, 560);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		notesDernierExamen.dispose();
	}

	/**
	 * Permet d'incrementer la Map repartition avec une note arrondie.
	 * 
	 * @param note
	 *            La note a ajouter.
	 * @param repartition
	 *            La Map contenant les notes arrondies.
	 */
	private void incrementNb(Double note, Map<Integer, Integer> repartition) {
		int floor = (int) Math.floor(note);
		Integer nb = repartition.get(floor);
		nb++;
		repartition.put(floor, nb);
	}

	/**
	 * Methode statique permettant de generer un mail à partir d'une liste de
	 * notes.
	 * 
	 * @param notes
	 *            Liste des notes a transmettre.
	 * @param receveurs
	 *            Liste des receveurs a qui envoyer les notes.
	 * @param matiere
	 *            La matiere.
	 */
	public void emailNotes(final ArrayList<Integer> notes, String[] receveurs, String matiere) {
		ArrayList<Integer> note = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			note.add(new Integer((int) (r.nextFloat() * 21)));
		}
		mailAutomatique(receveurs, matiere, notes);
	}

}