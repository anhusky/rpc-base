package com.gupao.vip.michael;

import java.io.*;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class SerializeDemo {

    public static void main(String[] args) {
        // 序列化操作
        SerializePerson();

        Person.height = 11;
        //反序列化操作
        Person person = DeSerializePerson();

        System.out.println("【反序列化后数据】" + person);
    }

    /**
     * 序列化
     */
    private static void SerializePerson() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = getPerson();
            System.out.println("【原始数据】" + person);

            oo.writeObject(person);
            oo.flush();
            System.out.println("【序列化成功】大小: " + new File("person").length());

           /* ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person1 = (Person) ois.readObject();
            person.setName("mic1");
            oo.writeObject(person);
            oo.flush();

            System.out.println("【序列化成功】大小: " + new File("person").length());
            Person person2 = (Person) ois.readObject();
            System.out.println(person1 + "->" + person2);*/

            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Person getPerson() {
        Person person = new Person();
        person.setAge(18);
        person.setName("mic");
        person.setDesc("描述信息");
        return person;
    }

    /**
     * 反序列化
     */
    private static Person DeSerializePerson() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person = (Person) ois.readObject();
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
