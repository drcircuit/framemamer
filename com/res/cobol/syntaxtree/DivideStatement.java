//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;DIVIDE&gt;
 * divideBody -> DivideBody()
 * nodeOptional -> [ [ &lt;ON&gt; ] &lt;SIZE&gt; &lt;ERROR&gt; StatementList() ]
 * nodeOptional1 -> [ &lt;NOT&gt; [ &lt;ON&gt; ] &lt;SIZE&gt; &lt;ERROR&gt; StatementList() ]
 * nodeOptional2 -> [ &lt;END_DIVIDE&gt; ]
 * </PRE>
 */
public class DivideStatement extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public DivideBody divideBody;
   public NodeOptional nodeOptional;
   public NodeOptional nodeOptional1;
   public NodeOptional nodeOptional2;

   public DivideStatement(NodeToken n0, DivideBody n1, NodeOptional n2, NodeOptional n3, NodeOptional n4) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      divideBody = n1;
      if ( divideBody != null ) divideBody.setParent(this);
      nodeOptional = n2;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      nodeOptional1 = n3;
      if ( nodeOptional1 != null ) nodeOptional1.setParent(this);
      nodeOptional2 = n4;
      if ( nodeOptional2 != null ) nodeOptional2.setParent(this);
   }

   public DivideStatement() {}

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
