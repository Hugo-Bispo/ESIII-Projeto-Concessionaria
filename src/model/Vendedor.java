package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@Column(name = "funcional")
	@NotNull
	private int funcional;

	@Column(name = "nome", length = 50)
	@NotNull
	private String nome;

	@Column(name = "telefone", length = 11)
	private String telefone;

	@Column(name = "cargo", length = 20)
	private String cargo;

	public int getFuncional() {
		return funcional;
	}

	public void setFuncional(int funcional) {
		this.funcional = funcional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Vendedor [funcional=" + funcional + ", nome=" + nome + ", telefone=" + telefone + ", cargo=" + cargo
				+ "]";
	}

}
