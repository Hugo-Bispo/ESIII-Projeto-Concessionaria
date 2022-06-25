package control;

import java.sql.SQLException;

public interface IController<Classe> {
	public Classe boundaryToEntity() throws SQLException;
	public void entityToBoundary(Classe c) throws SQLException; 
	public void adicionar() throws SQLException;
	public void pesquisar() throws SQLException;
	public void excluir() throws SQLException;
	public void atualizar() throws SQLException;
}
