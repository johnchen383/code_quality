package smells;

import java.util.List;

public class Couplers {
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
     * Remove compilation errors
     */
    class Specialisation {
        public Person getProgrammeDirector(){
            return new Person();
        }
    }

    class Person {

    }

    class Course {
    
    }
}



