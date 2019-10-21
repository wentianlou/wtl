package com.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author wentianlou
 * Date 2019/10/21 14:31
 **/
public class StreamDemo {
    public static void main(String[] args) {
        //构造数据
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        //取Sex=“G”的Student，并打印出来
        System.out.println("...使用iterator方法");
        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()) {
            Student stu = iterator.next();
            if (stu.getSex().equals("G")) {

                System.out.println(stu.toString());
            }
        }

        System.out.println("...使用for方法");
        for (Student student:list) {
            if("G".equals(student.getSex())){
                System.out.println(student.toString());
            }
        }

        System.out.println("...使用聚合操作方法");
        list.stream()
                .filter(student -> "G".equals(student.getSex()))
                .forEach(student -> System.out.println(student.toString()));

    }
}
