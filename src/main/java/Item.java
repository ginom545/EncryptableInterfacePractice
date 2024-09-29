class Item implements Encryptable
{
  public String name;
  public char isle;
  public double price;

  public Item(String name, char isle, double price)
  {
    this.name = name;
    this.isle = isle;
    this.price = price;
  }

  public String encrypt()
  {
    String encryptedData = "";
    
    for (int i = 0; i < this.name.length(); i++)
    {
      char currentChar = name.charAt(i);
      int asciiValue = (int) currentChar;
      encryptedData += asciiValue - (encryptionKey + 1) + ",";
    }
    encryptedData += ";";
    encryptedData += (int) isle + encryptionKey*3 + ";";
    encryptedData += price / (encryptionKey / 2);

    return encryptedData;
  }

  public void decrypt(String encryptedData)
  {
    String[] parts = encryptedData.split(";");

    // decrypt name
    String encryptedName = parts[0]; // "127,161,166,167,"
    String[] nameParts = encryptedName.split(",");
    String newName = "";
    for (int i = 0; i < nameParts.length; i++)
    {
      int asciiValue = Integer.parseInt(nameParts[i]) + (encryptionKey + 1);
      char currentChar = (char) asciiValue;
      newName += currentChar;
    }
    name = newName;

    // decrypt isle
    String encryptedIsle = parts[1];
    int encryptedIsleInt = Integer.parseInt(encryptedIsle);
    encryptedIsleInt -= (encryptionKey*3);
    isle = (char) encryptedIsleInt;

    // decrypt price
    String encryptedPrice = parts[2];
    double encryptedPriceDouble = Double.parseDouble(encryptedPrice);
    price = encryptedPriceDouble * (encryptionKey / 2); 
  }

  public String toString()
  {
    return name + "\n" + isle + "\n" + price;
  }
}