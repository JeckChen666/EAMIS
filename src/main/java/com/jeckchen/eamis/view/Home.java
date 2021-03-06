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
            usernameStr = "?????????" + user.getUsername();
            userJobStr = "??????????????????" + user.getJob();
        }

        JLabel userMessage = new JLabel(usernameStr);
        userMessage.setFont(new Font("??????", Font.PLAIN, 24));
        userMessage.setBounds(10, 10, 311, 46);
        contentPane.add(userMessage);

        JLabel userJob = new JLabel(userJobStr);
        userJob.setFont(new Font("??????", Font.PLAIN, 24));
        userJob.setBounds(10, 66, 311, 46);
        contentPane.add(userJob);

        JButton personalMessageModuleBtn = new JButton("??????????????????");
        personalMessageModuleBtn.setAction(personalMessageModuleAaction);
        personalMessageModuleBtn.setFont(new Font("??????", Font.PLAIN, 22));
        personalMessageModuleBtn.setBounds(185, 216, 300, 54);
        contentPane.add(personalMessageModuleBtn);

        JButton attendanceModuleBtn = new JButton("????????????");
        attendanceModuleBtn.setAction(attendanceModuleAaction);
        attendanceModuleBtn.setFont(new Font("??????", Font.PLAIN, 22));
        attendanceModuleBtn.setBounds(185, 297, 300, 54);
        contentPane.add(attendanceModuleBtn);

        JButton vacateModuleBtn = new JButton("???????????????");
        vacateModuleBtn.setAction(vacateModuleAaction);
        vacateModuleBtn.setFont(new Font("??????", Font.PLAIN, 22));
        vacateModuleBtn.setBounds(185, 373, 300, 54);
        contentPane.add(vacateModuleBtn);

        JButton workOvertimeModuleBtn = new JButton("????????????");
        workOvertimeModuleBtn.setAction(workOvertimeModuleAaction);
        workOvertimeModuleBtn.setFont(new Font("??????", Font.PLAIN, 22));
        workOvertimeModuleBtn.setBounds(185, 448, 300, 54);
        contentPane.add(workOvertimeModuleBtn);

        JButton businessTripModuleBtn = new JButton("????????????");
        businessTripModuleBtn.setAction(businessTripModuleAaction);
        businessTripModuleBtn.setFont(new Font("??????", Font.PLAIN, 22));
        businessTripModuleBtn.setBounds(185, 519, 300, 54);
        contentPane.add(businessTripModuleBtn);
    }


    private class PersonalMessageModuleAaction extends AbstractAction {
        public PersonalMessageModuleAaction() {
            putValue(NAME, "??????????????????");
            putValue(SHORT_DESCRIPTION, "???????????? ??????????????????");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// ??????????????????????????????
            //??????ModulePage??????
            Session.getSession().put(SessionType.MODULE.toString(),"PersonalMessage");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //????????????
            dispose();
        }
    }
    private class AttendanceModuleAaction extends AbstractAction {
        public AttendanceModuleAaction() {
            putValue(NAME, "????????????");
            putValue(SHORT_DESCRIPTION, "???????????? ????????????");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// ??????????????????????????????
            //??????ModulePage??????
            Session.getSession().put(SessionType.MODULE.toString(),"AttendanceModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //????????????
            dispose();
        }
    }
    private class VacateModuleAaction extends AbstractAction {
        public VacateModuleAaction() {
            putValue(NAME, "???????????????");
            putValue(SHORT_DESCRIPTION, "???????????? ???????????????");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// ??????????????????????????????
            //??????ModulePage??????
            Session.getSession().put(SessionType.MODULE.toString(),"VacateModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //????????????
            dispose();
        }
    }
    private class WorkOvertimeModuleAaction extends AbstractAction {
        public WorkOvertimeModuleAaction() {
            putValue(NAME, "????????????");
            putValue(SHORT_DESCRIPTION, "???????????? ????????????");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// ??????????????????????????????
            //??????ModulePage??????
            Session.getSession().put(SessionType.MODULE.toString(),"WorkOvertimeModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //????????????
            dispose();
        }
    }
    private class BusinessTripModuleAaction extends AbstractAction {
        public BusinessTripModuleAaction() {
            putValue(NAME, "????????????");
            putValue(SHORT_DESCRIPTION, "???????????? ????????????");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);// ??????????????????????????????
            //??????ModulePage??????
            Session.getSession().put(SessionType.MODULE.toString(),"BusinessTripModule");
            ((ModulePage) SpringContextUtils.getBean("ModulePage")).setVisible(true);
            //????????????
            dispose();
        }
    }
}
