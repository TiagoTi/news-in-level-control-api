package br.net.ti2.newsinlevelcontrolapi.dto;

public class ErroDeValicacaoHandlerDto {
	private String campo;
	private String erro;

	public ErroDeValicacaoHandlerDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
