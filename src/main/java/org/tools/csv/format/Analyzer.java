package org.tools.csv.format;

import java.util.List;
import java.util.stream.Collectors;

import org.tools.csv.format.entity.Format;
import org.tools.csv.format.entity.Node;
import org.tools.csv.format.entity.NodeType;
import org.tools.csv.format.entity.leafnode.ColumnNameLeafNode;
import org.tools.csv.format.entity.leafnode.NullFieldNode;
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
    public Object visitParse(SelectParser.ParseContext ctx) {
        Format fmt = new Format();
        fmt.setRawColumns((List<String>)visit(ctx.select_list()));
        fmt.setNode((Node)visit(ctx.expression()));
        return fmt;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitBinaryExpression(SelectParser.BinaryExpressionContext ctx) {
        if (ctx.op.AND() != null) {
            Node node = new Node();
            node.setOp(NodeType.AND);

            node.setLhs((Node)visit(ctx.left));
            node.setRhs((Node)visit(ctx.right));

            return node;
        }

        if (ctx.op.OR() != null) {
            Node node = new Node();
            node.setOp(NodeType.OR);

            Object o = visit(ctx.left);
            node.setLhs((Node)visit(ctx.left));
            node.setRhs((Node)visit(ctx.right));

            return node;
        }

        throw new RuntimeException("Not managed: " + ctx.op.getText());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitDecimalExpression(SelectParser.DecimalExpressionContext ctx) {
        return Double.valueOf(ctx.DECIMAL().getText());
    }

    @Override
    public Object visitSliteralExpression(SelectParser.SliteralExpressionContext ctx) {
        return stripQuotes(ctx.getText());
    }

    private String stripQuotes(String text) {
        return text.substring(1, text.length()-1);
    }

    @Override
    public Object visitSelectElement(SelectParser.SelectElementContext ctx) {
        List<String> selectItems = ctx.IDENTIFIER()
                .stream()
                .map(i -> i.getText())
                .collect(Collectors.toList());

        return selectItems;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitBoolExpression(SelectParser.BoolExpressionContext ctx) {
        return Boolean.valueOf(ctx.getText());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitIdentifierExpression(SelectParser.IdentifierExpressionContext ctx) {
        String text = ctx.IDENTIFIER().getText();
        if (text != null && text.equals("null")) {

            return new NullFieldNode();
        }

        return new ColumnNameLeafNode(text);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitNotExpression(SelectParser.NotExpressionContext ctx) {
        return !((Boolean)this.visit(ctx.expression()));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitParenExpression(SelectParser.ParenExpressionContext ctx) {
        Node node = new Node();

        return node.withOp(NodeType.PARENTHESES)
                .withLhs(visit(ctx.expression()))
                .withRhs(null);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitComparatorExpression(SelectParser.ComparatorExpressionContext ctx) {
        if (ctx.op.EQ() != null) {
            Node node = new Node();

            return node.withOp(NodeType.EQ)
                    .withLhs(visit(ctx.left))
                    .withRhs(visit(ctx.right));

        }
        if (ctx.op.LE() != null) {
            Node node = new Node();

            return node.withOp(NodeType.LE)
                    .withLhs(visit(ctx.left))
                    .withRhs(visit(ctx.right));

        }
        if (ctx.op.GE() != null) {
            Node node = new Node();

            return node.withOp(NodeType.GE)
                    .withLhs(visit(ctx.left))
                    .withRhs(visit(ctx.right));

        }
        if (ctx.op.LT() != null) {
            Node node = new Node();

            return node.withOp(NodeType.LT)
                    .withLhs(visit(ctx.left))
                    .withRhs(visit(ctx.right));

        }
        if (ctx.op.GT() != null) {
            Node node = new Node();

            return node.withOp(NodeType.GT)
                    .withLhs(visit(ctx.left))
                    .withRhs(visit(ctx.right));

        }
        if (ctx.op.IS() != null) {
            Node node = new Node();

            return node.withOp(NodeType.IS)
                    .withLhs(visit(ctx.left))
                    .withRhs(visit(ctx.right));

        }
        throw new RuntimeException("not implemented: comparator operator " + ctx.op.getText());
    }

    @Override
    public Object visitLikeExpression(SelectParser.LikeExpressionContext ctx) {

        ColumnNameLeafNode cln = new ColumnNameLeafNode(ctx.IDENTIFIER().getText());
        String sliteral = stripQuotes(ctx.SLITERAL().getText());

        return new Node()
                .withOp(NodeType.LIKE)
                .withLhs(cln)
                .withRhs(sliteral);
    }

    @Override
    public Object visitInExpression(SelectParser.InExpressionContext ctx) {

        ColumnNameLeafNode cln = new ColumnNameLeafNode(ctx.IDENTIFIER().getText());

        return new Node()
                .withOp(NodeType.IN)
                .withLhs(cln)
                .withRhs(visit(ctx.obj_list()));
    }

    @Override
    public Object visitSliteralList(SelectParser.SliteralListContext ctx) {

        return ctx.SLITERAL().stream()
                .map(a -> stripQuotes(a.getText()))
                .collect(Collectors.toList());
    }

    @Override
    public Object visitDecimalList(SelectParser.DecimalListContext ctx) {

        return ctx.DECIMAL().stream()
                .map(a -> Double.parseDouble(a.getText()))
                .collect(Collectors.toList());

    }
}
