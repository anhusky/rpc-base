package com.gupao.vip.michael.clone;

import java.io.IOException;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class CloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        teacher.setName("mic");

        Student student = new Student();
        student.setName("沐风");
        student.setAge(35);
        student.setTeacher(teacher);

        // 浅克隆


        // 深度克隆一个对象
        Student student2 = (Student) student.deepClone();
        System.out.println(student);

        //student2.getTeacher().setName("james");
        System.out.println(student2.getTeacher() == teacher);


    }
}
