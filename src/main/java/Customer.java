class Customer implements Encryptable
{

  public String username;
  public double balance;
  public int savingsPoints;

  public Customer(String username, double balance, int savingsPoints)
  {
    this.username = username;
    this.balance = balance;
    this.savingsPoints = savingsPoints;
  }
  
  // encrypt will take the data of this Customer object
  // and use the encryptionKey from the Encryptable interface
  // to "mask" this data into a String
  public String encrypt()
  {
    String encryptedData = "";
    // write a for loop that goes through each character of username
    for (int i = 0; i < this.username.length(); i++)
    {
      char currentChar = username.charAt(i);
      int asciiValue = (int) currentChar;
      encryptedData += asciiValue + encryptionKey + ",";
    }
    encryptedData += ";";
    encryptedData += (balance + encryptionKey*2) + ";";
    encryptedData += (savingsPoints * encryptionKey) + ";";
    return encryptedData;
  }

  // decrypt will interpret an encrypted data string
  // and replace the data that already exists in this Customer object
  // with the data specified by the encryptedData String
  public void decrypt(String encryptedData)
  {
    // split encryptedData by ";" delimiter
    // example: 
    // String encryptedData is "127,161,166,167,;175.5;1120;"
    // String[] parts will be {"127,161,166,167,", "175.5", "1120"} (no ;s present)
    String[] parts = encryptedData.split(";");

    // decrypt username
    String encryptedUsername = parts[0]; // "127,161,166,167,"
    String[] usernameParts = encryptedUsername.split(","); // {"127", "161", "166", "167"}
    String newUsername = "";
    for (int i = 0; i < usernameParts.length; i++)
    {
      int asciiValue = Integer.parseInt(usernameParts[i]) - encryptionKey;
      char currentChar = (char) asciiValue;
      newUsername += currentChar;
    }
    username = newUsername;
    
    // decrypt balance
    String encryptedBalanceString = parts[1]; // "175.5"
    double encryptedBalanceDouble = Double.parseDouble(encryptedBalanceString); // 175.5
    balance = encryptedBalanceDouble - encryptionKey*2;
      
    // decrypt savingsPoints
    String encryptedSavingsPointsString = parts[2]; // "1120"
    int encryptedSavingsPointsInt = Integer.parseInt(encryptedSavingsPointsString); // 1120
    savingsPoints = encryptedSavingsPointsInt / encryptionKey;
      
  }

  public String toString()
  {
    return username + "\n" + balance + "\n" + savingsPoints;
  }
  
}