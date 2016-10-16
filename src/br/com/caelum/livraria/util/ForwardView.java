package br.com.caelum.livraria.util;

public class ForwardView extends NavigationView {

	public ForwardView(String viewName) {
		super(viewName);
	}

	@Override
	public String toString() {		
		return this.getViewName();
	}
	
}
