package com.jeckchen.eamis.view.component;

import cn.hutool.core.date.DateUtil;
import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.entity.Vo.VacateVo;
import com.jeckchen.eamis.entity.Vo.WorkOvertimeVo;
import com.jeckchen.eamis.service.WorkOvertimeService;
import com.jeckchen.eamis.view.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

@Scope("prototype")
@Component("WorkOvertimeList")
public class WorkOvertimeList extends JPanel {

	@Autowired
	private WorkOvertimeService workOvertimeService;

	JTable table;
	JScrollPane pane;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public WorkOvertimeList(WorkOvertimeService workOvertimeService) {
		setBackground(new Color(241, 238, 233));
		setBounds(0, 0, 698, 571);
		setLayout(null);

		table=new JTable();
		table.setFont(new Font("黑体", Font.PLAIN, 12));

		pane=new JScrollPane(table);
		pane.setBounds(10, 44, 678, 453);
		add(pane);
		
		JLabel stateTip = new JLabel("状态提示：0->删除 1->进行中  2->结束");
		stateTip.setFont(new Font("黑体", Font.PLAIN, 14));
		stateTip.setBounds(10, 10, 678, 27);
		add(stateTip);
		
		JButton deleteBtn = new JButton("delete");
		Action deleteAction = new DeleteAction();
		deleteBtn.setAction(deleteAction);
		deleteBtn.setFont(new Font("黑体", Font.PLAIN, 16));
		deleteBtn.setBounds(595, 507, 93, 23);
		add(deleteBtn);
		
		JButton endBtn = new JButton("end");
		Action endAction = new endAction();
		endBtn.setAction(endAction);
		endBtn.setFont(new Font("黑体", Font.PLAIN, 16));
		endBtn.setBounds(478, 507, 93, 23);
		add(endBtn);
		
		JButton startBtn = new JButton("start");
		Action startAction = new StartAction();
		startBtn.setAction(startAction);
		startBtn.setFont(new Font("黑体", Font.PLAIN, 16));
		startBtn.setBounds(375, 507, 93, 23);
		add(startBtn);
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 14));
		textField.setBounds(10, 507, 355, 27);
		add(textField);
		textField.setColumns(10);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
//				super.componentShown(e);
				showTable(e);
			}
		});

	}
	protected void showTable(ComponentEvent e) {
		User user = (User) Session.getSession().get(SessionType.USER.toString());

		List<WorkOvertimeVo> workOvertimeList = workOvertimeService.getWorkOvertimeList(user.getId());

		System.out.println(workOvertimeList);

		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();    //获得表格模型
		tableModel.setRowCount(0);    //清空表格中的数据
		tableModel.setColumnIdentifiers(new Object[]{"id","username","reason","start_time","end_time","state"});    //设置表头

		for (WorkOvertimeVo v :workOvertimeList) {
			tableModel.addRow(new Object[]{
					v.getId(),
					v.getUsername(),
					v.getReason(),
					DateUtil.format(v.getStartTime(),"yyyy年MM月dd日 HH:mm"),
					DateUtil.format(v.getEndTime(),"yyyy年MM月dd日 HH:mm"),
					v.getState()});
		}

//		tableModel.addRow(new Object[]{"Java从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","59.8元"});    //增加列
//		tableModel.addRow(new Object[]{"PHP从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","69.8元"});
//		tableModel.addRow(new Object[]{"Visual Basic从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","69.8元"});
//		tableModel.addRow(new Object[]{"Visual C++从入门到精通（第2版）","清华大学出版社","2010-07-01","软件工程师入门丛书","69.8元" });
		table.setRowHeight(30);
		table.setModel(tableModel);    //应用表格模型
	}

	private class DeleteAction extends AbstractAction {
		public DeleteAction() {
			putValue(NAME, "Delete");
			putValue(SHORT_DESCRIPTION, "delete");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = textField.getText();
			Boolean isDelete = workOvertimeService.logicalRemove(id);
			JOptionPane.showMessageDialog(null, "是否成功："+isDelete, "提示", JOptionPane.WARNING_MESSAGE);

			((Home) SpringContextUtils.getBean("Home")).setVisible(true);
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
	private class endAction extends AbstractAction {
		public endAction() {
			putValue(NAME, "End");
			putValue(SHORT_DESCRIPTION, "end");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = textField.getText();
			Boolean isEnd = workOvertimeService.logicalEnd(id);
			JOptionPane.showMessageDialog(null, "是否成功："+isEnd, "提示", JOptionPane.WARNING_MESSAGE);

			((Home) SpringContextUtils.getBean("Home")).setVisible(true);
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}

	private class StartAction extends AbstractAction {
		public StartAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "start");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = textField.getText();
			Boolean isStart = workOvertimeService.logicalStart(id);
			JOptionPane.showMessageDialog(null, "是否成功："+isStart, "提示", JOptionPane.WARNING_MESSAGE);

			((Home) SpringContextUtils.getBean("Home")).setVisible(true);
			JComponent comp = (JComponent) e.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}
	}
}
