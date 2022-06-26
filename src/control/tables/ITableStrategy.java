package control.tables;

import javafx.scene.control.TableView;

public interface ITableStrategy <T> {
	public TableView<T> getTable();

}
