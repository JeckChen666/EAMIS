package com.jeckchen.eamis.view;

import com.jeckchen.eamis.view.component.PersonalMessageIndex;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ModulePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ModulePage frame = new ModulePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModulePage() {
        setTitle("EAMIS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(712, 640));
        setBounds(100, 100, 585, 510);

        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.PINK);
		setContentPane(contentPane);
		
		JPanel moduleBotton = new JPanel();
		moduleBotton.setLayout(null);
		moduleBotton.setBackground(Color.BLUE);
		moduleBotton.setBounds(0, 571, 698, 32);
		contentPane.add(moduleBotton);

		JPanel moduleContent = new PersonalMessageIndex();
		moduleContent.setLayout(null);
		moduleContent.setBackground(Color.GRAY);
		moduleContent.setBounds(0, 0, 698, 571);
		contentPane.add(moduleContent);

//		JPanel moduleContent = new JPanel();
//		moduleContent.setLayout(null);
//		moduleContent.setBackground(Color.GRAY);
//		moduleContent.setBounds(0, 0, 698, 571);
//		contentPane.add(moduleContent);
//
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setSize(698, 571);
//		moduleContent.add(tabbedPane);
//
//		JPanel panel = new JPanel();
//		tabbedPane.addTab("New tab", null, panel, null);
	}
}
