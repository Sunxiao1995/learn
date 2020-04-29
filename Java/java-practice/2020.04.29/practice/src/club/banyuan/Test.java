package club.banyuan;
public class Test {
    public static void main(String[] args) {
        Pupil a = new Pupil("小学生");
        MiddleSchoolStudents b = new MiddleSchoolStudents("初中生");
        HighSchoolStudents c = new HighSchoolStudents("高中生");
        a.learn();
        b.learn();
        c.learn();

    }
}