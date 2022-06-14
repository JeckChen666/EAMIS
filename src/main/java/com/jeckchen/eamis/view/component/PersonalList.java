package com.jeckchen.eamis.view.component;

import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.entity.Vo.AttendanceVo;
import com.jeckchen.eamis.service.AttendanceService;
import com.jeckchen.eamis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

@Scope("prototype")
@Component("PersonalList")
public class PersonalList extends JPanel {

	@Autowired
	private UserService userService;

	JTable table;
	JScrollPane pane;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PersonalList(UserService userService) {
		setBackground(new Color(241, 238, 233));
		setBounds(0, 0, 698, 571);
		setLayout(null);

		table=new JTable();
		table.setFont(new Font("黑体", Font.PLAIN, 12));

		pane=new JScrollPane(table);
		pane.setBounds(10, 44, 678, 453);
		add(pane);

		JLabel stateTip = new JLabel("状态提示：0->提早 1->正常 2->迟到");
		stateTip.setFont(new Font("黑体", Font.PLAIN, 14));
		stateTip.setBounds(10, 10, 678, 27);
		add(stateTip);


		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
//				super.componentShown(e);
				showTable(e);
			}
		});

	}

	protected void showTable(ComponentEvent e)
	{
		User user = (User) Session.getSession().get(SessionType.USER.toString());
		List<User> list = userService.list(null);


		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();    //获得表格模型
		tableModel.setRowCount(0);    //清空表格中的数据
		tableModel.setColumnIdentifiers(new Object[]{"id","username","phone","sex","birthday","job","entrytime","state"});    //设置表头

		for (User v :list) {
			tableModel.addRow(new Object[]{
					v.getId(),
					v.getUsername(),
					v.getPhone(),
					v.getSex(),
					DateUtil.format(v.getBirthday(),"yyyy年MM月dd日 HH:mm"),
					v.getJob(),
					DateUtil.format(v.getEntrytime(),"yyyy年MM月dd日 HH:mm"),
					v.getState()});
		}

//		tableModel.addRow(new Object[]{"Java从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","59.8元"});    //增加列
//		tableModel.addRow(new Object[]{"PHP从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","69.8元"});
//		tableModel.addRow(new Object[]{"Visual Basic从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","69.8元"});
//		tableModel.addRow(new Object[]{"Visual C++从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","69.8元" });
		table.setRowHeight(30);
		table.setModel(tableModel);    //应用表格模型
	}

}
