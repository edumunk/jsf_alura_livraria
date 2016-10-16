package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	private int autorId;

	public Livro getLivro() {
		return livro;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public List<Livro> getLivros() {
		List<Livro> listaTodos = new DAO<Livro>(Livro.class).listaTodos();

		return listaTodos;
	}

	public void gravarAutor() {

		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);

		System.out.println(autor.toString());
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {			
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
			return;
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);

		this.livro = new Livro();
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent componente, Object value) throws ValidatorException {
		
		String valor = value.toString();
		
		if(!valor.startsWith("1"))
			throw new ValidatorException(new FacesMessage("O ISBN deve começar com digito 1"));

	}

}
