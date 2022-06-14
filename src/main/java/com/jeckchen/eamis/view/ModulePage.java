package com.jeckchen.eamis.view;

import com.jeckchen.eamis.common.Session;
import com.jeckchen.eamis.common.SessionType;
import com.jeckchen.eamis.common.SpringContextUtils;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.service.UserService;
import com.jeckchen.eamis.view.component.ModuleBotton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@Scope("prototype")
@Component("ModulePage")
public class ModulePage extends JFrame {

    private JPanel contentPane;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ModulePage frame = new ModulePage();
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
    public ModulePage() {
        setTitle("EAMIS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(712, 640));
        setBounds(100, 100, 585, 510);


        if (Session.getSession().get(SessionType.MODULE.toString()) == "PersonalMessage") {
            contentPane = (JPanel) SpringContextUtils.getBean("PersonalMessageIndex");
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(null);
            contentPane.setBackground(new Color(115, 119, 123));
            setContentPane(contentPane);
        }

        if (Session.getSession().get(SessionType.MODULE.toString()) == "AttendanceModule"){
            contentPane = (JPanel) SpringContextUtils.getBean("AttendanceModuleIndex");
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(null);
            contentPane.setBackground(new Color(115, 119, 123));
            setContentPane(contentPane);
        }

        if (Session.getSession().get(SessionType.MODULE.toString()) == "VacateModule"){
            contentPane = (JPanel) SpringContextUtils.getBean("VacateModuleIndex");
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(null);
            contentPane.setBackground(new Color(115, 119, 123));
            setContentPane(contentPane);
        }

        if (Session.getSession().get(SessionType.MODULE.toString()) == "WorkOvertimeModule"){
            contentPane = (JPanel) SpringContextUtils.getBean("WorkOvertimeModuleIndex");
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(null);
            contentPane.setBackground(new Color(115, 119, 123));
            setContentPane(contentPane);
        }

        if (Session.getSession().get(SessionType.MODULE.toString()) == "BusinessTripModule"){
            contentPane = (JPanel) SpringContextUtils.getBean("BusinessTripModuleIndex");
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(null);
            contentPane.setBackground(new Color(115, 119, 123));
            setContentPane(contentPane);
        }

        JPanel moduleBotton = new ModuleBotton();
        moduleBotton.setLayout(null);
//		moduleBotton.setBackground(Color.BLUE);
        moduleBotton.setBounds(0, 571, 698, 32);
        contentPane.add(moduleBotton);

//		JPanel moduleContent = new PersonalMessageIndex();
//		moduleContent.setLayout(null);
//		moduleContent.setBackground(Color.GRAY);
//		moduleContent.setBounds(0, 0, 698, 571);
//		contentPane.add(moduleContent);

//		JPanel moduleContent = new JPanel();
//		moduleContent.setLayout(null);
//		moduleContent.setBackground(Color.GRAY);
//		moduleContent.setBounds(0, 0, 698, 571);
//		contentPane.add(moduleContent);
//
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setSize(698, 571);
//		moduleContent.add(tabbedPane);
//
//		JPanel panel = new JPanel();
//		tabbedPane.addTab("New tab", null, panel, null);
    }
}
