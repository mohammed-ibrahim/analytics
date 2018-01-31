package org.tools.csv.format.expr;

import org.tools.csv.format.entity.Node;
import org.tools.csv.format.entity.ProcessMetadata;
import org.tools.csv.format.entity.VersatileData;
import org.tools.csv.format.entity.VersatileDataType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Comparator {

    private ProcessMetadata metadata;
    public Comparator(ProcessMetadata pmd) {
        this.metadata = pmd;
    }

    public Boolean evalute(Node node, String[] row) {

        VersatileData lhsData = new VersatileData(node.getLhs(), row, this.metadata);
        VersatileData rhsData = new VersatileData(node.getRhs(), row, this.metadata);

        if (!isValidComparision(node, lhsData, rhsData)) {

            return Boolean.FALSE;
        }

        switch (node.getOp()) {
            case EQ:
                return lhsData.isEquals(rhsData);

            case GT:
                return (lhsData.getDoubleValue() > rhsData.getDoubleValue());

            case GE:
                return (lhsData.getDoubleValue() >= rhsData.getDoubleValue());

            case LT:
                return (lhsData.getDoubleValue() < rhsData.getDoubleValue());

            case LE:
                return (lhsData.getDoubleValue() <= rhsData.getDoubleValue());

            case NE:
                return handleNotEquals(lhsData, rhsData);

            case LIKE:
                return lhsData.getStrValue().matches(rhsData.getStrValue().replaceAll("%", ".*"));

            case IN:
                return handleIn(lhsData, rhsData);

            case IS:
                return handleIs(lhsData, rhsData);

            default:
                throw new RuntimeException("Comparision of: " + node.getOp().toString() + " is not handeled");
        }
    }

    private Boolean handleIs(VersatileData lhsData, VersatileData rhsData) {
        return lhsData.getType().equals(VersatileDataType.NULL) ?
                Boolean.TRUE : Boolean.FALSE;
    }

    private Boolean handleIn(VersatileData lhsData, VersatileData rhsData) {

        if (lhsData.getType().equals(VersatileDataType.STRING)) {

            return rhsData.getListValue().contains(lhsData.getStrValue());
        } else if (lhsData.getType().equals(VersatileDataType.DOUBLE)) {

            return rhsData.getListValue().contains(lhsData.getDoubleValue());
        }

        log.error("Not supposed to come to this place, but somehow missed!!");
        return Boolean.FALSE;
    }

    private Boolean handleNotEquals(VersatileData lhsData, VersatileData rhsData) {
        if (lhsData.getType().equals(VersatileDataType.DOUBLE)
                && rhsData.getType().equals(VersatileDataType.DOUBLE)) {

            return !(lhsData.getDoubleValue().equals(rhsData.getDoubleValue()));
        }

        if (lhsData.getType().equals(VersatileDataType.STRING)
                && rhsData.getType().equals(VersatileDataType.STRING)) {

            return !(lhsData.getStrValue().equals(rhsData.getStrValue()));
        }

        if (lhsData.getType().equals(VersatileDataType.NULL)
                && rhsData.getType().equals(VersatileDataType.NULL)) {

            return Boolean.FALSE;
        }

        if (lhsData.getType().equals(VersatileDataType.DOUBLE)
                && rhsData.getType().equals(VersatileDataType.NULL)) {

            return Boolean.TRUE;
        }

        if (lhsData.getType().equals(VersatileDataType.NULL)
                && rhsData.getType().equals(VersatileDataType.DOUBLE)) {

            return Boolean.TRUE;
        }

        log.error("Not able to handle with lhs-type: {} and rhs-type: {}", lhsData.getType().toString(), rhsData.getType().toString());
        return Boolean.FALSE;
    }

    private boolean isValidComparision(Node node, VersatileData lhsData, VersatileData rhsData) {

        switch (node.getOp()) {
            case GT:
            case LT:
            case GE:
            case LE:
                if (lhsData.getType().equals(VersatileDataType.DOUBLE)
                        && rhsData.getType().equals(VersatileDataType.DOUBLE)) {

                    return Boolean.TRUE;
                } else {

                    return Boolean.FALSE;
                }

            case EQ:
                if (lhsData.getType().equals(VersatileDataType.DOUBLE)
                        && rhsData.getType().equals(VersatileDataType.DOUBLE)) {

                    return Boolean.TRUE;
                }

                if (lhsData.getType().equals(VersatileDataType.STRING)
                        && rhsData.getType().equals(VersatileDataType.STRING)) {

                    return Boolean.TRUE;
                }

                return Boolean.FALSE;

            case IN:
                if (lhsData.getType().equals(VersatileDataType.DOUBLE)
                        && rhsData.getType().equals(VersatileDataType.LIST)) {

                    return Boolean.TRUE;
                }

                if (lhsData.getType().equals(VersatileDataType.STRING)
                        && rhsData.getType().equals(VersatileDataType.LIST)) {

                    return Boolean.TRUE;
                }

                return Boolean.FALSE;

            case NE:
                if (lhsData.getType().equals(VersatileDataType.DOUBLE)
                        && rhsData.getType().equals(VersatileDataType.DOUBLE)) {

                    return Boolean.TRUE;
                }

                if (lhsData.getType().equals(VersatileDataType.STRING)
                        && rhsData.getType().equals(VersatileDataType.STRING)) {

                    return Boolean.TRUE;
                }

                if (lhsData.getType().equals(VersatileDataType.NULL)
                        && rhsData.getType().equals(VersatileDataType.DOUBLE)) {

                    return Boolean.TRUE;
                }

                if (lhsData.getType().equals(VersatileDataType.DOUBLE)
                        && rhsData.getType().equals(VersatileDataType.NULL)) {

                    return Boolean.TRUE;
                }

                if (lhsData.getType().equals(VersatileDataType.NULL)
                        && rhsData.getType().equals(VersatileDataType.STRING)) {

                    return Boolean.TRUE;
                }

                if (lhsData.getType().equals(VersatileDataType.STRING)
                        && rhsData.getType().equals(VersatileDataType.NULL)) {

                    return Boolean.TRUE;
                }

                return Boolean.FALSE;

            case LIKE:
                if (lhsData.getType().equals(VersatileDataType.STRING)
                        && rhsData.getType().equals(VersatileDataType.STRING)) {

                    return Boolean.TRUE;
                }

                return Boolean.FALSE;

            default:
                return Boolean.FALSE;
        }
    }
}
