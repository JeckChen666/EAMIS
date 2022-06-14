package com.jeckchen.eamis.view.component;

import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.BusinessTripService;
import com.jeckchen.eamis.service.WorkOvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Scope("prototype")
@Component("BusinessTripModuleIndex")
public class BusinessTripModuleIndex extends JPanel {

	@Autowired
	private BusinessTripService businessTripService;

	/**
	 * Create the panel.
	 */
	public BusinessTripModuleIndex() {
		setBounds(0, 0, 698, 571);
		setLayout(null);

		User user = (User) Session.getSession().get(SessionType.USER.toString());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 698, 571);
		add(tabbedPane);

		JPanel businessTripList = ((BusinessTripList) SpringContextUtils.getBean("BusinessTripList"));
		tabbedPane.addTab("出差", null, businessTripList, null);
	}

}
