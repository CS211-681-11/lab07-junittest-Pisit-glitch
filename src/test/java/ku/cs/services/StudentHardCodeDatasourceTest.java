package ku.cs.services;
import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    StudentList students;
    @BeforeEach
    void setUp() {
        students = new StudentHardCodeDatasource().readData();
    }
    @Test
    void testNumberOfStudents() {
        int count =0;
        for(Student student : students.getStudents()) {
            count++;

        }
        assertEquals(4, count);
    }
    @Test
    void testNamePrecision(){

        boolean check = true;
        for(Student student : students.getStudents()) {
            if(student.isNameContains("First")) continue;
            else if(student.isNameContains("Second")) continue;
            else if(student.isNameContains("Third")) continue;
            else if(student.isNameContains("Fourth")) continue;
            check = false;
            break;

        }
        assertEquals(true, check);
    }
    @Test
    void testIdPrecision(){

        boolean check = true;
        for(Student student : students.getStudents()) {
            if(student.isId("6710400001")) continue;
            else if(student.isId("6710400002")) continue;
            else if(student.isId("6710400003")) continue;
            else if(student.isId("6710400004")) continue;
            check = false;
            break;

        }
        assertEquals(true, check);
    }

}