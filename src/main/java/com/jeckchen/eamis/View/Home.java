package com.jeckchen.eamis.View;

import com.jeckchen.eamis.common.Session;
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

        User user = (User) Session.getSession().get("user");
        String usernameStr = "欢迎：" + user.getUsername();
        String userJobStr = "您的职位是：" + user.getJob();

        JLabel userMessage = new JLabel(usernameStr);
        userMessage.setFont(new Font("黑体", Font.PLAIN, 24));
        userMessage.setBounds(10, 10, 311, 46);
        contentPane.add(userMessage);

        JLabel userJob = new JLabel(userJobStr);
        userJob.setFont(new Font("黑体", Font.PLAIN, 24));
        userJob.setBounds(10, 66, 311, 46);
        contentPane.add(userJob);
        
        JButton personalMessageModule = new JButton("用户信息模块");
        personalMessageModule.setAction(personalMessageModuleAaction);
        personalMessageModule.setFont(new Font("黑体", Font.PLAIN, 22));
        personalMessageModule.setBounds(185, 216, 300, 54);
        contentPane.add(personalMessageModule);
        
        JButton attendanceModule = new JButton("考勤模块");
        attendanceModule.setAction(attendanceModuleAaction);
        attendanceModule.setFont(new Font("黑体", Font.PLAIN, 22));
        attendanceModule.setBounds(185, 297, 300, 54);
        contentPane.add(attendanceModule);
        
        JButton vacateModule = new JButton("请销假模块");
        vacateModule.setAction(vacateModuleAaction);
        vacateModule.setFont(new Font("黑体", Font.PLAIN, 22));
        vacateModule.setBounds(185, 373, 300, 54);
        contentPane.add(vacateModule);
        
        JButton workOvertimeModule = new JButton("加班模块");
        workOvertimeModule.setAction(workOvertimeModuleAaction);
        workOvertimeModule.setFont(new Font("黑体", Font.PLAIN, 22));
        workOvertimeModule.setBounds(185, 448, 300, 54);
        contentPane.add(workOvertimeModule);
        
        JButton businessTripModule = new JButton("出差模块");
        businessTripModule.setAction(businessTripModuleAaction);
        businessTripModule.setFont(new Font("黑体", Font.PLAIN, 22));
        businessTripModule.setBounds(185, 519, 300, 54);
        contentPane.add(businessTripModule);
    }


    private class PersonalMessageModuleAaction extends AbstractAction {
        public PersonalMessageModuleAaction() {
            putValue(NAME, "用户信息模块");
            putValue(SHORT_DESCRIPTION, "点击进入 用户信息模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    private class AttendanceModuleAaction extends AbstractAction {
        public AttendanceModuleAaction() {
            putValue(NAME, "考勤模块");
            putValue(SHORT_DESCRIPTION, "点击进入 考勤模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    private class VacateModuleAaction extends AbstractAction {
        public VacateModuleAaction() {
            putValue(NAME, "请销假模块");
            putValue(SHORT_DESCRIPTION, "点击进入 请销假模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    private class WorkOvertimeModuleAaction extends AbstractAction {
        public WorkOvertimeModuleAaction() {
            putValue(NAME, "加班模块");
            putValue(SHORT_DESCRIPTION, "点击进入 加班模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    private class BusinessTripModuleAaction extends AbstractAction {
        public BusinessTripModuleAaction() {
            putValue(NAME, "出差模块");
            putValue(SHORT_DESCRIPTION, "点击进入 出差模块");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}
