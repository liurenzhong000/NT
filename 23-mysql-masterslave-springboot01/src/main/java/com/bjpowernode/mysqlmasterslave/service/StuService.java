package com.bjpowernode.mysqlmasterslave.service;


import com.bjpowernode.mysqlmasterslave.master.mapper.MasterStuMapper;
import com.bjpowernode.mysqlmasterslave.model.Stu;
import com.bjpowernode.mysqlmasterslave.slave.mapper.SlaveStuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:StuService
 * Package:com.bjpowernode.masterslave.service
 * Description:
 *
 * @date:2018/10/20 9:22
 * @author:bjpowernode.com
 */
@Service("stuService")
public class StuService {
    @Autowired
    private MasterStuMapper masterStuMapper;
    @Autowired
    private SlaveStuMapper slaveStuMapper;
    public void addStu(){
        Stu stu=new Stu();
        stu.setName("赵六");
        masterStuMapper.insert(stu);
    }

    public void select(){

       List<Stu> list= slaveStuMapper.selectAll();
       list.forEach(stu-> System.out.println("id="+stu.getId()+"    name="+stu.getName()));
    }
}
