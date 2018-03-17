//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeOptional -> [ &lt;K_NOT&gt; ]
 * nodeToken -> &lt;K_LIKE&gt;
 * sQLSimpleExpression -> SQLSimpleExpression()
 * </PRE>
 */
public class SQLLikeClause extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeOptional nodeOptional;
   public NodeToken nodeToken;
   public SQLSimpleExpression sQLSimpleExpression;

   public SQLLikeClause(NodeOptional n0, NodeToken n1, SQLSimpleExpression n2) {
      nodeOptional = n0;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      nodeToken = n1;
      if ( nodeToken != null ) nodeToken.setParent(this);
      sQLSimpleExpression = n2;
      if ( sQLSimpleExpression != null ) sQLSimpleExpression.setParent(this);
   }

   public SQLLikeClause() {}

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

