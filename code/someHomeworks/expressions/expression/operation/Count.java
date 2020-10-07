package expression.operation;

import expression.TripleExpression;
import expression.exception.evaluationException.EvaluationException;
import expression.generic.mode.AbstractMode;

public class Count<T> extends AbstractUnaryOperation<T> {
    public Count(TripleExpression<T> operand, AbstractMode<T> mode) {
        super(operand, mode);
    }

    @Override
    protected T evaluate(T first) throws EvaluationException {
        return mode.count(first);
    }

    @Override
    public String toString() {
        return "count(" + operand + ")";
    }
}
