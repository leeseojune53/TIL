public class Course {
    public static final int CREDIT_MAJOR = 3;
    public static final int CREDIT_GENERAL = 2;
    public String Classname;
    public int Credit;
    public String grade;

    public Course(String Classname, int Credit, String grade){
        this.Classname = Classname;
        this.Credit = Credit;
        this.grade = grade;
        GradeCalculator.count++;
    }
}
