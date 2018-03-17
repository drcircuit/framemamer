//
// Generated by JTB 1.3.2
//

package com.res.cobol.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;EVALUATE&gt;
 * evaluateValue -> EvaluateValue()
 * nodeListOptional -> ( &lt;ALSO&gt; EvaluateValue() )*
 * nodeList -> ( ( &lt;WHEN&gt; [ &lt;EQUALCHAR&gt; ] EvaluatePhrase() ( &lt;ALSO&gt; EvaluatePhrase() )* )+ StatementList() )+
 * nodeOptional -> [ &lt;WHEN&gt; &lt;OTHER&gt; StatementList() ]
 * nodeOptional1 -> [ &lt;END_EVALUATE&gt; ]
 * </PRE>
 */
public class EvaluateStatement extends com.res.cobol.RESNode implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public EvaluateValue evaluateValue;
   public NodeListOptional nodeListOptional;
   public NodeList nodeList;
   public NodeOptional nodeOptional;
   public NodeOptional nodeOptional1;

   public EvaluateStatement(NodeToken n0, EvaluateValue n1, NodeListOptional n2, NodeList n3, NodeOptional n4, NodeOptional n5) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      evaluateValue = n1;
      if ( evaluateValue != null ) evaluateValue.setParent(this);
      nodeListOptional = n2;
      if ( nodeListOptional != null ) nodeListOptional.setParent(this);
      nodeList = n3;
      if ( nodeList != null ) nodeList.setParent(this);
      nodeOptional = n4;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      nodeOptional1 = n5;
      if ( nodeOptional1 != null ) nodeOptional1.setParent(this);
   }

   public EvaluateStatement() {}

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

