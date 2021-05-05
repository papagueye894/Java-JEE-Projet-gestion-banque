package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;
@WebServlet(name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	private ICreditMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier=new CreditMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Lire les donnees de la requete
		 */
		double montant=Double.parseDouble(request.getParameter("montant"));
		double taux=Double.parseDouble(request.getParameter("taux"));
		int duree=Integer.parseInt(request.getParameter("duree"));
		/*
		 * Valider les donnees
		 */
		
		/*
		 * Stocker les donnees saisis dans le modele
		 */
		CreditModel model=new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		/*
		 * Faire appel a la couche metier pour effectuer les traitements
		 */
		
		double res=metier.calculerMensualiteCredit(montant, taux, duree); 
		/*
		 * Stocker les resultats dans le modele
		 */
		model.setMensualite(res); 
		/*
		 * Stocker le modele dans l'objet request
		 */
		request.setAttribute("creditModel", model);
		/*
		 * Faire un forward vers la vue JSP
		 */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
}