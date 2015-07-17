package in.One.Executor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import in.One.LogicDungeon.SerialPersistentTest;
import in.One.LogicDungeon.SerializeEnums;
import in.One.LogicDungeon.SerializeEnums.days;


public class EnumExternalizationExecutor {

   public static void main (String...strings) throws Exception {
      SerializeEnums en = new SerializeEnums();
      en.day = days.TUESDAY;
      File file = new File( "E://Temp//TestObject" );
      FileOutputStream fos = new FileOutputStream( file );
      ObjectOutputStream os = new ObjectOutputStream( fos );
      os.writeObject( en );
      os.flush();
      os.close();
      FileInputStream fis = new FileInputStream( file );
      ObjectInputStream ois = new ObjectInputStream( fis );
      SerializeEnums sp = (SerializeEnums) ois.readObject();
      System.out.println(sp.day);
   }
}
