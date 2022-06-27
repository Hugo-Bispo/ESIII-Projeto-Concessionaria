package model;

public class ClienteBuilder {
	private Cliente cliente;
	private ClienteEndereco clienteEndereco;

	public ClienteBuilder() {
		this.cliente = new Cliente();
		this.clienteEndereco = new ClienteEndereco();
	}

	public static ClienteBuilder builder() {
		return new ClienteBuilder();
	}

	public ClienteBuilder addNome(String nome) {
		this.cliente.setNome(nome);
		return this;
	}
	
	public ClienteBuilder addCPF(String cpf) {
		this.cliente.setCPF(cpf);
		return this;
	}

	public ClienteBuilder addDados(String cpf, String telefone) {
		this.cliente.setCPF(cpf);
		this.cliente.setTelefone(telefone);
		return this;
	}

	public ClienteBuilder addEndereco(String rua, int numero, String cep, String bairro, String cidade) {
		this.clienteEndereco.setLogadouro(rua);
		this.clienteEndereco.setNumero(numero);
		this.clienteEndereco.setCep(cep);
		this.clienteEndereco.setBairro(bairro);
		this.clienteEndereco.setCidade(cidade);
		return this;
	}

	public Cliente get() {
		this.cliente.setEndereco(clienteEndereco);
		return this.cliente;
	}

}
