package com.jeckchen.eamis.view.component;

import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.VacateService;
import com.jeckchen.eamis.service.WorkOvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Scope("prototype")
@Component("WorkOvertimeModuleIndex")
public class WorkOvertimeModuleIndex extends JPanel {

	@Autowired
	private WorkOvertimeService workOvertimeService;

	/**
	 * Create the panel.
	 */
	public WorkOvertimeModuleIndex() {
		setBounds(0, 0, 698, 571);
		setLayout(null);

		User user = (User) Session.getSession().get(SessionType.USER.toString());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 698, 571);
		add(tabbedPane);

		JPanel workOvertimeList = ((WorkOvertimeList) SpringContextUtils.getBean("WorkOvertimeList"));
		tabbedPane.addTab("加班", null, workOvertimeList, null);

		JPanel workOvertimeAdd = ((WorkOvertimeAdd) SpringContextUtils.getBean("WorkOvertimeAdd"));
		tabbedPane.addTab("加班申请", null, workOvertimeAdd, null);
	}

}
