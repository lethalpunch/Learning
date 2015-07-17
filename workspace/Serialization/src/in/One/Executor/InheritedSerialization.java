package in.One.Executor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import in.One.LogicDungeon.ChildClass;
import in.One.LogicDungeon.SerialPersistentTest;

public class InheritedSerialization {

   public static void main( String [] args ) throws Exception {

      ChildClass cc = new ChildClass();
      cc.name = "Ankit";
      cc.secondName = "Ananad";
      File file = new File( "E://TestObject" );
      file.createNewFile();
      FileOutputStream fos = new FileOutputStream( file );
      ObjectOutputStream os = new ObjectOutputStream( fos );
      os.writeObject( cc );
      os.flush();
      os.close();
      FileInputStream fis = new FileInputStream( file );
      ObjectInputStream ois = new ObjectInputStream( fis );
      cc = (ChildClass) ois.readObject();
      System.out.println( cc.name + "  " + cc.secondName );
   }

}
