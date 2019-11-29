package com.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.Course;
import com.entity.Student;

/**
 * @author wentianlou
 * @date 2019/11/27 20:06
 **/
public class JsonUtil {

    public static void main(String[] args) {
        Course course = new Course();
        course.setCourseId(1);
        course.setTeacherId(1);
        course.setCourseName("武术课");

        Student student = new Student();
        student.setUserId(1);
        student.setUserName("a");
        student.setAge(20);
        student.setAddress("中国广东广州天河88号");
        student.setCourse(JSON.toJSONString(course));

        System.out.println(JSON.toJSONString(student));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId",student.getUserId());
        jsonObject.put("userName",student.getUserName());
        jsonObject.put("age",student.getAge());
        jsonObject.put("address",student.getAddress());
        jsonObject.put("course",student.getCourse());

        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONString());
    }
}
