package in.One.Executor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import in.One.LogicDungeon.*;


public class SerialPersistentFieldsTest {

   public static void main( String [] args ) throws Exception {

      SerialPersistentTest spt = new SerialPersistentTest();
      spt.nameAsTransient = "ABC";
      spt.nameNotToSerialize = "DEF";
      spt.nameToSerialize = "FGH";
      File file = new File( "E://Temp//TestObject" );
      FileOutputStream fos = new FileOutputStream( file );
      ObjectOutputStream os = new ObjectOutputStream( fos );
      os.writeObject( spt );
      os.flush();
      os.close();
      FileInputStream fis = new FileInputStream( file );
      ObjectInputStream ois = new ObjectInputStream( fis );
      SerialPersistentTest sp = (SerialPersistentTest) ois.readObject();
      System.out.println(sp.nameToSerialize);
      System.out.println(sp.nameAsTransient);
      System.out.println(sp.nameNotToSerialize);
   }

}
