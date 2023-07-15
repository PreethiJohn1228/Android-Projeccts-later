package com.example.ex5;

public class Books {
    int id;
    String title;
    int price;
    String author;
    String borrowdate;
    String returndate;
    String genre;
    public Books(){   }
    public Books(int id, String title,String author, int price,String borrowdate,String returndate,String genre){
        this.id = id;
        this.title = title;
        this.author=author;
        this.price=price;
        this.borrowdate=borrowdate;
        this.returndate=returndate;
        this.genre=genre;
    }
    public Books(String title,String author, int price,String borrowdate,String returndate,String genre){
        this.title = title;
        this.author=author;
        this.price=price;
        this.borrowdate=borrowdate;
        this.returndate=returndate;
        this.genre=genre;
    }
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getBorrowdate(){
        return this.borrowdate;
    }
    public void setBorrowdate(String borrowdate){
        this.borrowdate= borrowdate;
    }

    public String getReturndate(){
        return this.returndate;
    }
    public void setReturndate(){
        this.returndate = returndate;
    }
    public String getGenre()
    {
        return this.genre;
    }

    public void setGenre(){
        this.genre = genre;
    }

    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }

}
