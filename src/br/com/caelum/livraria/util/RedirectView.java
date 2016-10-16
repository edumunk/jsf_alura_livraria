package br.com.caelum.livraria.util;

public class RedirectView extends NavigationView {
	
	public RedirectView(String viewName) {		
		super(viewName);
	}
	
	@Override
	public String toString() {
	
		return this.getViewName() + "?faces-redirect=true";
		
	}
	
	

}
