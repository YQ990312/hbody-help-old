import po.CollegeStudent;
import po.StudentPo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String []ags){
        List<StudentPo> studentPoList=new ArrayList<>();
        for(int i=0;i<10;i++){
            StudentPo studentPo=new StudentPo();
            studentPo.setName("Yangjiaqi"+i);
            studentPo.setAge(null);
            studentPoList.add(studentPo);
        }

        List<String> stringName=studentPoList.stream().map(StudentPo::getName).collect(Collectors.toList());
        List<String> stringAge=studentPoList.stream().map(StudentPo::getAge).collect(Collectors.toList());

        System.out.println("数据"+stringName+"  /n "+stringAge);
    }

}
