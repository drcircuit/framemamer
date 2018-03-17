//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * selectWithoutOrder -> SelectWithoutOrder()
 * nodeOptional -> [ OrderByClause() ]
 * nodeOptional1 -> [ ForUpdateClause() ]
 * </PRE>
 */
public class SelectStatement extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public SelectWithoutOrder selectWithoutOrder;
   public NodeOptional nodeOptional;
   public NodeOptional nodeOptional1;

   public SelectStatement(SelectWithoutOrder n0, NodeOptional n1, NodeOptional n2) {
      selectWithoutOrder = n0;
      if ( selectWithoutOrder != null ) selectWithoutOrder.setParent(this);
      nodeOptional = n1;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      nodeOptional1 = n2;
      if ( nodeOptional1 != null ) nodeOptional1.setParent(this);
   }

   public SelectStatement() {}

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

