package control;

import java.sql.SQLException;

public interface Controller_Interfaces<Classe> {
	public Classe boundaryToEntity() throws SQLException;
	public void entityToBoundary(Classe c) throws SQLException; 
	public void adicionar() throws SQLException;
	public void pesquisar() throws SQLException;
}
