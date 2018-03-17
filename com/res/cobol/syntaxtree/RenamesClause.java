//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;RENAMES&gt;
 * qualifiedDataName -> QualifiedDataName()
 * nodeOptional -> [ ( &lt;THROUGH&gt; | &lt;THRU&gt; ) QualifiedDataName() ]
 * </PRE>
 */
public class RenamesClause extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public QualifiedDataName qualifiedDataName;
   public NodeOptional nodeOptional;

   public RenamesClause(NodeToken n0, QualifiedDataName n1, NodeOptional n2) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      qualifiedDataName = n1;
      if ( qualifiedDataName != null ) qualifiedDataName.setParent(this);
      nodeOptional = n2;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
   }

   public RenamesClause() {}

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

