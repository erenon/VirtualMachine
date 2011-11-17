package ui.view;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import ui.controller.ComputerController;
import ui.controller.MemoryController;
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
		registerContentView = (registerContentView == null) ? new JTable()
				: registerContentView;
		buttonRun = new javax.swing.JButton();
		buttonStep = new javax.swing.JButton();
		buttonRestart = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		memoryContentView = (memoryContentView == null) ? new JTable()
				: memoryContentView;
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		newMenuItem = new javax.swing.JMenuItem();
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

		registerContentView.setModel(registerContentModel);
		jScrollPane3.setViewportView(registerContentView);

		buttonRun.setText("Run");
		buttonRun.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonRunActionPerformed(evt);
			}
		});

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

		memoryContentView.setModel(memoryContentModel);
		memoryContentView.setAutoCreateRowSorter(true);
		memoryContentView.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		memoryContentView.setCellSelectionEnabled(true);
		jScrollPane1.setViewportView(memoryContentView);

		fileMenu.setText("File");

		newMenuItem.setText("New");
		newMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newMenuItemActionPerformed(evt);
			}
		});

		fileMenu.add(newMenuItem);

		openMenuItem.setText("Open ...");
		openMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(openMenuItem);

		saveMenuItem.setText("Save");
		saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(saveMenuItem);

		saveAsMenuItem.setText("Save As ...");
		saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveAsMenuItemActionPerformed(evt);
			}
		});
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
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(labelMemory)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														238,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
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
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		buttonRestart)
																.addGap(18, 18,
																		18)
																.addComponent(
																		buttonStep)
																.addGap(18, 18,
																		18)
																.addComponent(
																		buttonRun,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
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
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane3,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		379,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						buttonRestart)
																				.addComponent(
																						buttonStep)
																				.addComponent(
																						buttonRun)))
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														418, Short.MAX_VALUE)
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
		outputTextarea.setText(null);
	}

	private void buttonStepActionPerformed(java.awt.event.ActionEvent evt) {
		computerController.stepButtonClicked(evt);
	}

	private void buttonRunActionPerformed(java.awt.event.ActionEvent evt) {
		computerController.runButtonClicked(evt);
	}
	
	private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		memoryController.newMemoryContent(evt);
	}

	private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		memoryController.loadMemoryContent(evt);
	}
	
	private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		memoryController.storeMemoryContent(evt);
	}
	
	private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		memoryController.storeMemoryContentAs(evt);
	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}//GEN-LAST:event_exitMenuItemActionPerformed
	
	// custom methods

	public void setMemoryContentView(JTable view) {
		memoryContentView = view;
	}

	public void setRegisterContentView(JTable view) {
		registerContentView = view;
	}

	public void setMemoryContentModel(TableModel model) {
		memoryContentModel = model;
	}

	public void setDisplayModel(DisplayModel model) {
		displayModel = model;
	}

	public void setRegisterContentModel(TableModel model) {
		registerContentModel = model;
	}

	public void setComputerController(ComputerController controller) {
		computerController = controller;
	}

	public void setMemoryController(MemoryController controller) {
		memoryController = controller;
	}

	public void init() {
		initComponents();

		setTitle("VirtualMachine");

		memoryContentView.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		memoryContentView.getColumnModel().getColumn(0).setPreferredWidth(24);
		memoryContentView.getColumnModel().getColumn(0).setMinWidth(24);
		memoryContentView.getColumnModel().getColumn(0).setMaxWidth(48);

		registerContentView.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		registerContentView.getColumnModel().getColumn(0).setPreferredWidth(30);
		/*registerContentView.getColumnModel().getColumn(0).setMinWidth(30);*/
		registerContentView.getColumnModel().getColumn(0).setMaxWidth(30);
		registerContentView.getColumnModel().getColumn(0).setResizable(false);
		
		outputTextarea.setLineWrap(true);

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
	private javax.swing.JTable memoryContentView;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem newMenuItem;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JTextArea outputTextarea;
	private javax.swing.JTable registerContentView;
	private javax.swing.JMenuItem saveAsMenuItem;
	private javax.swing.JMenuItem saveMenuItem;
	// End of variables declaration//GEN-END:variables

	// models
	private TableModel memoryContentModel;
	private DisplayModel displayModel;
	private TableModel registerContentModel;

	// controllers
	private ComputerController computerController;
	private MemoryController memoryController;

}