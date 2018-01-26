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
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public Object visitComparator(SelectParser.ComparatorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public Object visitBinary(SelectParser.BinaryContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    //@Override public Object visitBool(SelectParser.BoolContext ctx) { return visitChildren(ctx); }
    /*
    @Override
    public Object visitQueryExpression(SelectParser.QueryExpressionContext ctx) {
        System.out.println("visitQueryExpression");
        Format fmt = new Format();

        fmt.setRawColumns((List<String>)visitChildren(ctx.select_list()));

        fmt.setNode((Node)visitChildren(ctx.filter_expr()));

        return fmt;
    }

    @Override public Object visitSelectList(SelectParser.SelectListContext ctx) {
        System.out.println("visitSelectList");
        List<String> rawSelectItems = ctx.select_element()
            .stream()
            .map(i -> i.getText())
            .collect(Collectors.toList());

        return rawSelectItems;
    }

    @Override public Object visitSelectElement(SelectParser.SelectElementContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitOrFilterExpr(SelectParser.OrFilterExprContext ctx) {
        System.out.println("visitOrFilterExpr");
        Node node = new Node();
        node.setOp(NodeType.OR);

        node.setLhs((Node)visitChildren(ctx.filter_expr(0)));
        node.setRhs((Node)visitChildren(ctx.filter_expr(1)));

        return node;
    }
    @Override
    public Object visitParenExpr(SelectParser.ParenExprContext ctx) {
        System.out.println("visitParenExpr");
        return visitChildren(ctx.filter_expr());
    }

    @Override
    public Object visitSimpleFilter(SelectParser.SimpleFilterContext ctx) {
        System.out.println("visitSimpleFilter");
        Object obj = visitChildren(ctx.filter());
        return obj;
    }

    @Override
    public Object visitAndFilterExpr(SelectParser.AndFilterExprContext ctx) {
        System.out.println("visitAndFilterExpr");
        Node node = new Node();
        node.setOp(NodeType.AND);

        node.setLhs((Node)visitChildren(ctx.filter_expr(0)));
        node.setRhs((Node)visitChildren(ctx.filter_expr(1)));

        return node;
    }

    @Override
    public Object visitBasicFilter(SelectParser.BasicFilterContext ctx) {
        System.out.println("visitBasicFilter");
        Node node = new Node();
        node.setOp(NodeType.fromString(ctx.OP().getText()));

        String l1 = ctx.literal(0).getText();
        String l2 = ctx.literal(1).getText();

        Object o1 = visitChildren(ctx.literal(0));
        Object o2 = visitChildren(ctx.literal(1));

        node.setLhsLeaf((LeafNode)visitChildren(ctx.literal(0)));
        node.setRhsLeaf((LeafNode)visitChildren(ctx.literal(1)));

        return node;
    }
    @Override
    public Object visitInopFilter(SelectParser.InopFilterContext ctx) {
        System.out.println("visitInopFilter");
        Node node = new Node();
        node.setOp(NodeType.IN);

        node.setLhsLeaf(new ColumnNameLeafNode(ctx.COL_NAME().getText()));
        node.setRhsLeaf((LeafNode)visitChildren(ctx.literal_list()));

        return node;
    }

    @Override
    public Object visitLikeFilter(SelectParser.LikeFilterContext ctx) {
        System.out.println("visitLikeFilter");
        Node node = new Node();
        node.setOp(NodeType.LIKE);

        node.setLhsLeaf(new ColumnNameLeafNode(ctx.COL_NAME().getText()));
        node.setRhsLeaf(new LiteralLeafNode(ctx.WORD().getText()));
        return node;
    }
    @Override
    public Object visitStringLiteral(SelectParser.StringLiteralContext ctx) {
        System.out.println("visitStringLiteral");
        return new StringLiteralLeafNode(ctx.getText());
    }
    @Override
    public Object visitIntLiteral(SelectParser.IntLiteralContext ctx) {
        System.out.println("visitIntLiteral");

        return new IntegerLeafNode(Integer.parseInt(ctx.getText()));
    }
    @Override
    public Object visitFloatLiteral(SelectParser.FloatLiteralContext ctx) {
        System.out.println("visitFloatLiteral");
        return new FloatLeafNode(Double.parseDouble(ctx.getText()));
    }
    @Override
    public Object visitBoolLiteral(SelectParser.BoolLiteralContext ctx) {
        System.out.println("visitBoolLiteral");
        if (ctx.getText().toLowerCase().equals("true")) {
            return new BooleanLeafNode(new Boolean(true));
        }

        return new BooleanLeafNode(new Boolean(false));
    }
    @Override
    public Object visitLiteralColName(SelectParser.LiteralColNameContext ctx) {
        System.out.println("visitLiteralColName");

        return new ColumnNameLeafNode(ctx.getText());
    }
    @Override
    public Object visitLiteralListExpr(SelectParser.LiteralListExprContext ctx) {
        System.out.println("visitLiteralListExpr");

        List<String> literalList = ctx.SLITERAL()
                .stream()
                .map(a -> a.getText())
                .collect(Collectors.toList());


        return new LiteralListLeafNode(literalList);
    }
    */
}
