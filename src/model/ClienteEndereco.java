package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienteEndereco")
public class ClienteEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private int id_endereco;

	@Column(name = "rua", length = 20)
	private String rua;

	@Column(name = "numero")
	private int numero;

	@Column(name = "cep", length = 8)
	private String cep;

	@Column(name = "bairro", length = 8)
	private String bairro;

	@Column(name = "cidade", length = 20)
	private String cidade;

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "ClienteEndereco [id_endereco=" + id_endereco + ", rua=" + rua + ", numero=" + numero + ", cep=" + cep
				+ ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}

}
