package com.jeckchen.eamis.view.component;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class PersonalMessageIndex extends JPanel {

	/**
	 * Create the panel.
	 */
	public PersonalMessageIndex() {
		setBounds(0, 0, 698, 571);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 698, 571);
		add(tabbedPane);
		
		JPanel personalInformation = new JPanel();
		tabbedPane.addTab("个人信息", null, personalInformation, null);
		
		JPanel modifyInformation = new JPanel();
		tabbedPane.addTab("修改信息", null, modifyInformation, null);
	}
}
