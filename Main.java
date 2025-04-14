import java.util.*;
    class Main{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            
            String bookid,title,author;
            String userid,username,usertype,borrow;
            int userchoice,choice,num;

            Book bk = new Book();
            User user = new User();
            Book book1 = new Book("book01","The bigBang Theory","Stephen Hawking");
            Book book2 = new Book("book02","The Alchemist","Paulo cello");
            Book book3 = new Book("book03","Relativity theory","Einstein");
            Book book4 = new Book("book04","The cosmos","carl sagan");
            User user1 = new User("user01","Thirisha","Student");
            User user2 = new User("user02","Yamini","student");
            User user3 = new User("user03","yazhlini","professor");
            User user4 = new User("user04","Elio","student");
            Library lib = new Library();
          
            lib.addBook(book1);
            lib.addBook(book2);
            lib.addBook(book3);
            lib.addBook(book4);
            lib.addUser(user1);
            lib.addUser(user2);
            lib.addUser(user3);
            lib.addUser(user4);
          
            System.out.println();
            System.out.println("     *******welcome to Library!!!*******     ");
            System.out.println();

            do{
                System.out.println("1.Books section\n2.User section\n3.Exit");
                System.out.println("Enter your choice : ");
                choice = sc.nextInt();
                sc.nextLine();
            switch(choice){
                case 1:
                do{
                System.out.println("1.Add book\n2.Remove book\n3.check book availability\n4.display all Books\n5.exit");
                System.out.println("Enter your choice: ");
                num = sc.nextInt();
                sc.nextLine();
                switch(num){
                    case 1:
                    System.out.println("Enter BookId: ");
                    bookid = sc.nextLine();
                    System.out.println("Enter book title: ");
                    title = sc.nextLine();
                    System.out.println("Enter author name: ");
                    author = sc.nextLine();
                    Book book5 = new Book(bookid,title,author);
                    lib.addBook(book5);
                    break;
                    case 2:
                    System.out.println("Enter title: ");
                    title = sc.nextLine();
                    lib.removeBook(title);
                    break;
                    case 3:
                    System.out.println("enter the book title: ");
                    title = sc.nextLine();
                    lib.bookAvailable(title);
                    break;
                    case 4:
                    lib.display();
                    break;
                    case 5:
                    System.out.println("Exist the book");
                    break;
                    default:
                    System.out.println("invalid number");
                }
            }while(num<5);
                break;
                case 2:
                do{
                System.out.println("1.Add user\n2.Remove user\n3.Borrow book\n4.Return book\n5.display borrowed books\n6.display user\n7.display user borrowed books\n8.exit");
                System.out.println("Enter your choice");
                userchoice = sc.nextInt();
            sc.nextLine();
                switch(userchoice){
                    case 1:
                    System.out.println("Enter userID: ");
                    userid = sc.nextLine();
                    System.out.println("Enter username: ");
                    username = sc.nextLine();
                    System.out.println("Enter usertype: ");
                    usertype = sc.nextLine();
                    User us = new User(userid,username,usertype);
                    lib.addUser(us);
                    break;
                    case 2:
                    System.out.println("Enter username: ");
                    username = sc.nextLine();
                    lib.removeUser(username);
                    break;
                    case 3:
                    System.out.println("Enter the username: ");
                    username = sc.nextLine();
                    System.out.println("Enter the book name you want to borrow: ");
                    borrow = sc.nextLine();
                    lib.borrowBook(username,borrow);
                    break;
                    case 4:
                    System.out.println("Enter the username: ");
                    username = sc.nextLine();
                    System.out.println("enter the book name you want to return: ");
                    title = sc.nextLine();
                    lib.returnBook(username,title);
                    break;
                    case 5:
                    lib.displayBorrowedBooks();
                    break;
                    case 6:
                    lib.displayUser();
                    break;
                    case 7:
                    System.out.println("enter the username: ");
                    username = sc.nextLine();
                    lib.displayUserborrowedBooks(username);
                    break;
                    case 8:
                    System.out.println("Exist the user");
                    break;
                    default:
                    System.out.println("Invalid user");
                }
            }while(userchoice<8);
                break;
                case 3:
                System.out.println("Exit the library");
                break;
                default:
                System.out.println("Invalid number");

            }
        }while(choice<3);
        sc.close();

        }
    }
