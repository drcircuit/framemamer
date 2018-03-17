//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeChoice -> ( Identifier() | Literal() | &lt;LPARENCHAR&gt; ArithmeticExpression() &lt;RPARENCHAR&gt; )
 * </PRE>
 */
public class Basis extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeChoice nodeChoice;

   public Basis(NodeChoice n0) {
      nodeChoice = n0;
      if ( nodeChoice != null ) nodeChoice.setParent(this);
   }

   public Basis() {}

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

