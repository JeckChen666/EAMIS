package com.jeckchen.eamis.view.component;

import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@Scope("prototype")
@Component("PersonalMessageIndex")
public class PersonalMessageIndex extends JPanel {

	@Autowired
	private UserService userService;

	/**
	 * Create the panel.
	 */
	public PersonalMessageIndex() {
		setBounds(0, 0, 698, 571);
		setLayout(null);

		User user = (User) Session.getSession().get(SessionType.USER.toString());

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 698, 571);
		add(tabbedPane);
		
		JPanel personalInformation = new PersonalInformation();
		tabbedPane.addTab("个人信息", null, personalInformation, null);
		
//		JPanel modifyInformation = new JPanel();
		JPanel modifyInformation = ((PersonalModifyInformation) SpringContextUtils.getBean("PersonalModifyInformation"));
		tabbedPane.addTab("修改信息", null, modifyInformation, null);

		JPanel personalList = ((PersonalList) SpringContextUtils.getBean("PersonalList"));
		tabbedPane.addTab("所有职工", null, personalList, null);
	}
}
