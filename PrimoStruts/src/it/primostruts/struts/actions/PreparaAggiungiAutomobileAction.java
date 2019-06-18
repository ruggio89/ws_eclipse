package it.primostruts.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class PreparaAggiungiAutomobileAction extends DispatchAction {
	
	public ActionForward aggiungi(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
		
		System.out.println("aggiungo..............................");
		return arg0.findForward("success");
	}

}
