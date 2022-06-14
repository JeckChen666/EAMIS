package com.jeckchen.eamis.view;

import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

@Scope("prototype")
@Component("Home")
public class Home extends JFrame {

    private JPanel contentPane;
    private final Action personalMessageModuleAaction = new PersonalMessageModuleAaction();
    private final Action attendanceModuleAaction = new AttendanceModuleAaction();
    private final Action vacateModuleAaction = new VacateModuleAaction();
    private final Action workOvertimeModuleAaction = new WorkOvertimeModuleAaction();
    private final Action businessTripModuleAaction = new BusinessTripModuleAaction();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Home frame = new Home();
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
    public Home() {
        setTitle("EAMIS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(712, 640));
        setBounds(100, 100, 585, 510);


        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String usernameStr="error";
        String userJobStr="error";
        {
            User user = (User) Session.getSession().get(SessionType.USER.toString());
            usernameStr = "欢迎：" + user.getUsername();
            userJobStr = "您的职位是：" + user.getJob();
        }

        JLabel userMessage = new JLabel(usernameStr);
        userMessage.setFont(new Font("黑体", Font.PLAIN, 24));
        userMessage.setBounds(10, 10, 311, 46);
        contentPane.add(userMessage);

        JLabel userJob = new JLabel(userJobStr);
        userJob.setFont(new Font("黑体", Font.PLAIN, 24));
        userJob.setBounds(10, 66, 311, 46);
        contentPane.add(userJob);

        JButton personalMessageModuleBtn = new JButton("用户信息模块");
        personalMessageModuleBtn.setAction(personalMessageModuleAaction);
        personalMessageModuleBtn.setFont(new Font("黑体", Font.PLAIN, 22));
        personalMessageModuleBtn.setBounds(185, 216, 300, 54);
        contentPane.add(personalMessageModuleBtn);

        JButton attendanceModuleBtn = new JButton("考勤模块");
        attendanceModuleBtn.setAction(attendanceModuleAaction);
        attendanceModuleBtn.setFont(new Font("黑体", Font.PLAIN, 22));
        attendanceModuleBtn.setBounds(185, 297, 300, 54);
        contentPane.add(attendanceModuleBtn);

        JButton vacateModuleBtn = new JButton("请销假模块");
        vacateModuleBtn.setAction(vacateModuleAaction);
        vacateModuleBtn.setFont(new Font("黑体", Font.PLAIN, 22));
        vacateModuleBtn.setBounds(185, 373, 300, 54);
        contentPane.add(vacateModuleBtn);

        JButton workOvertimeModuleBtn = new JButton("加班模块");
        workOvertimeModuleBtn.setAction(workOvertimeModuleAaction);
        workOvertimeModuleBtn.setFont(new Font("黑体", Font.PLAIN, 22));
        workOvertimeModuleBtn.setBounds(185, 448, 300, 54);
        contentPane.add(workOvertimeModuleBtn);

        JButton businessTripModuleBtn = new JButton("出差模块");
        businessTripModuleBtn.setAction(businessTripModuleAaction);
        businessTripModuleBtn.setFont(new Font("黑体", Font.PLAIN, 22));
        businessTripModuleBtn.setBounds(185, 519, 300, 54);
        contentPane.add(businessTripModuleBtn);
    }


    private class PersonalMessageModuleAaction extends AbstractAction {
        public PersonalMessageModuleAaction() {
            putValue(NAME, "用户信息模块");
            putValue(SHORT_DESCRIPTION, "点击进入 用户信息模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// 登陆成功，本窗口隐藏
            //打开ModulePage窗口
            Session.getSession().put(SessionType.MODULE.toString(),"PersonalMessage");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //销毁窗口
            dispose();
        }
    }
    private class AttendanceModuleAaction extends AbstractAction {
        public AttendanceModuleAaction() {
            putValue(NAME, "考勤模块");
            putValue(SHORT_DESCRIPTION, "点击进入 考勤模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// 登陆成功，本窗口隐藏
            //打开ModulePage窗口
            Session.getSession().put(SessionType.MODULE.toString(),"AttendanceModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //销毁窗口
            dispose();
        }
    }
    private class VacateModuleAaction extends AbstractAction {
        public VacateModuleAaction() {
            putValue(NAME, "请销假模块");
            putValue(SHORT_DESCRIPTION, "点击进入 请销假模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// 登陆成功，本窗口隐藏
            //打开ModulePage窗口
            Session.getSession().put(SessionType.MODULE.toString(),"VacateModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //销毁窗口
            dispose();
        }
    }
    private class WorkOvertimeModuleAaction extends AbstractAction {
        public WorkOvertimeModuleAaction() {
            putValue(NAME, "加班模块");
            putValue(SHORT_DESCRIPTION, "点击进入 加班模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// 登陆成功，本窗口隐藏
            //打开ModulePage窗口
            Session.getSession().put(SessionType.MODULE.toString(),"WorkOvertimeModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //销毁窗口
            dispose();
        }
    }
    private class BusinessTripModuleAaction extends AbstractAction {
        public BusinessTripModuleAaction() {
            putValue(NAME, "出差模块");
            putValue(SHORT_DESCRIPTION, "点击进入 出差模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// 登陆成功，本窗口隐藏
            //打开ModulePage窗口
            Session.getSession().put(SessionType.MODULE.toString(),"BusinessTripModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //销毁窗口
            dispose();
        }
    }
}
