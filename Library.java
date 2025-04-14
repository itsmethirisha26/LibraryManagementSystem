import java.util.*;
    public class Library{
        Map<String,Book> rack = new LinkedHashMap<>();
        Map<String,User> userentry = new LinkedHashMap<>();
        List<Book> allBorrowedbooks = new ArrayList<>();

        public void addBook(Book bk){
            for(String key:rack.keySet()){
                if(key.equalsIgnoreCase(bk.Title)){
                    System.out.println("book is already there");
                    return;
                }
            }
            if(rack.isEmpty()){
                rack.put(bk.Title,bk);
                System.out.println("Book added successfully");
            }
            else{
                if(!rack.containsKey(bk.Title)){
                    rack.put(bk.Title,bk);
                    System.out.println(bk.Title+" book added successfully");
                }
                else{
                    System.out.println("Book already exist");
                }
            }
        }

        public void removeBook(String Title){
            boolean found =false;
            for(String key:rack.keySet()){
                if(key.equalsIgnoreCase(Title)){
                    found=true;
                    rack.remove(Title);
                    System.out.println(Title+"Book removed successfully");
                }
            }
            if(!found){
                System.out.println("book not found");
            }
        }

        public void bookAvailable(String title){
            boolean found= false;
            for(String key: rack.keySet()){
            if(key.equalsIgnoreCase(title)){
                System.out.println("yes!! the book is Available");
                System.out.println();
                found = true;
            }
        }
        if(!found){
            System.out.println("The book is not available");
        }
        }

        public void display(){
            for(Map.Entry<String,Book> entry : rack.entrySet()){
                Book obj = entry.getValue();
                System.out.println(obj);
            }
            System.out.println();
        }

        public void addUser(User uss){
            for(String key: userentry.keySet()){
                if(key.equalsIgnoreCase(uss.getUserName())){
                    System.out.println("user already exist");
                    return;
                }
            }
            for (User user : userentry.values()) {
                if (user.getUserId().equalsIgnoreCase(uss.getUserId())) {
                    System.out.println("User ID already exists!");
                    return;
                }
            }
            if(userentry.isEmpty()){
                userentry.put(uss.getUserName(),uss);
                System.out.println("User added successfully!");
                System.out.println();
            }
            else{
                if(!userentry.containsKey(uss.getUserName())){
                    userentry.put(uss.getUserName(),uss);
                    System.out.println("User added successfully!");
                }
                else{
                    System.out.println("user not exist");
                }
            }
        }

        public void removeUser(String name){
            boolean found = false;
            for(String key:userentry.keySet()){
                if(key.equalsIgnoreCase(name)){
                    userentry.remove(name);
                    found=true;
                    System.out.println("user removed successfully!");
                    System.out.println();
                }
            }
            if(!found){
                System.out.println("user not exist");
            }
        }

        public void borrowBook(String username,String title){
            Boolean found = false;
            String matchedbook = null;
            String matchedname= null;
            for(String key: rack.keySet()){
            if(key.equalsIgnoreCase(title)){
                matchedbook=key;
                found=true;
            }
        }
        if(!found){
            System.out.println("book is not available");
            return;
        }
        boolean name = false;
        for(String key:userentry.keySet()){
            if(key.equalsIgnoreCase(username)){
                matchedname=key;
                name=true;
            }
        }
            if(!name){
                System.out.println("user is not a member-cannot borrow this book\n");
                return;
            }
            User user = userentry.get(matchedname);
            if(!user.canMorebookBorrow()){
                System.out.println("you have reached the borrowing limit.!!");
                return;
            }
            Book book = rack.get(matchedbook);
            if(!book.getbookAvailable()){
            System.out.println("The book is already borrowed by someone");
            return;
            }
            book.SetBookAvailable(false);
            userentry.get(matchedname).Setaddborrowbooks(book);
            allBorrowedbooks.add(book);
            System.out.println("book borrowed successfully by "+matchedname);
        }

        public void returnBook(String username, String title){
            boolean name=false;
            String matchedbook=null;
            String matcheduser=null;
            for(String key: userentry.keySet()){
                if(key.equalsIgnoreCase(username)){
                    matcheduser=key;
                    name=true;
                }
            }
            if(!name){
            System.out.println("user is not a member");
            return;
            }
            boolean found = false;
            for(String key: rack.keySet()){
                if(key.equalsIgnoreCase(title)){
                    matchedbook=key;
                    found=true;
                }
            }
            if(!found){
            System.out.println("book is not exist");
            return;
            }
            Book book = rack.get(matchedbook);
            User user = userentry.get(matcheduser);
            if(user.getborrowbooks().contains(book)){
                book.SetBookAvailable(true);
                user.SetremoveborrowBook(book);
                allBorrowedbooks.remove(book);
                System.out.println("The book returned successfully by "+matcheduser);
                System.out.println();
                return;
            }
            if(user.getborrowbooks().isEmpty()){
                System.out.println(matcheduser+" no more books borrowed");
            }
            else{
                System.out.println(matcheduser+" not borrowed this book");
            }
        }

        public void displayUser(){
            for(Map.Entry<String,User> entry: userentry.entrySet()){
                User objUser = entry.getValue();
                System.out.println(objUser);
                System.out.println();
            }
        }

        public void displayUserborrowedBooks(String username){
            for(String key : userentry.keySet()){
                if(key.equalsIgnoreCase(username)){
                    userentry.get(key).displayBorrowedBooks();
                    return;
                }
            }
            System.out.println("user not exist");
        }

        public void displayBorrowedBooks(){
            if(allBorrowedbooks.isEmpty()){
            System.out.println("the user not borrowed any book");
            System.out.println();
            }
            else{
                System.out.println("Borrowed Books:-");
            for(Book bk: allBorrowedbooks){
                System.out.println("->"+bk.Title); 
            }
            }
        }

    }
