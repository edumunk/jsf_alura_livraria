package br.com.caelum.livraria.util;

public abstract class NavigationView {

	private String viewName;

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public NavigationView(String viewName) {
		super();
		this.viewName = viewName;
	}

	@Override
	public abstract String toString();

}