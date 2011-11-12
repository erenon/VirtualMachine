package ui.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import ui.model.MemoryContentModel;

public class MemoryContentView extends JTable {
	private static final long serialVersionUID = 1L;
	private MemoryContentModel memoryContentModel = null;
	
	public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
		Component c = super.prepareRenderer(renderer, rowIndex, columnIndex);
		
		if (memoryContentModel == null) {
			memoryContentModel = (MemoryContentModel) getModel();
		}
		
		if (memoryContentModel.isRowActive(rowIndex)) {
			c.setBackground(Color.GREEN);
		} else if (columnIndex == 0 && !isCellSelected(rowIndex, columnIndex)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(getBackground());
		}
		
		return c;
	}
}
