package ui.view;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import ui.controller.ComputerController;
import ui.model.DisplayModel;

public class FrontView extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	/** Creates new form FrontController */
	public FrontView() {
		//initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		labelMemory = new javax.swing.JLabel();
		labelDisplayOutput = new javax.swing.JLabel();
		labelRegisters = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		outputTextarea = new javax.swing.JTextArea();
		jScrollPane3 = new javax.swing.JScrollPane();
		registerTable = new javax.swing.JTable();
		buttonRun = new javax.swing.JButton();
		buttonStep = new javax.swing.JButton();
		buttonRestart = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		memoryContent = (memoryContent == null) ? new JTable() : memoryContent;
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		saveMenuItem = new javax.swing.JMenuItem();
		saveAsMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(3);

		labelMemory.setText("Memory:");

		labelDisplayOutput.setText("Display output:");

		labelRegisters.setText("CPU registers");

		outputTextarea.setColumns(20);
		outputTextarea.setEditable(false);
		outputTextarea.setRows(5);
		displayModel.setTextarea(outputTextarea);
		jScrollPane2.setViewportView(outputTextarea);

		registerTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane3.setViewportView(registerTable);

		buttonRun.setText("Run");

		buttonStep.setText("Step");
		buttonStep.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonStepActionPerformed(evt);
			}
		});

		buttonRestart.setText("Reset");
		buttonRestart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonRestartActionPerformed(evt);
			}
		});

		memoryContent.setModel(memoryContentModel);
		memoryContent.setAutoCreateRowSorter(true);
		memoryContent.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		memoryContent.setCellSelectionEnabled(true);
		jScrollPane1.setViewportView(memoryContent);

		fileMenu.setText("File");

		openMenuItem.setText("Open");
		fileMenu.add(openMenuItem);

		saveMenuItem.setText("Save");
		fileMenu.add(saveMenuItem);

		saveAsMenuItem.setText("Save As ...");
		fileMenu.add(saveAsMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(
																		labelMemory)
																.addGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		layout.createSequentialGroup()
																				.addComponent(
																						buttonRestart)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(
																						buttonStep)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(
																						buttonRun)))
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														238,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														351,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														labelDisplayOutput))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(labelRegisters)
												.addComponent(
														jScrollPane3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														273,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(labelMemory)
												.addComponent(
														labelDisplayOutput)
												.addComponent(labelRegisters))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jScrollPane3,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														418, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		384,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						buttonRun)
																				.addComponent(
																						buttonStep)
																				.addComponent(
																						buttonRestart))
																.addGap(1, 1, 1))
												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														418, Short.MAX_VALUE))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void buttonRestartActionPerformed(java.awt.event.ActionEvent evt) {
		computerController.resetButtonClicked(evt);
	}

	private void buttonStepActionPerformed(java.awt.event.ActionEvent evt) {
		computerController.stepButtonClicked(evt);
	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}//GEN-LAST:event_exitMenuItemActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrontView().setVisible(true);
			}
		});
	}

	public void setMemoryContentView(JTable view) {
		memoryContent = view;
	}

	public void setMemoryContentModel(TableModel model) {
		memoryContentModel = model;
	}

	public void setDisplayModel(DisplayModel model) {
		displayModel = model;
	}

	public void setComputerController(ComputerController computerController) {
		this.computerController = computerController;
	}

	public void init() {
		initComponents();

		setTitle("VirtualMachine");

		memoryContent
				.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
		memoryContent.getColumnModel().getColumn(0).setPreferredWidth(24);
		memoryContent.getColumnModel().getColumn(0).setMinWidth(24);
		memoryContent.getColumnModel().getColumn(0).setMaxWidth(48);

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton buttonRestart;
	private javax.swing.JButton buttonRun;
	private javax.swing.JButton buttonStep;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JLabel labelDisplayOutput;
	private javax.swing.JLabel labelMemory;
	private javax.swing.JLabel labelRegisters;
	private javax.swing.JTable memoryContent;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JTextArea outputTextarea;
	private javax.swing.JTable registerTable;
	private javax.swing.JMenuItem saveAsMenuItem;
	private javax.swing.JMenuItem saveMenuItem;
	// End of variables declaration//GEN-END:variables

	// models
	private TableModel memoryContentModel;
	private DisplayModel displayModel;

	// controllers
	private ComputerController computerController;

}