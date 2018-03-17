//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;IF&gt;
 * condition -> Condition()
 * nodeOptional -> [ &lt;THEN&gt; ]
 * nodeChoice -> ( StatementList() [ &lt;NEXT&gt; &lt;SENTENCE&gt; ] | &lt;NEXT&gt; &lt;SENTENCE&gt; )
 * nodeOptional1 -> [ &lt;ELSE&gt; ( StatementList() [ &lt;NEXT&gt; &lt;SENTENCE&gt; ] | &lt;NEXT&gt; &lt;SENTENCE&gt; ) ]
 * nodeOptional2 -> [ &lt;END_IF&gt; ]
 * </PRE>
 */
public class IfStatement extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public Condition condition;
   public NodeOptional nodeOptional;
   public NodeChoice nodeChoice;
   public NodeOptional nodeOptional1;
   public NodeOptional nodeOptional2;

   public IfStatement(NodeToken n0, Condition n1, NodeOptional n2, NodeChoice n3, NodeOptional n4, NodeOptional n5) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      condition = n1;
      if ( condition != null ) condition.setParent(this);
      nodeOptional = n2;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      nodeChoice = n3;
      if ( nodeChoice != null ) nodeChoice.setParent(this);
      nodeOptional1 = n4;
      if ( nodeOptional1 != null ) nodeOptional1.setParent(this);
      nodeOptional2 = n5;
      if ( nodeOptional2 != null ) nodeOptional2.setParent(this);
   }

   public IfStatement() {}

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

