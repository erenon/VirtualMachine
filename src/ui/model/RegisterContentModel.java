package ui.model;

import javax.swing.table.AbstractTableModel;

import cpu.InstructionRunner;
import cpu.InstructionRunner.REGISTER_NAME;
import cpu.InvalidRegisterException;

import device.DeviceObserver;

public class RegisterContentModel extends AbstractTableModel implements	DeviceObserver {
	private static final long serialVersionUID = 1L;
	private InstructionRunner runner;
	private int registerCount;

	public RegisterContentModel(InstructionRunner runner) {
		this.runner = runner;
		registerCount = InstructionRunner.REGISTER_NAME.values().length;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return String.class;
		} else {
			return Integer.class;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "reg";
		} else if (columnIndex == 1) {
			return "content";
		} else {
			return null;
		}
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return registerCount;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (columnIndex == 1 && 0 <= rowIndex && rowIndex < registerCount) {
			
			try {
				Integer value = (Integer) aValue;
				REGISTER_NAME registerName = REGISTER_NAME.values()[rowIndex];
				runner.setRegisterContent(registerName, value);
			} catch (ClassCastException e) {
				// only integers allowed
				e.printStackTrace();
			} catch (InvalidRegisterException e) {
				// unknown register
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		REGISTER_NAME registerName = REGISTER_NAME.values()[rowIndex];
		
		if (columnIndex == 0) {
			return registerName.toString().toLowerCase();
		} else {
			try {
				return runner.getRegisterContent(registerName);
			} catch (InvalidRegisterException e) {
				// unknown register
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void fireDataChange(int address) {
		fireTableCellUpdated(address, 0);
		fireTableCellUpdated(address, 1);
	}

}
