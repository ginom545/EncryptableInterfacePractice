public class Main 
{
  public static void main(String[] args) 
  {

    // create a Customer object ... any data is fine
    // call the encrypt function, store the return value into a String
    // print that String

    // G 71 ... 127
    // i 105 ... 161
    // n 110 ... 166
    // o 111 ... 167
    
    /*
    Customer user1 = new Customer("Gino", 63.50, 20);
    System.out.println(user1); // object data before encrpytion
    String beforeEncrpytion = user1.toString();
    String encryptedUser = user1.encrypt();
    System.out.println(encryptedUser);    
    user1.decrypt(encryptedUser);
    System.out.println(user1); // object data after encrpytion (should match what it was before encrpytion)
    String afterEncrpytion = user1.toString();
    System.out.println(beforeEncrpytion.equals(afterEncrpytion));

    System.out.println();
    
    Item item = new Item("Banana", 'C', 0.99);
    beforeEncrpytion = item.toString();
    System.out.println(item);
    String encryptedItem = item.encrypt();
    System.out.println(encryptedItem);
    item.decrypt(encryptedItem);
    afterEncrpytion = item.toString();
    System.out.println(item);
    System.out.println(beforeEncrpytion.equals(afterEncrpytion));
    */

    Song song = new Song("Never Gonna Give You Up", "Rick Astley", 1987);
    String beforeEncryption = song.toString();
    System.out.println(song);
    String encryptedSong = song.encrypt();
    System.out.println(encryptedSong);
    song.decrypt(encryptedSong);
    String afterEncryption = song.toString();
    System.out.println(song);
    System.out.println(beforeEncryption.equals(afterEncryption));
  }
}