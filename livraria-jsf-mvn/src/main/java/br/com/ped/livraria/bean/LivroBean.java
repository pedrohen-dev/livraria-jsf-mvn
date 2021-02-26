package br.com.ped.livraria.bean;

import javax.faces.bean.ManagedBean;//CUIDADO na importação, esta "import javax.annotation.ManagedBean;" não serve
import br.com.ped.livraria.dao.DAO;
import br.com.ped.livraria.modelo.Livro;

//@ManagedBean indica que a classe será gerenciada pelo JSF
@ManagedBean
public class LivroBean {

	// na pagina livro.xhtml os atributos do objeto livro instanciado abaixo, são
	// referenciados assim: #{livroBean.livro.titulo}
	private Livro livro = new Livro();

	public void gravar() {

		System.out.println("Gravando livro " + this.livro.getTitulo());
		
		if(livro.getAutores().isEmpty()) {
			throw new RuntimeException("Livro deve ter pelo menos um autor");
		}
		
		new DAO<Livro>(Livro.class).adiciona(this.livro);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
