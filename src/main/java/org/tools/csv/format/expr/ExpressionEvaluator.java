package org.tools.csv.format.expr;

import org.tools.csv.format.entity.Node;
import org.tools.csv.format.entity.ProcessMetadata;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ExpressionEvaluator {

    private Node root;

    private ProcessMetadata metadata;

    private Comparator comparator;

    public ExpressionEvaluator(Node rt, ProcessMetadata mdt) {
        this.root = rt;
        this.metadata = mdt;
        this.comparator = new Comparator(metadata);
    }

    public Boolean evaluate(String[] row) {

        return inev(root, row);
    }

    private Boolean inev(Node node, String[] row) {

        Node lhs,rhs;

        switch (node.getOp()) {
            case AND:
                lhs = assertNode(node.getLhs());
                rhs = assertNode(node.getRhs());

                return inev(lhs, row) && inev(rhs, row);

            case OR:
                lhs = assertNode(node.getLhs());
                rhs = assertNode(node.getRhs());

                return inev(lhs, row) || inev(rhs, row);

            case EQ:
            case GT:
            case GE:
            case LT:
            case LE:
            case NE:
            case LIKE:
            case IS:
            case IN:
                return this.comparator.evalute(node, row);

            default:
                throw new RuntimeException(node.getOp() + " is not handeled!");

        }
    }

    private Node assertNode(Object obj) {
        if (obj instanceof Node) {
            return (Node) obj;
        }

        String json = "";
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            json = jsonMapper.writeValueAsString(this.root);

        } catch (Exception e) {

            log.error("Failed to parse root: ", e);
        }

        throw new RuntimeException("Error with grammer: Internal bug!!!: Please report, root: " + json);
    }
}
