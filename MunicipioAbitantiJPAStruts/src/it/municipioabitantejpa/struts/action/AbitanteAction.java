package it.municipioabitantejpa.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import it.municipioabitantejpa.model.Abitante;
import it.municipioabitantejpa.model.Municipio;
import it.municipioabitantejpa.service.MyServiceFactory;
import it.municipioabitantejpa.service.abitante.AbitanteService;
import it.municipioabitantejpa.struts.form.AbitanteForm;

public class AbitanteAction extends DispatchAction{
	
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String idAbitanteParam = request.getParameter("idAbitante");
		long idAbitante = Long.parseLong(idAbitanteParam);
		Abitante abitanteInstance = MyServiceFactory.getAbitanteServiceInstance().caricaSingoloAbitante(idAbitante);
		request.setAttribute("AbitanteForm", abitanteInstance);

		return mapping.findForward("show");
	}
	
	public ActionForward showAll(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setAttribute("listaAbitanti", MyServiceFactory.getAbitanteServiceInstance().listAllAbitanti());

		return mapping.findForward("showAll");
	}

	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setAttribute("municipiList", MyServiceFactory.getMunicipioServiceInstance().listAllMunicipi());
		
		return mapping.findForward("create");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		AbitanteForm abitanteForm = (AbitanteForm) form;
		

		try {
			Abitante abitanteDaInserire = new Abitante();
			BeanUtils.copyProperties(abitanteDaInserire, abitanteForm);
			// questa va fatta altrimenti il copyProperties ci mette 0
			abitanteDaInserire.setId(null);
			long idMunicipio = Long.parseLong(request.getParameter("municipioId"));
			Municipio municipioInstance = MyServiceFactory.getMunicipioServiceInstance().caricaSingoloMunicipio(idMunicipio);
			abitanteDaInserire.setMunicipio(municipioInstance);
			MyServiceFactory.getAbitanteServiceInstance().inserisciNuovo(abitanteDaInserire);

		} catch (Exception e) {
			throw e;
		}
		
		request.setAttribute("listaAbitanti", MyServiceFactory.getAbitanteServiceInstance().listAllAbitanti());
		
		return mapping.findForward("showAll");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String idAbitanteParam = request.getParameter("idAbitante");
		long idAbitante = Long.parseLong(idAbitanteParam);

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		try {
			abitanteServiceInstance.rimuovi(abitanteServiceInstance.caricaSingoloAbitante(idAbitante));
		} catch (Exception e) {
			throw e;
		}

		request.setAttribute("listaAbitanti", MyServiceFactory.getAbitanteServiceInstance().listAllAbitanti());
		
		return mapping.findForward("showAll");
	}

}
