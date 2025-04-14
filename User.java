import java.util.*;
  public class User {
      private String userid,userName,userType;
      private List<Book> borrowbooks= new ArrayList<>();
      public static final int MAX_LIMIT = 3;
      public User(){

      }

    public User(String userid,String username,String usertype){
      this.userid = userid;
      this.userName = username;
      this.userType = usertype; 
      //borrowbooks = new ArrayList<>();  
    }

    public Boolean canMorebookBorrow(){
      return borrowbooks.size() < MAX_LIMIT;
    }

    public String getUserId(){
      return userid;
    }

    public String getUserName(){
      return userName;
    }

    public String getUserType(){
      return userType;
    }

    public String toString(){
      return String.format("%-20s%-10s%-20s",userid,userName,userType);
    }

    public void Setaddborrowbooks(Book obj){
        borrowbooks.add(obj);
    }

    public List<Book> getborrowbooks(){
      return borrowbooks;
    }

    public void SetremoveborrowBook(Book obj){
      borrowbooks.remove(obj);
    }

    public void displayBorrowedBooks(){
      if(borrowbooks.isEmpty()){
        System.out.println("you haven't borrowed any book");
        System.out.println();
      }
      else{
        for(Book bk: borrowbooks){
            System.out.println("->"+bk.Title);
        }
      }
  }

  }
