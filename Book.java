public class Book{
        String BookId;
        String Title;
        String Author;
        boolean bookAvailable=true;
        public Book(){
    //....
        }

        public Book(String bookid,String title, String author){
            this.BookId = bookid;
            this.Title = title;
            this.Author = author;
        }

        public boolean getbookAvailable(){
            return bookAvailable;
        }
