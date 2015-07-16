package in.One.LogicDungeon;

import java.io.ObjectStreamField;
import java.io.Serializable;



public class SerialPersistentTest implements Serializable {

   public String nameToSerialize;
   public String nameNotToSerialize;
   public String nameAsTransient;
   private static final ObjectStreamField [] serialPersistentFields = { new java.io.ObjectStreamField(
      "nameNotToSerialize", String.class ) };

}
