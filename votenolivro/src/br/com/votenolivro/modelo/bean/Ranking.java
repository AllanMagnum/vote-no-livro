package br.com.votenolivro.modelo.bean;

public class Ranking {
	private String livro;
	private Long quantidade;
	
	public Ranking(String livro, Long quantidade) {
		super();
		this.livro = livro;
		this.quantidade = quantidade;
	}
	
	public String getLivro() {
		return livro;
	}
	public void setLivro(String livro) {
		this.livro = livro;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
