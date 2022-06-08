package com.jeckchen.eamis;

import cn.hutool.core.util.RandomUtil;
import com.jeckchen.eamis.entity.BusinessTrip;
import com.jeckchen.eamis.entity.User;
import com.jeckchen.eamis.entity.Vacate;
import com.jeckchen.eamis.entity.WorkOvertime;
import com.jeckchen.eamis.mapper.BusinessTripMapper;
import com.jeckchen.eamis.mapper.UserMapper;
import com.jeckchen.eamis.mapper.VacateMapper;
import com.jeckchen.eamis.mapper.WorkOvertimeMapper;
import com.jeckchen.eamis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chenj
 * @version 1.0.0
 * @className ConnectTest.java
 * @description jc
 * @date 2022年05月18日 20:21
 */
@SpringBootTest
public class ConnectTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BusinessTripMapper businessTripMapper;

    @Autowired
    private VacateMapper vacateMapper;

    @Autowired
    private WorkOvertimeMapper workOvertimeMapper;

    @Test
    public void testLogin(){
        User user = userMapper.getUserByPhone("123");
        System.out.println(user);
    }

    @Test
    public void findAll(){
        List<User> list = userService.list(null);
        System.out.println(list);
    }

    @Test
    public void updateTripEndTime(){
        List<BusinessTrip> businessTrips = businessTripMapper.selectList(null);
        int sum=0;

        for (BusinessTrip bt:businessTrips) {
            String id = bt.getId();
            Integer num = businessTripMapper.updateEndTime(id);
            sum+=num;
        }

        System.out.println(sum);
    }

    @Test
    public void updateVacateEndTime(){
        List<Vacate> vacateList = vacateMapper.selectList(null);
        int sum=0;

        for (Vacate v:vacateList) {
            String id = v.getId();
            Integer num = vacateMapper.updateEndTime(id);
            sum+=num;
        }

        System.out.println(sum);
    }

    @Test
    public void updateWorkOverTimeEndTime(){
        List<WorkOvertime> workOvertimeList = workOvertimeMapper.selectList(null);
        int sum=0;

        for (WorkOvertime w:workOvertimeList) {
            String id = w.getId();
            Integer num = workOvertimeMapper.updateEndTime(id);
            sum+=num;
        }

        System.out.println(sum);
    }

    @Test
    public void updateTripState(){
        List<BusinessTrip> businessTrips = businessTripMapper.selectList(null);
        int sum=0;

        ArrayList<String> list= new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add("3");
        }
        list.add("0");

        for (BusinessTrip bt:businessTrips) {
            String id = bt.getId();
            String state = RandomUtil.randomEle(list);
            Integer num = businessTripMapper.updateState(id,state);
            sum+=num;
        }

        System.out.println(sum);
    }
}
