/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StudentArr extends ArrayList<Student> {

    /**
     * Constructor
     */
    public StudentArr() {
        super();
    }

    /**
     * @category auxiliary method
     * @param id : String
     * @return true if id exists, false otherwise
     */
    public boolean deleteByID(String id) {
        for (Student student : this) {
            if (id.equals(student.getID())) {
                this.remove(this.indexOf(student));
                return true;
            }
        }
        return false;
    }

    /**
     * @category auxiliary method
     * @param id : String
     * @return Student, null if not found
     */
    public Student studentByID(String id) {
        for (Student student : this) {
            if (id.equals(student.getID())) {
                return student;
            }
        }
        return null;
    }

}
