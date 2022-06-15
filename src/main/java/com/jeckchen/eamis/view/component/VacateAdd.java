package com.jeckchen.eamis.view.component;

import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.entity.Vacate;
import com.jeckchen.eamis.service.VacateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.Color;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;

@Scope("prototype")
@Component("VacateAdd")
public class VacateAdd extends JPanel {

	JTextField reasonField;
	JTextField startField;
	JTextField endField;

	@Autowired
	private VacateService vacateService;

	/**
	 * Create the panel.
	 */
	public VacateAdd(VacateService vacateService) {
		setBackground(new Color(241, 238, 233));
		setBounds(0, 0, 698, 571);
		setLayout(null);
		
		JLabel reason = new JLabel("原因",SwingConstants.RIGHT);
		reason.setFont(new Font("黑体", Font.PLAIN, 18));
		reason.setBounds(10, 100, 202, 30);
		add(reason);

		reasonField = new JTextField();
		reasonField.setFont(new Font("黑体", Font.PLAIN, 18));
		reasonField.setBounds(223, 100, 448, 30);
		add(reasonField);
		reasonField.setColumns(10);

		JLabel start = new JLabel("开始时间",SwingConstants.RIGHT);
		start.setFont(new Font("黑体", Font.PLAIN, 18));
		start.setBounds(10, 150, 202, 30);
		add(start);

		startField = new JTextField();
		startField.setFont(new Font("黑体", Font.PLAIN, 18));
		startField.setBounds(223, 150, 448, 30);
		add(startField);
		startField.setColumns(10);

		JLabel end = new JLabel("结束时间",SwingConstants.RIGHT);
		end.setFont(new Font("黑体", Font.PLAIN, 18));
		end.setBounds(10, 200, 202, 30);
		add(end);

		endField = new JTextField();
		endField.setFont(new Font("黑体", Font.PLAIN, 18));
		endField.setBounds(223, 200, 448, 30);
		add(endField);
		endField.setColumns(10);
		
		JButton submitButton = new JButton("submit");
		Action action = new SubmitAction();
		submitButton.setAction(action);
		submitButton.setFont(new Font("黑体", Font.PLAIN, 18));
		submitButton.setBounds(569, 460, 102, 30);
		add(submitButton);
		
		JLabel tip = new JLabel("Tip：时间格式1970-01-01 14:15 默认状态为1，既未开始");
		tip.setFont(new Font("黑体", Font.PLAIN, 16));
		tip.setBounds(38, 337, 455, 49);
		add(tip);


	}
	private class SubmitAction extends AbstractAction {
		public SubmitAction() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "submit");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			User user = (User) Session.getSession().get(SessionType.USER.toString());
			Vacate vacate = new Vacate();
			vacate.setUserId(user.getId());
			vacate.setReason(reasonField.getText());
			vacate.setStartTime(DateUtil.parse(startField.getText()));
			vacate.setEndTime(DateUtil.parse(endField.getText()));
			vacate.setState(1.0);
			boolean save = vacateService.save(vacate);
			JOptionPane.showMessageDialog(null, "是否成功："+save, "提示", JOptionPane.WARNING_MESSAGE);
		}
	}
}
