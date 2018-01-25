package org.tools.csv.format;

import java.util.List;
import java.util.stream.Collectors;

import org.tools.csv.format.entity.Format;
import org.tools.csv.format.entity.Node;
import org.tools.csv.format.entity.NodeType;
import org.tools.csv.format.entity.leafnode.BooleanLeafNode;
import org.tools.csv.format.entity.leafnode.ColumnNameLeafNode;
import org.tools.csv.format.entity.leafnode.FloatLeafNode;
import org.tools.csv.format.entity.leafnode.IntegerLeafNode;
import org.tools.csv.format.entity.leafnode.LeafNode;
import org.tools.csv.format.entity.leafnode.LiteralLeafNode;
import org.tools.csv.format.entity.leafnode.LiteralListLeafNode;
import org.tools.csv.format.entity.leafnode.StringLiteralLeafNode;
import org.tools.csv.format.grammar.SelectBaseVisitor;
import org.tools.csv.format.grammar.SelectParser;

public class Analyzer extends SelectBaseVisitor<Object> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitQueryExpression(SelectParser.QueryExpressionContext ctx) {
        Format fmt = new Format();

        fmt.setRawColumns((List<String>)visitChildren(ctx.select_list()));

        fmt.setNode((Node)visitChildren(ctx.filter_expr()));

        return fmt;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSelectList(SelectParser.SelectListContext ctx) {

        List<String> rawSelectItems = ctx.select_element()
            .stream()
            .map(i -> i.getText())
            .collect(Collectors.toList());

        return rawSelectItems;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSelectElement(SelectParser.SelectElementContext ctx) { return visitChildren(ctx); }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitOrFilterExpr(SelectParser.OrFilterExprContext ctx) {
        Node node = new Node();
        node.setOp(NodeType.OR);

        node.setLhs((Node)visitChildren(ctx.filter_expr(0)));
        node.setRhs((Node)visitChildren(ctx.filter_expr(1)));

        return node;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitParenExpr(SelectParser.ParenExprContext ctx) {

        return visitChildren(ctx.filter_expr());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitSimpleFilter(SelectParser.SimpleFilterContext ctx) {
        Object obj = visitChildren(ctx.filter()); 
        return obj;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitAndFilterExpr(SelectParser.AndFilterExprContext ctx) {
        Node node = new Node();
        node.setOp(NodeType.AND);

        node.setLhs((Node)visitChildren(ctx.filter_expr(0)));
        node.setRhs((Node)visitChildren(ctx.filter_expr(1)));

        return node;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitBasicFilter(SelectParser.BasicFilterContext ctx) {
        Node node = new Node();
        node.setOp(NodeType.fromString(ctx.OP().getText()));

        node.setLhsLeaf((LeafNode)visitChildren(ctx.literal(0)));
        node.setRhsLeaf((LeafNode)visitChildren(ctx.literal(1)));

        return node;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitInopFilter(SelectParser.InopFilterContext ctx) {
        Node node = new Node();
        node.setOp(NodeType.IN);
        
        node.setLhsLeaf(new ColumnNameLeafNode(ctx.COL_NAME().getText()));
        node.setRhsLeaf((LeafNode)visitChildren(ctx.literal_list()));

        return node;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitLikeFilter(SelectParser.LikeFilterContext ctx) {
        Node node = new Node();
        node.setOp(NodeType.LIKE);

        node.setLhsLeaf(new ColumnNameLeafNode(ctx.COL_NAME().getText()));
        node.setRhsLeaf(new LiteralLeafNode(ctx.WORD().getText()));
        return node;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitStringLiteral(SelectParser.StringLiteralContext ctx) {

        return new StringLiteralLeafNode(ctx.getText());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitIntLiteral(SelectParser.IntLiteralContext ctx) {

        return new IntegerLeafNode(Integer.parseInt(ctx.getText()));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitFloatLiteral(SelectParser.FloatLiteralContext ctx) {

        return new FloatLeafNode(Double.parseDouble(ctx.getText()));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitBoolLiteral(SelectParser.BoolLiteralContext ctx) {
        if (ctx.getText().toLowerCase().equals("true")) {
            return new BooleanLeafNode(new Boolean(true));
        }

        return new BooleanLeafNode(new Boolean(false));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitLiteralColName(SelectParser.LiteralColNameContext ctx) {

        return new ColumnNameLeafNode(ctx.getText());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitLiteralListExpr(SelectParser.LiteralListExprContext ctx) {
        
        List<String> literalList = ctx.SLITERAL()
                .stream()
                .map(a -> a.getText())
                .collect(Collectors.toList());
        
        
        return new LiteralListLeafNode(literalList);
    }
}
