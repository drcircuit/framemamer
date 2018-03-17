//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * plSqlExpotentExpressions -> PlSqlExpotentExpressions()
 * nodeList -> ( ( "*" | "/" ) PlSqlExpotentExpressions() )+
 * </PRE>
 */
public class PlSqlMultiplicativeExpression extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public PlSqlExpotentExpressions plSqlExpotentExpressions;
   public NodeList nodeList;

   public PlSqlMultiplicativeExpression(PlSqlExpotentExpressions n0, NodeList n1) {
      plSqlExpotentExpressions = n0;
      if ( plSqlExpotentExpressions != null ) plSqlExpotentExpressions.setParent(this);
      nodeList = n1;
      if ( nodeList != null ) nodeList.setParent(this);
   }

   public PlSqlMultiplicativeExpression() {}

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

