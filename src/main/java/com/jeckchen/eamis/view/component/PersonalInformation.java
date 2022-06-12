package com.jeckchen.eamis.view.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
//@Component("PersonalInformation")
public class PersonalInformation extends JPanel {



	/**
	 * Create the panel.
	 */

	public PersonalInformation() {

		User user = (User) Session.getSession().get(SessionType.USER.toString());
//		System.out.println(user);

		setBackground(new Color(241, 238, 233));
		setBounds(0, 0, 698, 571);
		setLayout(null);

		JPanel personalInformation = new JPanel();
		personalInformation.setBackground(new Color(241, 238, 233));
		personalInformation.setBounds(0, 0, 698, 571);
		personalInformation.setLayout(null);

		add(personalInformation);

		JLabel 用户名 = new JLabel("用户名:"+user.getUsername());
		用户名.setFont(new Font("黑体", Font.PLAIN, 22));
		用户名.setBounds(107, 75, 500, 43);
		personalInformation.add(用户名);

		JLabel 电话 = new JLabel("电话："+user.getPhone());
		电话.setFont(new Font("黑体", Font.PLAIN, 22));
		电话.setBounds(107, 125, 500, 43);
		personalInformation.add(电话);

		JLabel 性别 = new JLabel("性别："+(user.getSex()==0?"女":"男"));
		性别.setFont(new Font("黑体", Font.PLAIN, 22));
		性别.setBounds(107, 175, 500, 43);
		personalInformation.add(性别);

		JLabel 生日 = new JLabel("生日："+ DateUtil.format(user.getBirthday(),"yyyy年MM月dd日"));
		生日.setFont(new Font("黑体", Font.PLAIN, 22));
		生日.setBounds(107, 225, 500, 43);
		personalInformation.add(生日);

		JLabel 职位 = new JLabel("职位："+user.getJob());
		职位.setFont(new Font("黑体", Font.PLAIN, 22));
		职位.setBounds(107, 275, 500, 43);
		personalInformation.add(职位);

		JLabel 入职时间 = new JLabel("入职时间："+DateUtil.format(user.getEntrytime(),"yyyy年MM月dd日"));
		入职时间.setFont(new Font("黑体", Font.PLAIN, 22));
		入职时间.setBounds(107, 325, 500, 43);
		personalInformation.add(入职时间);

		JLabel 状态 = new JLabel("状态："+user.getState());
		状态.setFont(new Font("黑体", Font.PLAIN, 22));
		状态.setBounds(107, 375, 500, 43);
		personalInformation.add(状态);

		JLabel 用户id = new JLabel("用户id："+user.getId());
		用户id.setFont(new Font("黑体", Font.PLAIN, 22));
		用户id.setBounds(107, 425, 500, 43);
		personalInformation.add(用户id);

		JLabel 状态提示 = new JLabel("状态提示： 0->注销  1->在职  2->管理员");
		状态提示.setFont(new Font("黑体", Font.PLAIN, 16));
		状态提示.setBounds(107, 480, 500, 43);
		personalInformation.add(状态提示);
	}
}
