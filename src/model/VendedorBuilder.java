package model;

public class VendedorBuilder {
	private Vendedor vendedor;

	public VendedorBuilder() {
		this.vendedor = new Vendedor();
	}

	public static VendedorBuilder builder() {
		return new VendedorBuilder();
	}

	public VendedorBuilder addAll(int funcional, String nome, String telefone, String cargo) {
		this.vendedor.setFuncional(funcional);
		this.vendedor.setNome(nome);
		this.vendedor.setTelefone(telefone);
		this.vendedor.setCargo(cargo);
		return this;
	}
	
	public VendedorBuilder addFuncional(int funcional) {
		this.vendedor.setFuncional(funcional);
		return this;
	}
	
	public VendedorBuilder addNome(String nome) {
		this.vendedor.setNome(nome);
		return this;
	}
	
	public VendedorBuilder addTelefone(String telefone) {
		this.vendedor.setTelefone(telefone);
		return this;
	}
	
	public VendedorBuilder addCargo(String cargo) {
		this.vendedor.setCargo(cargo);
		return this;
	}

	public Vendedor get() {
		return this.vendedor;	
	}

}
