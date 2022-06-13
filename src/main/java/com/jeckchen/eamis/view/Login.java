package com.jeckchen.eamis.view;

import com.jeckchen.eamis.common.Result;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.Vo.LoginVo;
import com.jeckchen.eamis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class Login extends JFrame {

	@Autowired
	private UserService userService;

	private JPanel contentPane;
	private JPanel header;
	private JPanel operation;
	private JLabel bottom;
	private JTextField usernameFiled;
	private JPasswordField passwordField;
	private final Action loginAction = new LoginAction();
	private final Action resetAction = new ResetAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
//		setVisible(true);
//        setSize(585, 550);
		setTitle("EAMIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(712,640));
		setBounds(100, 100, 585, 510);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		header = new JPanel();
		header.setBackground(new Color(0,0,0,0));
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("EAMIS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lblNewLabel);
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 54));
		lblNewLabel.setBackground(Color.PINK);
		
		operation = new JPanel();
		operation.setBackground(new Color(0,0,0,0));
		contentPane.add(operation, BorderLayout.CENTER);
		operation.setLayout(null);
		
		usernameFiled = new JTextField();
		usernameFiled.setToolTipText("");
		usernameFiled.setColumns(10);
		usernameFiled.setBounds(142, 144, 393, 32);
		// 为了测试方便
		usernameFiled.setText("18120901111");
		operation.add(usernameFiled);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("等线", Font.PLAIN, 22));
		Username.setBounds(24, 149, 111, 26);
		operation.add(Username);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("等线", Font.PLAIN, 22));
		Password.setBounds(24, 215, 111, 26);
		operation.add(Password);
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.setAction(loginAction);
		LoginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		LoginBtn.setFont(new Font("等线", Font.PLAIN, 18));
		LoginBtn.setBounds(441, 262, 94, 23);
		operation.add(LoginBtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 209, 393, 32);
		// 为了测试方便
		passwordField.setText("123456");
		operation.add(passwordField);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.setAction(resetAction);
		resetBtn.setFont(new Font("等线", Font.PLAIN, 18));
		resetBtn.setBounds(334, 262, 94, 23);
		operation.add(resetBtn);
		
		bottom = new JLabel("职工考勤管理信息系统");
		bottom.setHorizontalAlignment(SwingConstants.RIGHT);
		bottom.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		bottom.setBackground(Color.PINK);
		contentPane.add(bottom, BorderLayout.SOUTH);
	}

	private class LoginAction extends AbstractAction {
		public LoginAction() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Press this button to log in");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//获取用户名和密码
			String username = usernameFiled.getText();
			String password = String.valueOf(passwordField.getPassword());
			if (!StringUtils.hasText(username)||!StringUtils.hasText(password)){
				JOptionPane.showMessageDialog(null, "请输入", "提示", JOptionPane.ERROR_MESSAGE);
				usernameFiled.setText("");
				passwordField.setText("");
				return;
			}
			LoginVo loginVo = null;

			loginVo = new LoginVo();
			loginVo.setPhone(username);
			loginVo.setPassword(password);
			Result loginResult = userService.login(loginVo);
			// 如果返回的是error，则弹窗
			if (!loginResult.getState()){
				String message = loginResult.getMessage();
				JOptionPane.showMessageDialog(null, message, "提示", JOptionPane.ERROR_MESSAGE);
			}else {
				setVisible(false);// 登陆成功，本窗口隐藏
				//打开home窗口
				((Home) SpringContextUtils.getBean("Home")).setVisible(true);
				//销毁窗口
				dispose();
			}
		}
	}
	private class ResetAction extends AbstractAction {
		public ResetAction() {
			putValue(NAME, "Reset");
			putValue(SHORT_DESCRIPTION, "Press this button to reset all field");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			usernameFiled.setText("");
			passwordField.setText("");
		}
	}
}
