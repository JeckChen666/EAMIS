package com.jeckchen.eamis.view.component;

import java.awt.*;

import javax.swing.*;

import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.Attendance;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.AttendanceService;
import com.jeckchen.eamis.view.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;

@Scope("prototype")
@Component("ClockIn")
public class ClockIn extends JPanel {

	@Autowired
	private AttendanceService attendanceService;

	public User user = (User) Session.getSession().get(SessionType.USER.toString());


	/**
	 * Create the panel.
	 */
	public ClockIn(AttendanceService attendanceService) {
		String userId = user.getId();
		Boolean isClockIn = attendanceService.isClockIn(userId);

		setBackground(new Color(241, 238, 233));
		setBounds(0, 0, 698, 571);
		setLayout(null);
		
		JLabel username = new JLabel("你好："+user.getUsername());
		username.setFont(new Font("黑体", Font.PLAIN, 22));
		username.setBounds(37, 143, 472, 46);
		add(username);
		
		JLabel clockInState = new JLabel("打卡情況："+isClockIn);
		clockInState.setFont(new Font("黑体", Font.PLAIN, 22));
		clockInState.setBounds(37, 204, 472, 46);
		add(clockInState);

		if (isClockIn){
			Attendance attendance = attendanceService.getAttendanceById(user.getId());
			JLabel clockInMessage = new JLabel("时间："+DateUtil.format(attendance.getCreateTime(),"HH时mm分ss秒")+"  状态码："+String.valueOf(attendance.getState()));
			clockInMessage.setFont(new Font("黑体", Font.PLAIN, 18));
			clockInMessage.setBounds(37, 230, 472, 46);
			add(clockInMessage);

			JLabel clockInTip = new JLabel("状态提示：0->早到  1->正常(9-12)  2->迟到");
			clockInTip.setFont(new Font("黑体", Font.PLAIN, 18));
			clockInTip.setBounds(37, 260, 472, 46);
			add(clockInTip);
		}
		
		JButton clockInBtn = new JButton("打卡");
		clockInBtn.setVisible(!isClockIn);
		Action action = new ClockInAction();
		clockInBtn.setAction(action);
		clockInBtn.setBounds(479, 310, 140, 36);
		add(clockInBtn);

		
	}

	private class ClockInAction extends AbstractAction {
		public ClockInAction() {
			putValue(NAME, "打卡");
			putValue(SHORT_DESCRIPTION, "Clock in");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Boolean isOK = attendanceService.clockIn(user.getId());
			JOptionPane.showMessageDialog(null, "是否成功："+isOK, "提示", JOptionPane.WARNING_MESSAGE);

			((Home) SpringContextUtils.getBean("Home")).setVisible(true);
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
}
