package pkg01;
import pkg02.OutsidePackage;

/*
 * アクセス修飾子の習得
 */
public class AccessModifierTest {

 public static void main(String[] args) {
    Modifiers m = new Modifiers();

    System.out.println(m.publicMessage);     //public宣言されたフィールドには、クラス外のどこからでもアクセス可能。
    System.out.println(m.defaultMessage);    //デフォルトアクセス修飾子のフィールドには、同じパッケージ内ならアクセス可。
    //System.out.println(m.privateMessage);  //private宣言されたフィールドには、クラス外からは一切アクセスできない。

    System.out.println(Modifiers.publicStaticMessage);     //public宣言されたフィールドには、クラス外のどこからでもアクセス可能。
    System.out.println(Modifiers.defaultStaticMessage);    //デフォルトアクセス修飾子のフィールドには、同じパッケージ内ならアクセス可。
    //System.out.println(Modifiers.privateStaticMessage);  //private宣言されたフィールドには、クラス外からは一切アクセスできない。

    m.getMessagesPublic();      //publicメソッドは、クラス外のどこからでもアクセス可能。
    m.getMessagesDefault();     //デフォルトアクセス修飾子のメソッドは、同じパッケージ内ならアクセス可能。
    //m.getMessagesPrivate();   　private宣言されたメソッドは、クラス外からは一切アクセスできない。
    m.getPrivateFields();       //public宣言されたメソッドを経由することで、外部クラスのprivateフィールドやprivateメソッドにアクセスできる。

    //パッケージの外のクラスのフィールドに対するアクセス
    OutsidePackage o = new OutsidePackage();
    System.out.println(o.publicMessage);        //public宣言されていればどこからでもアクセス可
    //System.out.println(o.defaultMessage);     デフォルト宣言の場合、パッケージ外からはアクセス不可
    //System.out.println(o.privateMessage);     private宣言されていれば当然、外からはアクセス不可

    System.out.println(m.calc(10, 20));
    System.out.println(m.calc(10, 20, 5));

   }
}

    /*
     * アクセス修飾子確認用フィールド
     */
    class Modifiers {
      public String publicMessage = "a";
      String defaultMessage = "b";
      private String privateMessage = "c";

      public static String publicStaticMessage = "aaa";
      static String defaultStaticMessage = "bbb";
      private static String privateStaticMessage = "ccc";

      //publicなメソッド
      public void getMessagesPublic() {
         System.out.println(this.publicMessage + " " + this.defaultMessage + " " + this.privateMessage);
      }

      //デフォルトアクセス修飾子のメソッド
      void getMessagesDefault() {
         System.out.println(this.publicMessage + " " + this.defaultMessage + " " + this.privateMessage);
      }

      //privateアクセス修飾子のメソッド
      public void getMessagesPrivate() {
         System.out.println(this.publicMessage + " " + this.defaultMessage + " " + this.privateMessage);
      }
      
      //public宣言されたメソッドの内部ならprivateフィールドにアクセスできる例
      public String getPrivateFields() {
         this.getMessagesPrivate();
         return Modifiers.privateStaticMessage + " " + this.privateMessage;
      }

      //a と b を乗算
      public int calc(int a, int b) {
         return a * b;
      }

      //calcメソッドのオーバーロード
      //a と b と c の乗算
      public int calc(int a, int b, int c) {
         return a * b * c;
      }
      
 }