package in.One.LogicDungeon;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class SerializeEnums implements Externalizable{
   public enum days {SUNDAY, MONDAY, TUESDAY}
   public days day=null;

   public void readExternal( ObjectInput in ) throws IOException,
      ClassNotFoundException {
      // TODO Auto-generated method stub
      this.day = (days) in.readObject();
      
   }

   public void writeExternal( ObjectOutput out ) throws IOException {
      // TODO Auto-generated method stub
      out.writeObject( this.day );
   }

}
