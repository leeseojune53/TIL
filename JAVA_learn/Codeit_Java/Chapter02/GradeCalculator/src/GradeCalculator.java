
public class GradeCalculator {
    private String name;
    private double Avggrade;
    private int Credit;
    public int curCredit = 0;
    public double curAvggrade = 0;
    public static int count = 0;

    public GradeCalculator(String name, double Avggrade, int Credit){
        this.name = name;
        this.Avggrade = Avggrade;
        this.Credit = Credit;
    }

    public void addCourse(Course course){
        curCredit+=course.Credit;
        curAvggrade+=score(course.grade)*course.Credit;
    }

    public double score(String grade){
        switch (grade){
            case "A+":
                return 4.5;
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            case "D+":
                return 1.5;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
        }
        return 0.0;
    }

    public void print(){
        curAvggrade/=curCredit;
        double result = (Avggrade * Credit + curAvggrade * curCredit)/(Credit+curCredit);
        System.out.println("직전 학기 성적: " + Avggrade + " (총 " + Credit + "학점)");
        System.out.println("이번 학기 성적: " + curAvggrade + " (총 " + curCredit + "학점)");
        System.out.println("전체 예상 학점: " + result + " (총 " + (Credit+curCredit) + "학점)");
    }
}
