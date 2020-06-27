package Model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private boolean sex;
    private String age;
    private double study;
    private double rest;
    private double character;
    private double family;
    private double score = 0;
    private String num = "00000";
    public static List<Student> student = new ArrayList<>();

    public Student() {
    }

	public static void setStudent(List<Student> student) {
		Student.student = student;
	}

	public Student(String id, String name, boolean sex, String age, double study, double rest, double character, double family) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.study = study;
        this.rest = rest;
        this.character = character;
        this.family = family;

    }
	
    public String getId() {

        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean getSex() {

        return this.sex;
    }

    public void setSex(boolean sex) {

        this.sex = sex;
    }

    public String getAge() {

        return this.age;
    }

    public void setAge(String age) {

        this.age = age;
    }

    public double getStudy() {

        return this.study;
    }

    public void setStudy(double study) {

        this.study = study;
    }

    public double getRest() {

        return this.rest;
    }

    public void setRest(double rest) {

        this.rest = rest;
    }

    public double getCharacter() {

        return this.character;
    }

    public void setCharacter(double character) {

        this.character = character;
    }

    public double getFamily() {

        return this.family;
    }

    public void setFamily(double family) {

        this.family = family;
    }

    public double getScore() {
        this.score = Double.valueOf(String.format("%.3f", this.study * 0.30 + this.rest * 0.30 + this.character * 0.20 + this.family * 0.20));
        return this.score;
    }

    public boolean isSex() {
        return sex;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}

