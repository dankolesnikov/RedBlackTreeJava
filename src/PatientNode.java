import java.awt.*;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW2 Fall 2017
 * Professor: Dr. Mike Wu
 */
public class PatientNode {
    int key;
    Patient patient;
    PatientNode p, left, right;
    Color color;

    PatientNode(){
        color = Color.BLACK;
        p = null;
        left = null;
        right = null;
    }


    public PatientNode(int key, Color color, Patient patient) {
        this.patient = patient;
        this.key = key;
        this.color = color;
        p = null;
        left = null;
        right = null;
    }

    /** Getters */
    public int getKey(){
        return key;
    }
    public Patient getData(){
        return patient;
    }

    public PatientNode getLeft(){
        return left;
    }

    public PatientNode getRight(){
        return right;
    }

    public PatientNode getParent(){
        return p;
    }

    public String getColor() {
        if(color == Color.RED){
            return "RED";
        }
        else{
            return "BLACK";
        }
    }

    /** Setters */
    public void setLeft(PatientNode l){
        this.left = l;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setRight(PatientNode r){
        this.right = r;
    }
    public void setParent(PatientNode p){
        this.p = p;
    }



}
