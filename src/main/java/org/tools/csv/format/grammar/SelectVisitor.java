// Generated from ./src/main/resources/Select.g4 by ANTLR 4.5.1
package org.tools.csv.format.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SelectParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SelectVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code QueryExpression}
	 * labeled alternative in {@link SelectParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpression(SelectParser.QueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectList}
	 * labeled alternative in {@link SelectParser#select_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(SelectParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectElement}
	 * labeled alternative in {@link SelectParser#select_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectElement(SelectParser.SelectElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrFilterExpr}
	 * labeled alternative in {@link SelectParser#filter_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilterExpr(SelectParser.OrFilterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExprt}
	 * labeled alternative in {@link SelectParser#filter_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExprt(SelectParser.ParenExprtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleFilter}
	 * labeled alternative in {@link SelectParser#filter_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFilter(SelectParser.SimpleFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndFilterExpr}
	 * labeled alternative in {@link SelectParser#filter_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilterExpr(SelectParser.AndFilterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BasicFilter}
	 * labeled alternative in {@link SelectParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicFilter(SelectParser.BasicFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InopFilter}
	 * labeled alternative in {@link SelectParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInopFilter(SelectParser.InopFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LikeFilter}
	 * labeled alternative in {@link SelectParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeFilter(SelectParser.LikeFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link SelectParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(SelectParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link SelectParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(SelectParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatLiteral}
	 * labeled alternative in {@link SelectParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(SelectParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolLiteral}
	 * labeled alternative in {@link SelectParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(SelectParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralColName}
	 * labeled alternative in {@link SelectParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralColName(SelectParser.LiteralColNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralListExpr}
	 * labeled alternative in {@link SelectParser#literal_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralListExpr(SelectParser.LiteralListExprContext ctx);
}