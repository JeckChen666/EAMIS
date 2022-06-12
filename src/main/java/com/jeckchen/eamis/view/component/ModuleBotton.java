package com.jeckchen.eamis.view.component;

import java.awt.*;

import javax.swing.*;

import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.view.Home;

import cn.hutool.core.date.DateUtil;

import java.awt.event.ActionEvent;

public class ModuleBotton extends JPanel {
	private final Action goHome = new GoHomeAction();

	/**
	 * Create the panel.
	 */
	public ModuleBotton() {
		setBackground(new Color(21, 19, 60));
		setBounds(0, 571, 698, 32);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(DateUtil.format(DateUtil.date(),"yyyy年MM月dd日 HH时mm分"));
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(10, 0, 217, 32);
		add(lblNewLabel);
		
		JButton goHomeBtn = new JButton("Home");
		goHomeBtn.setAction(goHome);
		goHomeBtn.setForeground(Color.WHITE);
		goHomeBtn.setFont(new Font("黑体", Font.PLAIN, 18));
		goHomeBtn.setBackground(new Color(236,153,75));
		goHomeBtn.setBounds(598, 3, 90, 27);
		add(goHomeBtn);
	}
	private class GoHomeAction extends AbstractAction {
		public GoHomeAction() {
			putValue(NAME, "Home");
			putValue(SHORT_DESCRIPTION, "Go Home");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			((Home) SpringContextUtils.getBean("Home")).setVisible(true);
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
}
