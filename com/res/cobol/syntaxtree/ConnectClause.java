//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeSequence -> ( [ &lt;K_START&gt; &lt;K_WITH&gt; SQLExpression() ] &lt;K_CONNECT&gt; &lt;K_BY&gt; SQLExpression() [ &lt;K_START&gt; &lt;K_WITH&gt; SQLExpression() ] )
 * </PRE>
 */
public class ConnectClause extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeSequence nodeSequence;

   public ConnectClause(NodeSequence n0) {
      nodeSequence = n0;
      if ( nodeSequence != null ) nodeSequence.setParent(this);
   }

   public ConnectClause() {}

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

