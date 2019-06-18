package it.primostruts.struts.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import it.primostruts.dao.UtenteDAO;
import it.primostruts.model.Utente;
import it.primostruts.struts.forms.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// oggetto (ActionForm) usato per scambiare dati con la pagina
		LoginForm loginFormRiempito = (LoginForm) form;

		UtenteDAO utenteDAO = new UtenteDAO("FINTA CONNECTION");

		Utente utenteCheAccede = utenteDAO.findByLoginAndPassword(loginFormRiempito.getLogin(),
				loginFormRiempito.getPassword());

		if (utenteCheAccede == null) {
			request.setAttribute("loginNonAvvenuto", "Credenziali Errate");
			return mapping.findForward("failure");
		}

		//se sono qui la login è andata bene
		request.getSession().setAttribute("utenteInfo", utenteCheAccede);
		
		// preparo una lista finta da inviare alla pagina
		List<String> listaFinta = new ArrayList<String>();
		listaFinta.add("cico");
		listaFinta.add("ioi");
		listaFinta.add(",,,");
		// come al solito posso tranquillamente inserire attributi in request
		request.setAttribute("attributoImpostabileComeSempre", listaFinta);

		// vado via (uso questo al posto di requestDispatcher
		return mapping.findForward("success");

	}

}
