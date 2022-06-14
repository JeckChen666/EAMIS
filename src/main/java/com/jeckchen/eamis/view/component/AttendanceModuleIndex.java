package com.jeckchen.eamis.view.component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("AttendanceModuleIndex")
public class AttendanceModuleIndex extends JPanel {

	@Autowired
	private AttendanceService attendanceService;

	/**
	 * Create the panel.
	 */
	public AttendanceModuleIndex() {
		setBounds(0, 0, 698, 571);
		setLayout(null);

		User user = (User) Session.getSession().get(SessionType.USER.toString());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 698, 571);
		add(tabbedPane);

		JPanel clockIn = ((ClockIn) SpringContextUtils.getBean("ClockIn"));
		tabbedPane.addTab("个人打卡", null, clockIn, null);

		JPanel attendanceList = ((AttendanceList) SpringContextUtils.getBean("AttendanceList"));
		tabbedPane.addTab("打卡记录", null, attendanceList, null);

//		JPanel modifyInformation = new JPanel();
//		JPanel modifyInformation = ((PersonalModifyInformation) SpringContextUtils.getBean("PersonalModifyInformation"));
//		tabbedPane.addTab("修改信息", null, modifyInformation, null);
	}
}


