package ku.cs.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList list;
    @BeforeEach
    void init(){
        list = new StudentList();
        list.addNewStudent("6xxxxxxxx0", "John", 70);
        list.addNewStudent("6xxxxxxxx1", "Harry", 60);
        list.addNewStudent("6xxxxxxxx2", "Navy", 90);
    }
    @Test
    @DisplayName("Test the adding student method without score given ")

    void testAddNewStudent(){
        list.addNewStudent("6xxxxxxxx3","Winston");
        assertEquals("Winston", list.findStudentById("6xxxxxxxx3").getName());
    }
    @Test
    @DisplayName("Test the adding student method with score given ")
    void testAddNewStudentWithScore(){
        list.addNewStudent("6xxxxxxxx3","Winston",50);
        assertEquals(50, list.findStudentById("6xxxxxxxx3").getScore());
    }

    @Test
    void testFilterByName(){
        list.addNewStudent("6xxxxxxxx4","Harry");
        StudentList students = list.filterByName("Harry");
        boolean check = true;
        int count = 0;
        for(Student student: students.getStudents()){
            if(!student.isNameContains("Harry")){
                check = false;
                break;
            }
            count++;
        }
        boolean result  = (count==2)&&check;
        assertEquals(true,result);

    }
    @Test
    void testGiveScoreToId(){
        list.giveScoreToId("6xxxxxxxx0",55.15);
        assertEquals(55.15+70, list.findStudentById("6xxxxxxxx0").getScore());

    }
    @Test
    void testViewGradeOfId(){
        list.viewGradeOfId("6xxxxxxxx2");
        assertEquals("A", list.findStudentById("6xxxxxxxx2").getGrade());

    }
}