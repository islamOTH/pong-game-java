/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.livedata;

import controller.PlayController;

/**
 *
 * @author Islam
 */
public class Score {
    private int score;
  private static Score s = new Score.Builder().Score(0).build();
  public static Score getInstence(){return s;}
public static class Builder{
    int score=0;

        public Builder() {
        }
    
    public Builder Score(int score)
    { this.score=score;
        return this;
    }
    public Score build()
    {
        return new Score(this);
    }
    
}
    public Score(Score.Builder b) {
   this.score=b.score;
   ScoreSubscriberOne scoreSubscriberOne=new ScoreSubscriberOne();
        PlayController.scorePublisher.attach(scoreSubscriberOne);
        
    }

  
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
