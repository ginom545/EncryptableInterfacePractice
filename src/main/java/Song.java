class Song implements Encryptable
{

  String name;
  String artist;
  int year;

  // please create the following:
  // constructor
  // encrypt
  // decrypt
  // toString
  
  public Song(String name, String artist, int year)
  {
    this.name = name;
    this.artist = artist;
    this.year = year;
  }

  public String encrypt()
  {
    String encryptedData = "";

    // encrypt name
    for (int i = this.name.length() - 1; i >= 0; i--)
    {
      char currentChar = name.charAt(i);
      int asciiValue = (int) currentChar;
      encryptedData += (asciiValue - encryptionKey) + ",";
    }
    encryptedData += ";";

    // encrypt artist
    for (int i = this.artist.length() - 1; i >= 0; i--)
    {
      char currentChar = artist.charAt(i);
      int asciiValue = (int) currentChar;
      encryptedData += (asciiValue + encryptionKey) + ",";
    }
    encryptedData += ";";

    // encrypt year
    String yearString = "" + this.year; // "1987"

    for (int i = yearString.length() - 1; i >= 0; i--)
    {
      char currentChar = yearString.charAt(i); // '7'
      int num = (int) currentChar; // 55
      encryptedData += (num * encryptionKey) + ","; // 3080
    }

    return encryptedData;
  }

  public void decrypt(String encryptedData)
  {
    String[] parts = encryptedData.split(";");

    // decrypt name
    String encryptedName = parts[0];
    String[] nameParts = encryptedName.split(",");
    String newName = "";
    for (int i = nameParts.length - 1; i >= 0; i--)
    {
      int asciiValue = Integer.parseInt(nameParts[i]) + encryptionKey;
      char currentChar = (char) asciiValue;
      newName += currentChar;
    }
    name = newName;

    // decrypt artist
    String encryptedArtist = parts[1];
    String[] artistParts = encryptedArtist.split(",");
    String newArtist = "";
    for (int i = artistParts.length - 1; i >= 0; i--)
    {
      int asciiValue = Integer.parseInt(artistParts[i]) - encryptionKey;
      char currentChar = (char) asciiValue;
      newArtist += currentChar;
    }
    artist = newArtist;

    // decrypt year
    String encryptedYear = parts[2];
    String[] yearParts = encryptedYear.split(",");
    String newYear = "";
    for (int i = yearParts.length - 1; i >= 0; i--)
    {
      int num = Integer.parseInt(yearParts[i]) / encryptionKey; // 2744 / 56 = 49
      newYear += (char) num;
    }
    year = Integer.parseInt(newYear);
  }

  public String toString()
  {
    return name + "\n" + artist + "\n" + year;
  }
  
}