package com.jeckchen.eamis.view.component;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.entity.BusinessTrip;
import com.jeckchen.eamis.entity.TripUser;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.entity.WorkOvertime;
import com.jeckchen.eamis.service.BusinessTripService;
import com.jeckchen.eamis.service.TripUserService;
import com.jeckchen.eamis.service.WorkOvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Scope("prototype")
@Component("BusinessTripAdd")
public class BusinessTripAdd extends JPanel {

	JTextField reasonField;
	JTextField startField;
	JTextField endField;
	JTextField locationField;
	JTextField costField;

	@Autowired
	private BusinessTripService businessTripService;

	@Autowired
	private TripUserService tripUserService;

	/**
	 * Create the panel.
	 */
	public BusinessTripAdd(BusinessTripService businessTripService,TripUserService tripUserService) {
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

		JLabel location = new JLabel("位置",SwingConstants.RIGHT);
		location.setFont(new Font("黑体", Font.PLAIN, 18));
		location.setBounds(10, 250, 202, 30);
		add(location);

		locationField = new JTextField();
		locationField.setFont(new Font("黑体", Font.PLAIN, 18));
		locationField.setBounds(223, 250, 448, 30);
		add(locationField);
		locationField.setColumns(10);

		JLabel cost = new JLabel("花费",SwingConstants.RIGHT);
		cost.setFont(new Font("黑体", Font.PLAIN, 18));
		cost.setBounds(10, 300, 202, 30);
		add(cost);

		costField = new JTextField();
		costField.setFont(new Font("黑体", Font.PLAIN, 18));
		costField.setBounds(223, 300, 448, 30);
		add(costField);
		costField.setColumns(10);



		JButton submitButton = new JButton("submit");
		Action action = new SubmitAction();
		submitButton.setAction(action);
		submitButton.setFont(new Font("黑体", Font.PLAIN, 18));
		submitButton.setBounds(569, 460, 102, 30);
		add(submitButton);
		
		JLabel tip = new JLabel("Tip：");
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
			String id = IdUtil.getSnowflakeNextIdStr();

			BusinessTrip businessTrip = new BusinessTrip();
			businessTrip.setId(id);
			businessTrip.setReason(reasonField.getText());
			businessTrip.setStartTime(DateUtil.parse(startField.getText()));
			businessTrip.setEndTime(DateUtil.parse(endField.getText()));
			businessTrip.setState(1.0);
			businessTrip.setCost(Double.valueOf(costField.getText()));
			businessTrip.setLocation(locationField.getText());

			TripUser tripUser = new TripUser();
			tripUser.setTripId(id);
			tripUser.setUserId(user.getId());

			boolean save = businessTripService.save(businessTrip);
			boolean saveRelation = tripUserService.save(tripUser);
			JOptionPane.showMessageDialog(null, "是否成功："+(save&&saveRelation), "提示", JOptionPane.WARNING_MESSAGE);
		}
	}
}
