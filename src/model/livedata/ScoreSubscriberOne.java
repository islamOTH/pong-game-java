package model.livedata;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Islam
 */
public class ScoreSubscriberOne implements Observer 
{
    @Override
    public void update(Score m) {
        Score.getInstence().setScore(m.getScore());
        
    }
}
