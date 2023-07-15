package com.example.sportsquo;

import com.example.sportsquo.MainActivity;

public class Athlete {
    int id;
    String name;
    int age;
    int height;
    int weight;
    String Matches_played;
    String Matches_Won;
    String Best_Rating;
    String titles;
    public Athlete(){   }
    public Athlete(int id, String name,int age, int height,int weight,String Matches_played,String Matches_Won,String Best_Rating,String title
    ){
        this.id = id;
        this.name = name;
        this.age=age;
        this.height=height;
        this.weight=weight;
        this.Matches_played=Matches_played;
        this.Matches_Won=Matches_Won;
        this.Best_Rating=Best_Rating;
        this.titles=title;
    }

    public Athlete( String name,int age, int height,int weight,String Matches_played,String Matches_Won,String Best_Rating,String title){
        this.name = name;
        this.age=age;
        this.height=height;
        this.weight=weight;
        this.Matches_played=Matches_played;
        this.Matches_Won=Matches_Won;
        this.Best_Rating=Best_Rating;
        this.titles=title;
    }
    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMatches_played(){
        return this.Matches_played;
    }

    public void setMatches_played(String Matches_played){
        this.Matches_played = Matches_played;
    }
    public String getMatches_Won(){
        return this.Matches_Won;
    }

    public void setMatches_Won(String Matches_Won){
        this.Matches_Won = Matches_Won;
    }
    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getHeight(){
        return this.height;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getBest_Rating() {
        return Best_Rating;
    }

    public void setBest_Rating(String best_Rating) {
        Best_Rating = best_Rating;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }
}
