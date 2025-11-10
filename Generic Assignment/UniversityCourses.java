import java.util.*;

abstract class CourseType {
    String code;
    CourseType(String c){ code=c; }
    public String toString(){ return code; }
}

class ExamCourse extends CourseType { ExamCourse(String c){ super(c); } }
class AssignmentCourse extends CourseType { AssignmentCourse(String c){ super(c); } }
class ResearchCourse extends CourseType { ResearchCourse(String c){ super(c); } }

class Course<T extends CourseType> {
    T type;
    String title;

    Course(T t, String title){ this.type=t; this.title=title; }

    public String toString(){ return title + " (" + type + ")"; }
}

public class UniversityCourses {
    public static void printAnyCourse(List<? extends CourseType> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Course<? extends CourseType>> list = List.of(
                new Course<>(new ExamCourse("CS101"), "Intro to CS"),
                new Course<>(new ResearchCourse("CS900"), "Machine Learning Research")
        );

        list.forEach(System.out::println);

        printAnyCourse(List.of(new ExamCourse("EX101"), new AssignmentCourse("AS202")));
    }
}
