//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * power -> Power()
 * nodeListOptional -> ( ( &lt;ASTERISKCHAR&gt; | &lt;SLASHCHAR&gt; ) Power() )*
 * </PRE>
 */
public class TimesDiv extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public Power power;
   public NodeListOptional nodeListOptional;

   public TimesDiv(Power n0, NodeListOptional n1) {
      power = n0;
      if ( power != null ) power.setParent(this);
      nodeListOptional = n1;
      if ( nodeListOptional != null ) nodeListOptional.setParent(this);
   }

   public TimesDiv() {}

   public void accept(com.res.cobol.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(com.res.cobol.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(com.res.cobol.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(com.res.cobol.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}
