import po.CollegeStudent;
import po.StudentPo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String []ags){
        Date datenow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MMdd");
        System.out.println(ft.format(datenow));
    }

}
