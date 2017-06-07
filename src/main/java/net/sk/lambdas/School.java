package net.sk.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    private List<Student> students = new ArrayList<Student>(){{
        add(new Student("李雷","男"));
        add(new Student("韩梅梅","女"));
        add(new Student("Jim Green","男"));
        add(new Student("Lucy","女"));
        add(new Student("UncleWang","男"));
        add(new Student("Lily","女"));
    }};


    /**
     * 自定义filter接口
     * @param filter
     * @return
     */
    public List<Student> getPersonList(PersonFilter filter) {
        List<Student> studentList = new ArrayList<Student>();
        students.forEach((student) -> {
         if (filter.filter(student)) {//调用 PersonFilter 的方法
                studentList.add(student);
         }
         });
        return studentList;
    }

    public List<Student> getPersonList2(Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }

}