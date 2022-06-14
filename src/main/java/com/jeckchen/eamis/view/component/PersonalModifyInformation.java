package com.jeckchen.eamis.view.component;

import java.awt.*;

import javax.swing.*;

import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;

@Scope("prototype")
@Component("PersonalModifyInformation")
public class PersonalModifyInformation extends JPanel {
	private JTextField 用户名框;
	private JTextField 电话框;
	private JTextField 性别框;
	private JTextField 生日框;
	private JTextField 职位框;
	private JTextField 入职时间框;
	private JTextField 状态框;
	private JTextField ID框;
	private final Action search = new Search();
	private final Action action = new Submit();

	@Autowired
	private UserService userService;

	public User user = (User) Session.getSession().get(SessionType.USER.toString());
	public User nowUser = user;

	/**
	 * Create the panel.
	 */
	public PersonalModifyInformation(UserService userService) {

		setBackground(new Color(241, 238, 233));
		setBounds(0, 0, 698, 571);
		setLayout(null);
		
		JPanel modifyInformation = new JPanel();
		modifyInformation.setBounds(0, 0, 698, 571);
		modifyInformation.setBackground(new Color(241, 238, 233));
		add(modifyInformation);
		modifyInformation.setLayout(null);
		
		用户名框 = new JTextField();
		用户名框.setFont(new Font("黑体", Font.PLAIN, 16));
		用户名框.setText(nowUser.getUsername());
		用户名框.setBounds(215, 117, 273, 22);
		modifyInformation.add(用户名框);
		用户名框.setColumns(10);
		
		JLabel 用户名 = new JLabel("用户名");
		用户名.setFont(new Font("黑体", Font.PLAIN, 18));
		用户名.setBounds(112, 117, 93, 21);
		modifyInformation.add(用户名);
		
		电话框 = new JTextField();
		电话框.setText(nowUser.getPhone());
		电话框.setFont(new Font("黑体", Font.PLAIN, 16));
		电话框.setColumns(10);
		电话框.setBounds(215, 147, 273, 22);
		modifyInformation.add(电话框);
		
		JLabel 电话 = new JLabel("电话");
		电话.setFont(new Font("黑体", Font.PLAIN, 18));
		电话.setBounds(112, 147, 93, 21);
		modifyInformation.add(电话);
		
		性别框 = new JTextField();
		性别框.setText(String.valueOf(nowUser.getSex().intValue()));
		性别框.setFont(new Font("黑体", Font.PLAIN, 16));
		性别框.setColumns(10);
		性别框.setBounds(215, 178, 273, 22);
		modifyInformation.add(性别框);
		
		JLabel 性别 = new JLabel("性别");
		性别.setFont(new Font("黑体", Font.PLAIN, 18));
		性别.setBounds(112, 178, 93, 21);
		modifyInformation.add(性别);
		
		生日框 = new JTextField();
		生日框.setText(DateUtil.format(nowUser.getBirthday(),"yyyy年MM月dd日"));
		生日框.setFont(new Font("黑体", Font.PLAIN, 16));
		生日框.setColumns(10);
		生日框.setBounds(215, 208, 273, 22);
		modifyInformation.add(生日框);
		
		JLabel 生日 = new JLabel("生日");
		生日.setFont(new Font("黑体", Font.PLAIN, 18));
		生日.setBounds(112, 208, 93, 21);
		modifyInformation.add(生日);
		
		职位框 = new JTextField();
		职位框.setEditable(false);
		职位框.setText(nowUser.getJob());
		职位框.setFont(new Font("黑体", Font.PLAIN, 16));
		职位框.setColumns(10);
		职位框.setBounds(215, 240, 273, 22);
		modifyInformation.add(职位框);
		
		JLabel 职位 = new JLabel("职位");
		职位.setFont(new Font("黑体", Font.PLAIN, 18));
		职位.setBounds(112, 240, 93, 21);
		modifyInformation.add(职位);
		
		入职时间框 = new JTextField();
		入职时间框.setEditable(false);
		入职时间框.setText(DateUtil.format(nowUser.getEntrytime(),"yyyy年MM月dd日"));
		入职时间框.setFont(new Font("黑体", Font.PLAIN, 16));
		入职时间框.setColumns(10);
		入职时间框.setBounds(215, 270, 273, 22);
		modifyInformation.add(入职时间框);
		
		JLabel 入职时间 = new JLabel("入职时间");
		入职时间.setFont(new Font("黑体", Font.PLAIN, 18));
		入职时间.setBounds(112, 270, 93, 21);
		modifyInformation.add(入职时间);
		
		状态框 = new JTextField();
		状态框.setEditable(false);
		状态框.setText(String.valueOf(nowUser.getState()));
		状态框.setFont(new Font("黑体", Font.PLAIN, 16));
		状态框.setColumns(10);
		状态框.setBounds(215, 301, 273, 22);
		modifyInformation.add(状态框);
		
		JLabel 状态 = new JLabel("状态");
		状态.setFont(new Font("黑体", Font.PLAIN, 18));
		状态.setBounds(112, 301, 93, 21);
		modifyInformation.add(状态);
		
		ID框 = new JTextField();
		ID框.setEditable(false);
		ID框.setText(nowUser.getId());
		ID框.setFont(new Font("黑体", Font.PLAIN, 16));
		ID框.setColumns(10);
		ID框.setBounds(290, 42, 273, 22);
		modifyInformation.add(ID框);
		
		JLabel ID = new JLabel("ID");
		ID.setFont(new Font("黑体", Font.PLAIN, 18));
		ID.setBounds(252, 44, 93, 21);
		modifyInformation.add(ID);
		
		JButton 查询btn = new JButton("查询btn");
		查询btn.setAction(search);
		查询btn.setBounds(570, 41, 93, 23);
		modifyInformation.add(查询btn);
		
		JLabel 状态提示 = new JLabel("状态提示： 0->注销  1->在职  2->管理员");
		状态提示.setFont(new Font("黑体", Font.PLAIN, 14));
		状态提示.setBounds(112, 336, 376, 21);
		modifyInformation.add(状态提示);
		
		JLabel 时间提示 = new JLabel("输入时间格式为：1970-01-01");
		时间提示.setFont(new Font("黑体", Font.PLAIN, 14));
		时间提示.setBounds(112, 369, 376, 21);
		modifyInformation.add(时间提示);
		
		JButton 提交修改btn = new JButton("提交修改");
		提交修改btn.setAction(action);
		提交修改btn.setFont(new Font("黑体", Font.PLAIN, 14));
		提交修改btn.setBounds(484, 474, 99, 34);
		modifyInformation.add(提交修改btn);



		if (user.getState()==2){
			职位框.setEditable(true);
			入职时间框.setEditable(true);
			状态框.setEditable(true);
			ID框.setEditable(true);
		}
	}
	private class Search extends AbstractAction {
		public Search() {
			putValue(NAME, "查询");
			putValue(SHORT_DESCRIPTION, "Search");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String searchId = ID框.getText();
			nowUser=userService.getById(searchId);

			System.out.println("当前User"+nowUser);

			updateUI();

			用户名框.setText(nowUser.getUsername());
			电话框.setText(nowUser.getPhone());
			性别框.setText(String.valueOf(nowUser.getSex().intValue()));
			生日框.setText(DateUtil.format(nowUser.getBirthday(),"yyyy年MM月dd日"));
			职位框.setText(nowUser.getJob());
			入职时间框.setText(DateUtil.format(nowUser.getEntrytime(),"yyyy年MM月dd日"));
			状态框.setText(String.valueOf(nowUser.getState()));
		}
	}
	private class Submit extends AbstractAction {
		public Submit() {
			putValue(NAME, "提交");
			putValue(SHORT_DESCRIPTION, "submit");

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			User sumbitUser = new User();
			sumbitUser.setId(ID框.getText());
			sumbitUser.setUsername(用户名框.getText());
			sumbitUser.setPassword(nowUser.getPassword());
			sumbitUser.setPhone(电话框.getText());
			sumbitUser.setSex(Double.valueOf(性别框.getText()));
			sumbitUser.setBirthday(DateUtil.parse(生日框.getText()));
			sumbitUser.setJob(职位框.getText());
			sumbitUser.setEntrytime(DateUtil.parse(入职时间框.getText()));
			sumbitUser.setState(Double.valueOf(状态框.getText()));

			System.out.println("sumbitUser--->"+sumbitUser);

			boolean isUpdate = userService.saveOrUpdate(sumbitUser);

			System.out.println("成功更新了吗？；"+isUpdate);

			JOptionPane.showMessageDialog(null, "是否成功："+isUpdate, "提示", JOptionPane.WARNING_MESSAGE);

		}
	}
}
