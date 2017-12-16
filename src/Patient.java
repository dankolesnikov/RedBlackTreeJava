
/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW2 Fall 2017
 * Professor: Dr. Mike Wu
 */

public class Patient {
    private String name;
    private int priority;

    // Constructor
    Patient(int priority,String name){
        this.name = name;
        this.priority = priority;
    }

    // Getters
    public int getPriority(){
        return priority;
    }
    public void setPriority(int input)
    {
        this.priority=input;
    }
    public String getName(){
        return name;
    }

}