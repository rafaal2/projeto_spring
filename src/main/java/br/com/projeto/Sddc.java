package br.com.projeto;

public class Sddc {
	private final long id;
	private final String content;

	public Sddc(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
