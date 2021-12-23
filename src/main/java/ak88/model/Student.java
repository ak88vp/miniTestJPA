package ak88.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int score;
    private String img;

    @ManyToOne
    private Classzz classzz;

    public Classzz getClasszz() {
        return classzz;
    }

    public void setClasszz(Classzz classzz) {
        this.classzz = classzz;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Student(String name, int age, int score, String img, Classzz classzz) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.img = img;
        this.classzz = classzz;
    }

    public Student(String name, int age, int score, Classzz classzz, Classzz classzz1) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.classzz = classzz;
        this.classzz = classzz1;
    }

    public Student(Long id, String name, int age, int score, Classzz classzz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.classzz = classzz;
    }

    public Student(String name, int age, int score, Classzz classzz) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.classzz = classzz;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Student() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
