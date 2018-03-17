//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;K_WHERE&gt;
 * sQLExpression -> SQLExpression()
 * </PRE>
 */
public class WhereClause extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public SQLExpression sQLExpression;

   public WhereClause(NodeToken n0, SQLExpression n1) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      sQLExpression = n1;
      if ( sQLExpression != null ) sQLExpression.setParent(this);
   }

   public WhereClause() {}

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

