package com.jeckchen.eamis.view.component;

import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.VacateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Scope("prototype")
@Component("VacateModuleIndex")
public class VacateModuleIndex extends JPanel {

	@Autowired
	private VacateService vacateService;

	/**
	 * Create the panel.
	 */
	public VacateModuleIndex() {
		setBounds(0, 0, 698, 571);
		setLayout(null);

		User user = (User) Session.getSession().get(SessionType.USER.toString());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 698, 571);
		add(tabbedPane);

		JPanel vacateList = ((VacateList) SpringContextUtils.getBean("VacateList"));
		tabbedPane.addTab("请假表", null, vacateList, null);
	}

}
