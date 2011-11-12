package ui.model;

import javax.swing.table.AbstractTableModel;

import cpu.InstructionRunner;

import device.AddressingException;
import device.DeviceObserver;
import device.VmMemory;

public class MemoryContentModel extends AbstractTableModel implements DeviceObserver {
	private static final long serialVersionUID = 1L;
	
	private VmMemory memory;
	private int memorySize;
	private InstructionRunner runner;
	
	public MemoryContentModel(VmMemory memory, int memorySize, InstructionRunner runner) {
		this.memory = memory;
		this.memorySize = memorySize;
		this.runner = runner;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return Integer.class;
		} else {
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "#";
		} else if (columnIndex == 1) {
			return "content";
		} else {
			return null;
		}
	}

	@Override
	public int getRowCount() {
		return memorySize;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return rowIndex;
		} else {
			try {
				return memory.getWord(rowIndex);
			} catch (AddressingException e) {
				e.printStackTrace();
				return "";
			}
		}
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
		if (columnIndex == 1 && 0 <= rowIndex && rowIndex < memorySize) {
			String word = (String) aValue;
			try {
				memory.putWord(rowIndex, word);
			} catch (AddressingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isRowActive(int rowIndex) {
		return (rowIndex == runner.getPcState());
	}

	@Override
	public void fireDataChange(int address) {
		fireTableCellUpdated(address, 0);
		fireTableCellUpdated(address, 1);
	}

}
