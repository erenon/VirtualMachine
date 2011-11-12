package ui.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RegisterContentView extends JTable {
	private static final long serialVersionUID = 1L;
	
	public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {
		Component c = super.prepareRenderer(renderer, rowIndex, columnIndex);
		
	
		if (columnIndex == 0 && !isCellSelected(rowIndex, columnIndex)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(getBackground());
		}
		
		return c;
	}

}
