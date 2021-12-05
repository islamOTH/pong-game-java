/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.livedata;

import java.awt.List;
import java.util.ArrayList;
import model.livedata.Subject;

/**
 *
 * @author Islam
 */
public class ScorePublisher implements Subject{
     private ArrayList<Observer> observers = new ArrayList<>();
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
 
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
 
    @Override
    public void notifyUpdate(Score m) {
        
        for(Observer o: observers) {
            o.update(m);
        }
    }
}
