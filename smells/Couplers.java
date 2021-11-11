package smells;

import java.util.List;

public class Couplers {
    /**
     * MESSAGE CHAINS
     * Refactor: hide delegate or method moving
     */

    String temp = new Person().getCourse().getSubject();
    String temp2 = new Person().getCourseSubject();     //hide delegate

    /**
     * MIDDLE MAN: Instances of laziness
     * Refactor: Remove method
     */
    public class Student {
        List<Course> enrolledCourses;
        Specialisation enrolledSpecialisation;
    
        public Person getProgrammeDirector() {
            return enrolledSpecialisation.getProgrammeDirector();
        }    
    }

    /**
     * FEATURE ENVY (One envies) + INAPPROPRIATE INTIMACY (Dual): "Interwoven method calling"
     * Refactor: Move (entire) OR extract (portion) method
     */


    /**
     * Remove compilation errors
     */
    class Specialisation {
        public Person getProgrammeDirector(){
            return new Person();
        }
    }

    class Person {
        Course course = new Course();

        Course getCourse(){
            return course;
        }

        String getCourseSubject(){
            return course.getSubject();
        }
    }

    class Course {
        String getSubject(){
            return "Yeet";
        }
    }
}



