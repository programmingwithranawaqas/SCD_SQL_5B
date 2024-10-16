public class Main {
    public static void main(String[] args) {
//        new Loading();

        DatabaseHandler dbHandler= new DatabaseHandler();
        //dbHandler.createTable();
        //int i = dbHandler.insertStudent("Adnan Chota", "03020231302", "Batch-15");
        int id = dbHandler.getId("Adnan Chota", "03020231302", "Batch-16");
        if( id!=-1 )
        {
            System.out.println("ID : "+ id);
        }
        //dbHandler.delete(1);
        //dbHandler.update(2, "Batch-16");
    }
}